package com.jemer.challenge.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokemonInfoBasicaDto {
    private int id;
    private String name;
    private FotoPokemonDto sprites;
    private List<TipoDto> types;
    private int weight;
    private List<HabilidadesDto> abilities;
}

































