package com.ipartek.spring.elpisito.apirest.exceptions;

public class MultipartVacioException extends RuntimeException{

	private static final long serialVersionUID = -5455374202017661179L;
	
	public MultipartVacioException(String message) {
		super(message);
	}

}
