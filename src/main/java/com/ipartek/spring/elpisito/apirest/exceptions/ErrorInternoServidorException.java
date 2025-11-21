package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class ErrorInternoServidorException extends RuntimeException{

	// Error interno servidor: Error interno genérico es una excepción general no controlada
	@Serial
	private static final long serialVersionUID = 7865235348956301519L;

	public ErrorInternoServidorException(String message) {
		super(message);
	}
	
	

}
