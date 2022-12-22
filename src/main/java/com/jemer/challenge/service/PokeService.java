package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;

public interface PokeService {

        public Root getPokeModels(String offset, String limit);

        public RootPokemon getPokemonModels();

        PokemonDesafioDto getDatos(String pokemonId);

        ListaPokeInfoBasicaDto getListaInfoBasicaPokemon(String offset, String limit);

        public ListaMovimientosDto getListaMovimientosPokemon(String offset, String limit);
}


