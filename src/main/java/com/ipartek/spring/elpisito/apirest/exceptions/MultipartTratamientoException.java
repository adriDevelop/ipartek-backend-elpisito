package com.ipartek.spring.elpisito.apirest.exceptions;

public class MultipartTratamientoException extends RuntimeException{

	private static final long serialVersionUID = -931330830538980548L;
	
	public MultipartTratamientoException(String message) {
		super(message);
	}
}
