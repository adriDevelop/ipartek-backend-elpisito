package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class PeticionMalFormadaException extends RuntimeException{
	
	// Petición mal formada: Campos incorrectos o faltantes, cadenas mal formadas en una URI
	@Serial
	private static final long serialVersionUID = 1669302263507389499L;

	public PeticionMalFormadaException(String message) {
		super(message);
	}
	
	

}
