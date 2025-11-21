package com.ipartek.spring.elpisito.apirest.exceptions;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
	
	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String message;
	private String path;
	
	public ErrorResponseDto(int status, String error, String message, String path) {
		this.timestamp = LocalDateTime.now();
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

}
