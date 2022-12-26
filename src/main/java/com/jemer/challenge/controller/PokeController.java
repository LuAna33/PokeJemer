package com.jemer.challenge.controller;

import com.jemer.challenge.dto.*;
import com.jemer.challenge.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@RestController
@RequestMapping("/pokemon")
@Validated
public class PokeController {
    @Autowired
    private PokeService pokeService;

    @GetMapping("/listaInfoBasica")
    public ResponseInfoBasicaDto getInfoBasicaPokemon(@Valid @NotNull @NotBlank (message = "COMPLETAR, VACIO NO PERMITIDO") @RequestParam String offset,
                                                      @Valid @NotNull @NotBlank(message = "COMPLETAR, VACIO NO PERMITIDO") @RequestParam String limit){
        return pokeService.getInfoBasicaPokemon(offset, limit);
    }

    @GetMapping("/listaDetallePokemon")
    public ResponsePokemonConsultaInfoDetalladaDto getInfoDetalladaPokemon(@Valid @NotNull @NotBlank(message = "COMPLETAR, VACIO NO PERMITIDO") @RequestParam String pokemonId){
        return pokeService.getInfoDetalladaPokemon(pokemonId);
    }

}