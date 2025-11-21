package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class RecursoEnUsoException extends RuntimeException{

	// Recurso en uso: No podemos borrar un recurso de la base de datos porque tiene relaciones activas. Se trata de no romper integridad referencias de la base de datos.
	@Serial
	private static final long serialVersionUID = -3697620440480710310L;

	public RecursoEnUsoException(String message) {
		super(message);
	}
	
	

}
