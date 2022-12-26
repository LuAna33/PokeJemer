package com.jemer.challenge.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoPokemonDto {
    private String name;
    @JsonIgnore
    private String url;
}