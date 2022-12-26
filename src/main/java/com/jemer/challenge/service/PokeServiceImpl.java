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
    public ResponseInfoBasicaDto getInfoBasicaPokemon(String offset, String limit) {

        List<PokemonInfoBasicaDto> listaInfoBasica = new ArrayList<>();

        ResponseEntity<ResponseConsultaPokemonDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon?offset=".concat(String.valueOf(offset)).concat("&limit=").concat(String.valueOf(limit)),
                        ResponseConsultaPokemonDto.class);
        ResponseConsultaPokemonDto pokelista = response.getBody();

        for (ResultDto pokemonId:pokelista.results) {
            ResponseEntity<PokemonInfoBasicaDto> responsePokemon =
                    restTemplate.getForEntity(pokemonId.getUrl(), PokemonInfoBasicaDto.class);
            PokemonInfoBasicaDto pokeModelResponse = responsePokemon.getBody();
            listaInfoBasica.add(pokeModelResponse);
        }

        List<ResponsePokemonConsultaInfoBasicaDto> listaRespuesta = new ArrayList<>();
        for (PokemonInfoBasicaDto pokemonInfoBasicaDto:listaInfoBasica) {
            List<String> listaHabilidades = new ArrayList<>();
            List<String> listaTipos = new ArrayList<>();

            for (HabilidadesDto habilidadesDto:pokemonInfoBasicaDto.getAbilities()) {
                listaHabilidades.add(habilidadesDto.getHabilidad().getName());
            }
            for (TipoDto tipoDto: pokemonInfoBasicaDto.getTypes()) {
                listaTipos.add(tipoDto.getTipo().getName());
            }
            ResponsePokemonConsultaInfoBasicaDto respuesta= ResponsePokemonConsultaInfoBasicaDto.builder()
                    .foto(pokemonInfoBasicaDto.getSprites().getFront_default())
                    .nombre(pokemonInfoBasicaDto.getName())
                    .peso(pokemonInfoBasicaDto.getWeight())
                    .habilidades(listaHabilidades)
                    .tipo(listaTipos)
                    .build();
            listaRespuesta.add(respuesta);
        }
        ResponseInfoBasicaDto responseInfoBasicaDto = ResponseInfoBasicaDto.builder()
                .responseInfoBasicaPokemons(listaRespuesta)
                .build();

        return responseInfoBasicaDto;

    }
        public ResponsePokemonConsultaInfoDetalladaDto getInfoDetalladaPokemon(String pokemonId) {

        ResponseEntity<PokemonInfoDetalladaDto> response =
                restTemplate.getForEntity(
                        "https://pokeapi.co/api/v2/pokemon/".concat(pokemonId),
                        PokemonInfoDetalladaDto.class);

        PokemonInfoDetalladaDto pokemonInfoBasicaDto= response.getBody();

            List<String> listaHabilidades = new ArrayList<>();
            List<String> listaTipos = new ArrayList<>();
            List<String> listaMovimientos = new ArrayList<>();


            for (HabilidadesDto habilidadesDto:pokemonInfoBasicaDto.getAbilities()) {
                listaHabilidades.add(habilidadesDto.getHabilidad().getName());
            }
            for (TipoDto tipoDto: pokemonInfoBasicaDto.getTypes()) {
                listaTipos.add(tipoDto.getTipo().getName());
            }
            for (MovimientosDto movimientosDto: pokemonInfoBasicaDto.getMoves()) {
                listaMovimientos.add(movimientosDto.getMovimiento().getName());
            }

            ResponsePokemonConsultaInfoBasicaDto respuesta= ResponsePokemonConsultaInfoBasicaDto.builder()
                    .foto(pokemonInfoBasicaDto.getSprites().getFront_default())
                    .nombre(pokemonInfoBasicaDto.getName())
                    .peso(pokemonInfoBasicaDto.getWeight())
                    .habilidades(listaHabilidades)
                    .tipo(listaTipos)
                    .build();

            ResponsePokemonConsultaInfoDetalladaDto responseDetalle = ResponsePokemonConsultaInfoDetalladaDto.builder()
                    .infoBasicaDto(respuesta)
                    .movimientos(listaMovimientos)
                    .build();
        return responseDetalle;


    }

}