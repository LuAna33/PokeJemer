package com.jemer.challenge.dto;

import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseConsultaPokemonDto {
    public ArrayList<ResultDto> results;
}
