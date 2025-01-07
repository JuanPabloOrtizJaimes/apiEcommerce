package com.apexglobal.apiEcommerce.exception;

public class ProductoNoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 7166304507959426261L;

	public ProductoNoEncontradoException(String id) {
		super("Producto con ID " + id + " no encontrado");
	}
}
