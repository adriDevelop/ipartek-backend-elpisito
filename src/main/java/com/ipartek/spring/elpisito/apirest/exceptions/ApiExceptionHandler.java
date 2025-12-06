package com.ipartek.spring.elpisito.apirest.exceptions;

import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.NoSuchFileException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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

	@ExceptionHandler(ErrorBaseDeDatosException.class)
	public ResponseEntity<ErrorResponseDto> errorBaseDeDatos(ErrorBaseDeDatosException exception,
			HttpServletRequest req) {
		return build(HttpStatus.CONFLICT, exception, req);
	}

//	@ExceptionHandler(ErrorInternoServidorException.class)
//	public ResponseEntity<ErrorResponseDto> errorInternoServidor(ErrorInternoServidorException exception,
//			HttpServletRequest req) {
//		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
//	}

	@ExceptionHandler(FormatoNoSoportadoException.class)
	public ResponseEntity<ErrorResponseDto> formatoNoSoportado(FormatoNoSoportadoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.BAD_REQUEST, exception, req);
	}

	@ExceptionHandler(PeticionMalFormadaException.class)
	public ResponseEntity<ErrorResponseDto> peticionMalFormada(PeticionMalFormadaException exception,
			HttpServletRequest req) {
		return build(HttpStatus.BAD_REQUEST, exception, req);
	}

	@ExceptionHandler(RecursoEnUsoException.class)
	public ResponseEntity<ErrorResponseDto> recursoEnUso(RecursoEnUsoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.CONFLICT, exception, req);
	}

	@ExceptionHandler(RecursoNoEncontradoException.class)
	public ResponseEntity<ErrorResponseDto> recursoNoEncontrado(RecursoNoEncontradoException exception,
			HttpServletRequest req) {
		return build(HttpStatus.NOT_FOUND, exception, req);
	}

	@ExceptionHandler(RecursoYaExistenteException.class)
	public ResponseEntity<ErrorResponseDto> recursoYaExistente(RecursoYaExistenteException exception,
			HttpServletRequest req) {
		return build(HttpStatus.CONFLICT, exception, req);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponseDto> violacionDeDatos(DataIntegrityViolationException exception, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, exception, req);
	}
	
	//Intentamos actualizar un id inexistente
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<ErrorResponseDto> emptyResultDataAccess(EmptyResultDataAccessException ex, HttpServletRequest req){

	return build(HttpStatus.NOT_FOUND, ex, req); //404
	}

	//BBDD caida
	@ExceptionHandler(DataAccessResourceFailureException.class)
	public ResponseEntity<ErrorResponseDto> dataAccessResourceFailure(DataAccessResourceFailureException ex, HttpServletRequest req){

	return build(HttpStatus.SERVICE_UNAVAILABLE, ex, req); //503
	}
	
	// Pasamos un error incorrecto a la base de datos
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorResponseDto> constraintViolation(ConstraintViolationException ex, HttpServletRequest req){

	return build(HttpStatus.SERVICE_UNAVAILABLE, ex, req); //503
	}
	
	// Intentamos pasar datos a la BBDD fuera de rango
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponseDto> illegalArgument(IllegalArgumentException ex, HttpServletRequest req){

	return build(HttpStatus.SERVICE_UNAVAILABLE, ex, req); //503
	}
	
	@ExceptionHandler(FileAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> fileAlreadyExists(FileAlreadyExistsException ex, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponseDto> accesDenied(AccessDeniedException ex, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
	}
	
	@ExceptionHandler(NoSuchFileException.class)
	public ResponseEntity<ErrorResponseDto> noSuchFile(NoSuchFileException ex, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
	}
	
	@ExceptionHandler(FileSystemException.class)
	public ResponseEntity<ErrorResponseDto> fileSystem(FileSystemException ex, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
	}
	
	@ExceptionHandler(MultipartVacioException.class)
	public ResponseEntity<ErrorResponseDto> multipartVacio(MultipartVacioException ex, HttpServletRequest req){
		return build(HttpStatus.BAD_REQUEST, ex, req);
	}
	
	@ExceptionHandler(MultipartTratamientoException.class)
	public ResponseEntity<ErrorResponseDto> multipartTratamiento(MultipartTratamientoException ex, HttpServletRequest req){
		return build(HttpStatus.BAD_REQUEST, ex, req);
	}
	
	
	@ExceptionHandler(SubidaFisicaArchivoException.class)
	public ResponseEntity<ErrorResponseDto> subidaFisicaArchivo(SubidaFisicaArchivoException ex, HttpServletRequest req){
		return build(HttpStatus.INTERNAL_SERVER_ERROR, ex, req);
	}
	
	@ExceptionHandler(BorradoArchivoException.class)
	public ResponseEntity<ErrorResponseDto> borradoArchivoException(BorradoArchivoException ex, HttpServletRequest req){
		return build(HttpStatus.BAD_REQUEST, ex, req);
	}
}
 