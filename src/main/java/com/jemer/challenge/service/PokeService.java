package com.jemer.challenge.service;
import com.jemer.challenge.dto.*;

public interface PokeService {

        ListaPokeInfoBasicaDto getInfoBasicaPokemon(String offset, String limit);

        public ListaMovimientosDto getInfoDetalladaPokemon(String offset, String limit);
}


