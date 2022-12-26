package com.jemer.challenge.dto;

import java.util.ArrayList;

public class PokemonInfoDetalladaDto {
    public int id;
    public String name;
    public FotoDto sprites;
    public ArrayList<TipoDto> types;
    public int weight;
    public ArrayList<HabilidadesDto> abilities;
    public ArrayList<MovimientosDto> moves;

}
