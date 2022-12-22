package com.jemer.challenge.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PokeModel {

    private String nombrePokemon ;
    private String tipoPokemon;
    private Integer idPokemon;
    private String habilidades;
    private Integer peso;

}
