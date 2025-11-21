package com.ipartek.spring.elpisito.apirest.exceptions;

import java.io.Serial;

public class TokenExpiradoException extends RuntimeException{

	// Error de autenticación y autorización
	// Token expirado: JWT caducado
	@Serial
	private static final long serialVersionUID = 107606268189304106L;

	public TokenExpiradoException(String message) {
		super(message);
	}
	
	

}
