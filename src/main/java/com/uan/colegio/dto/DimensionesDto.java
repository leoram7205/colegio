package com.uan.colegio.dto;

import java.util.UUID;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DimensionesDto {
    private UUID dmLlave;
    private ColegiosDto colegiosDto;
    private String dmCodigo;
	private String dmNombre;
    private Boolean dmEstado;
}
