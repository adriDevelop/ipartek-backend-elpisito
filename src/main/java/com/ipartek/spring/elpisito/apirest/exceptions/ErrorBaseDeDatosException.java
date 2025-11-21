package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class ErrorBaseDeDatosException extends RuntimeException{

	// Error de servidor base de datos
	// Fallo en la base de datos: Error al realizar una operación de lectura-escritura en la BBDD
	@Serial
	private static final long serialVersionUID = 7281811427268587801L;

	public ErrorBaseDeDatosException(String message) {
		super(message);
	}
	
}
