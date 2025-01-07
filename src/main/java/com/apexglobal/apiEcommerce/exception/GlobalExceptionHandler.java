package com.apexglobal.apiEcommerce.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> manejarErroresDeValidacion(MethodArgumentNotValidException ex) {
		Map<String, String> errores = new HashMap<>();
		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errores.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(errores);
	}

	@ExceptionHandler(ProductoNoEncontradoException.class)
	public ResponseEntity<Map<String, String>> manejarProductoNoEncontrado(ProductoNoEncontradoException ex) {
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> manejarErroresGenerales(Exception ex) {
		Map<String, String> respuesta = new HashMap<>();
		respuesta.put("error", "Error interno del servidor");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
				.body(respuesta);
	}
}
