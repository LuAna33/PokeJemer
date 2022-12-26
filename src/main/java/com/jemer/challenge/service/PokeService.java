package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;

public interface PokeService {

        InfoBasicaDto getInfoBasicaPokemon(String offset, String limit);

         PokemonInfoDetalladaDto getInfoDetalladaPokemon(String pokemonId);
}


