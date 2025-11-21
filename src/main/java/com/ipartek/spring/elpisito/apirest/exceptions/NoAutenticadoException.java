package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class NoAutenticadoException extends RuntimeException{
	
	// Errores de autenticación
	// Usuario no autenticado No hay token o token no es válido (caducado)
	@Serial
	private static final long serialVersionUID = -2775570026061189291L;

	public NoAutenticadoException(String message) {
		super(message);
	}
	
	

}
