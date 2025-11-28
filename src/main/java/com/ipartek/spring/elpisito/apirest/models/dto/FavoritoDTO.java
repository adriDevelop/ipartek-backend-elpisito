package com.ipartek.spring.elpisito.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FavoritoDTO {

	private Long idInmueble;
	private String nombreTipo;
	private String nombrePoblacion;
	private String nombreProvincia;
	private String nombreOperacion;
	private Double precio;
	private String nombreInmobiliaria;
	
}
