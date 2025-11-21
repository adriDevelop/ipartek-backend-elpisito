package com.ipartek.spring.elpisito.apirest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {

	// Este es el controlador global de los errores. Es invocado por Spring
	// automaticamente cuando se produce un error saltandose la cadena StackTrace
	// Controlador -> Servicio -> Error -> Llamada a ApiExceptionHandler ->
	// @RestControllerAdvice -> cliente

	private ResponseEntity<ErrorResponseDto> build(HttpStatus status, Exception ex, HttpServletRequest req) {

		ErrorResponseDto errorResponse = new ErrorResponseDto(
				status.value(), // Código de error
				status.getReasonPhrase(), // Razón del error
				ex.getMessage(), // Mensaje del error
				req.getRequestURI() // Obtenemos la URI del HttpServlet
		);

		return new ResponseEntity<ErrorResponseDto>(errorResponse, status);
	}

	@ExceptionHandler(DatosInvalidosException.class)
	public ResponseEntity<ErrorResponseDto> datosInvalidos(DatosInvalidosException exception, HttpServletRequest req) {
		return build(HttpStatus.BAD_REQUEST, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> errorBaseDeDatos(ErrorBaseDeDatosException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> errorInternoServidor(ErrorInternoServidorException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> formatoNoSoportadoException(FormatoNoSoportadoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> noAutenticadoException(NoAutenticadoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> noAutorizadoException(NoAutorizadoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> peticionMalFormadaException(PeticionMalFormadaException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> recursoEnUsoException(RecursoEnUsoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> recursoNoEncontradoException(RecursoNoEncontradoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> recursoYaExistenteException(RecursoYaExistenteException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseDto> tokenExpiradoException(TokenExpiradoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}
}
