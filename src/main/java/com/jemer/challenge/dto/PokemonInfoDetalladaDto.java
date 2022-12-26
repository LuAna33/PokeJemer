package com.jemer.challenge.dto;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonInfoDetalladaDto {
    private int id;
    private String name;
    private FotoPokemonDto sprites;
    private ArrayList<TipoDto> types;
    private int weight;
    private ArrayList<HabilidadesDto> abilities;
    private ArrayList<MovimientosDto> moves;

}
