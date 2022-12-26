package com.jemer.challenge.dto;

import lombok.*;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListaMovimientosDto {
    public List<PokemonInfoDetalladaDto> listaPokeMovimientoDetalle;


}
