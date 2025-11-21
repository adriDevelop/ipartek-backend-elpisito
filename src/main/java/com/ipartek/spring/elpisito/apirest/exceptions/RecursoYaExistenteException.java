package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class RecursoYaExistenteException extends RuntimeException{

	// Recurso ya existente: Intentar crear un usuario y que ya exista en la base de datos
	@Serial
	private static final long serialVersionUID = 2222548612657410285L;

	public RecursoYaExistenteException(String message) {
		super(message);
	}
	
	

}
