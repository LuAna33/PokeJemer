package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;

public interface PokeService {

    ResponseInfoBasicaDto getInfoBasicaPokemon(String offset, String limit);

    ResponsePokemonConsultaInfoDetalladaDto getInfoDetalladaPokemon(String pokemonId);
}


