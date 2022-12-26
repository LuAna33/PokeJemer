package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoDto {
    @JsonProperty("type")
    private TipoPokemonDto tipo;

}