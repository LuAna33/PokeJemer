package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MovimientosDto {

    @JsonProperty("move")
    public MovimientosDetalleDto movimiento;

}

