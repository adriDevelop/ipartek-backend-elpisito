package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class DatosInvalidosException extends RuntimeException{
	
	// Datos invalidos: Datos con formato incorrecto Email mal formado, fecha mal formada
	@Serial
	private static final long serialVersionUID = 3207624925278263393L;

	public DatosInvalidosException(String message) {
		super(message);
	}
	
	
}
