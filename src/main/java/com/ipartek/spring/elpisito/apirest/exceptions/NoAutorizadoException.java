package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class NoAutorizadoException extends RuntimeException{

	// Error de autorización
	// Usuario no autorizado: no tiene permisos de acceso a un area de la api de la base de datos
	@Serial
	private static final long serialVersionUID = -255520450270178834L;

	public NoAutorizadoException(String message) {
		super(message);
	}
	
	

}
