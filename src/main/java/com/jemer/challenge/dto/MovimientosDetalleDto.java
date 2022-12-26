package com.jemer.challenge.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovimientosDetalleDto {
    public String name;
    @JsonIgnore
    public String url;
}