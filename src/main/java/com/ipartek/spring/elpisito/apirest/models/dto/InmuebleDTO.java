package com.ipartek.spring.elpisito.apirest.models.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class InmuebleDTO {
	
	// Un DTO (Data Transfer Object) sirve para separar las capas de una aplicación especialmente la capa de presentación de una PAI Rest de la capa de datos (entidades de la BBDD)
	// Esto se logra creando clases simples con atributos que representen los datos que realmente necesitamos transferir, evitando exponer la estructura interna de las entidades de negocio.
	
	// ¿Para qué sirve un DTO en Spring?
	// 1) Separación de responsabilidades
	// Permite que las distintas capas de una aplicación tengan distintas responsabilidades y no dependan indirectamente unas de otras.
	// 2) Flexibilidad y control
	// Un DTO puede contener solo los datos necesarios para una operación específica evitando exponer información sensible o irrelevante de las entidades de la BBDD.
	// 3) Transferencia de datos simplificada
	// Facilita la tranferencia de datos entre las distintas partes de la aplicación en volumen haciendo este proceso más ligero.
	// 4) Mejora el rendimiento
	// Al enviar menos datos en una sola respuesta se puede reducir el tráfico de la red y mejorar el rendimiento de la aplicación.
	// 5) Facilita la reutilización de código
	// Los dtos pueden ser utilizados en diferentes partes de la aplicación que requieran los mismos datos.
	// 6) Protección de entidades
	// Los DTOs ayudan a proteger las entidades de la BBDD de cambios no deseados o de exposición a capas externas.

	private Long id;
}
