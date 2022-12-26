package com.jemer.challenge.controller;

import com.jemer.challenge.dto.*;
import com.jemer.challenge.service.PokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokeController {
    @Autowired
    private PokeService pokeService;

    @GetMapping("/listaInfoBasica")
    public ListaPokeInfoBasicaDto getListaInfoBasicaPokemon(@RequestParam String offset, @RequestParam String limit){
        return pokeService.getInfoBasicaPokemon(offset, limit);
    }

    @GetMapping("/listaDetallePokemon")
    public ListaMovimientosDto getListaMovimientosPokemon(@RequestParam String offset, @RequestParam String limit){
        return pokeService.getListaMovimientosPokemon(offset, limit);
    }

}