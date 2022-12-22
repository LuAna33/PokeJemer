package com.jemer.challenge.controller;

import com.jemer.challenge.dto.*;
import com.jemer.challenge.model.PokeModel;
import com.jemer.challenge.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokeController {
    @Autowired
    private PokeService pokeService;


    @GetMapping("/listaApi")
    public Root getPokeModels(@RequestParam String offset, @RequestParam String limit){
        Root pokeModels= pokeService.getPokeModels(offset, limit);
        return pokeModels;
    }
    @GetMapping("/listaApi2")
    public RootPokemon getPokemonModels(){
        RootPokemon pokeModels= pokeService.getPokemonModels();
        return pokeModels;
    }
    @GetMapping("/listaApi3")
    public PokemonDesafioDto getPokemon(@RequestParam String pokemonId){
        return pokeService.getDatos(pokemonId);
    }

    @GetMapping("/listaApi4")
    public ListaPokeInfoBasicaDto getListaInfoBasicaPokemon(@RequestParam String offset, @RequestParam String limit){
        return pokeService.getListaInfoBasicaPokemon(offset, limit);
    }

    @GetMapping("/listaApi5")
    public ListaMovimientosDto getListaMovimientosPokemon(@RequestParam String offset, @RequestParam String limit){
        return pokeService.getListaMovimientosPokemon(offset, limit);
    }

}