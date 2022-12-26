package com.jemer.challenge.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponsePokemonConsultaInfoBasicaDto {
       private String nombre;
       private String foto;
       private List<String> tipo;
       private Integer peso;
       public List<String> habilidades;
}
