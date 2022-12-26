package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovimientosDto {

    @JsonProperty("move")
    public MovimientosDetalleDto movimiento;

}

