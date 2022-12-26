package com.jemer.challenge.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabilidadesDetalleDto {

        private String name;
        @JsonIgnore
        private String url;
}
