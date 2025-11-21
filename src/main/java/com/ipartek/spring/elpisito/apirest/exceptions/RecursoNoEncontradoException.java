package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class RecursoNoEncontradoException extends RuntimeException{

	// Recurso no encontrado: Intentar localizar cualquier elemento con id que no exista en la base de datos.
	@Serial
	private static final long serialVersionUID = -6655576615122402116L;

	public RecursoNoEncontradoException(String message) {
		super(message);
	}
}
