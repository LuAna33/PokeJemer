package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;
import com.jemer.challenge.model.PokeModel;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Log
public class  PokeServiceImpl implements PokeService {

    @Autowired
    RestTemplate restTemplate = new RestTemplate();
    public Root getPokeModels(String offset, String limit){
        ResponseEntity<Root> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        Root.class);
        Root pokeModels = response.getBody();
        return pokeModels;
    }

    @Autowired
    RestTemplate restTemplate2 = new RestTemplate();
    public RootPokemon getPokemonModels( ){
        ResponseEntity<RootPokemon> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon/21/",
                        RootPokemon.class);
        RootPokemon pokeModels = response.getBody();
        return pokeModels;
    }

    @Override
    public PokemonDesafioDto getDatos(String pokemonId) {
            ResponseEntity< PokemonDesafioDto> response =
                    restTemplate.getForEntity(
                            "https://pokeapi.co/api/v2/pokemon/".concat(pokemonId).concat("/"),
                            PokemonDesafioDto.class);
            PokemonDesafioDto pokeModels = response.getBody();
            return pokeModels;
    }

    @Autowired
    RestTemplate restTemplate3 = new RestTemplate();
    @Override
    public ListaPokeInfoBasicaDto getListaInfoBasicaPokemon(String offset, String limit) {
        List<PokemonDesafioDto> listaDetalle=new ArrayList<>();

        ResponseEntity<Root> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        Root.class);
        Root pokelista = response.getBody();

        for (Result pokemonId:pokelista.results) {
            ResponseEntity<PokemonDesafioDto> responsePokemon =
                    restTemplate.getForEntity(pokemonId.url, PokemonDesafioDto.class);
            PokemonDesafioDto pokeModelResponse = responsePokemon.getBody();
            listaDetalle.add(pokeModelResponse);
        }

        ListaPokeInfoBasicaDto listaRespuesta= ListaPokeInfoBasicaDto.builder()
                .listaPokemonDetalle(listaDetalle)
                .build();
        return listaRespuesta;

    }
    public ListaMovimientosDto getListaMovimientosPokemon(String offset, String limit) {
        List<PokemonDesafioDto2> listaDetalleMovimientos = new ArrayList<>();
        ResponseEntity<Root> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        Root.class);
        Root pokelista = response.getBody();

        for (Result pokemonId:pokelista.results) {
            ResponseEntity<PokemonDesafioDto2> responsePokemon =
                    restTemplate.getForEntity(pokemonId.url, PokemonDesafioDto2.class);
            PokemonDesafioDto2 pokeModelResponse = responsePokemon.getBody();
            listaDetalleMovimientos.add(pokeModelResponse);
        }

        ListaMovimientosDto listaMovimientosRespuesta= ListaMovimientosDto.builder()
                .listaPokeMovimientoDetalle(listaDetalleMovimientos)
                .build();
        return listaMovimientosRespuesta;

    }
}