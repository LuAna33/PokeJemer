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
    @Override
    public InfoBasicaDto getInfoBasicaPokemon(String offset, String limit) {

        List<PokemonInfoBasicaDto> listaInfoBasica = new ArrayList<>();

        ResponseEntity<ResponseConsultaPokemonDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        ResponseConsultaPokemonDto.class);
        ResponseConsultaPokemonDto pokelista = response.getBody();

        for (ResultDto pokemonId:pokelista.results) {
            ResponseEntity<PokemonInfoBasicaDto> responsePokemon =
                    restTemplate.getForEntity(pokemonId.url, PokemonInfoBasicaDto.class);
            PokemonInfoBasicaDto pokeModelResponse = responsePokemon.getBody();
            listaInfoBasica.add(pokeModelResponse);
        }

        InfoBasicaDto listaRespuesta= InfoBasicaDto.builder()
                .infoBasicaPokemon(listaInfoBasica)
                .build();
        return listaRespuesta;

    }
        public PokemonInfoDetalladaDto getInfoDetalladaPokemon(String pokemonId) {
        //List<PokemonInfoDetalladaDto> pokemonDetalle = new ArrayList<>();
        ResponseEntity<PokemonInfoDetalladaDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon/".concat(pokemonId),
                        PokemonInfoDetalladaDto.class);
        return response.getBody();


    }
}