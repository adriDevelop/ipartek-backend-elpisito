package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class FormatoNoSoportadoException extends RuntimeException{

	// Formato no soportado: Por ejemplo enviar a local storage un pdf cuando solo está permitido jpg
	@Serial
	private static final long serialVersionUID = 2947862331403197786L;

	public FormatoNoSoportadoException(String message) {
		super(message);
	}
	
}