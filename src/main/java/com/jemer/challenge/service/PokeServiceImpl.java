package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Log
public class  PokeServiceImpl implements PokeService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    RestTemplate restTemplate3 = new RestTemplate();
    @Override
    public ListaPokeInfoBasicaDto getInfoBasicaPokemon(String offset, String limit) {
        List<PokemonInfoBasicaDto> listaDetalle=new ArrayList<>();

        ResponseEntity<ResponseConsultaPokemonDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        ResponseConsultaPokemonDto.class);
        ResponseConsultaPokemonDto pokelista = response.getBody();

        for (ResultDto pokemonId:pokelista.results) {
            ResponseEntity<PokemonInfoBasicaDto> responsePokemon =
                    restTemplate.getForEntity(pokemonId.url, PokemonInfoBasicaDto.class);
            PokemonInfoBasicaDto pokeModelResponse = responsePokemon.getBody();
            listaDetalle.add(pokeModelResponse);
        }

        ListaPokeInfoBasicaDto listaRespuesta= ListaPokeInfoBasicaDto.builder()
                .listaPokemonDetalle(listaDetalle)
                .build();
        return listaRespuesta;

    }
    public ListaMovimientosDto getInfoDetalladaPokemon(String offset, String limit) {
        List<PokemonInfoDetalladaDto> listaDetalleMovimientos = new ArrayList<>();
        ResponseEntity<ResponseConsultaPokemonDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        ResponseConsultaPokemonDto.class);
        ResponseConsultaPokemonDto pokelista = response.getBody();

        for (ResultDto pokemonId:pokelista.results) {
            ResponseEntity<PokemonInfoDetalladaDto> responsePokemon =
                    restTemplate.getForEntity(pokemonId.url, PokemonInfoDetalladaDto.class);
            PokemonInfoDetalladaDto pokeModelResponse = responsePokemon.getBody();
            listaDetalleMovimientos.add(pokeModelResponse);
        }

        ListaMovimientosDto listaMovimientosRespuesta= ListaMovimientosDto.builder()
                .listaPokeMovimientoDetalle(listaDetalleMovimientos)
                .build();
        return listaMovimientosRespuesta;

    }
}