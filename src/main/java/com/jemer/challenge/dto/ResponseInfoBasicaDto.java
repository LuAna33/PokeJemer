package com.jemer.challenge.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseInfoBasicaDto {
    public List<ResponsePokemonConsultaInfoBasicaDto> responseInfoBasicaPokemons;
}
