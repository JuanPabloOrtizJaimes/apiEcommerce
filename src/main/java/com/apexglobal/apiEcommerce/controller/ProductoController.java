package com.apexglobal.apiEcommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apexglobal.apiEcommerce.request.ProductoRequest;
import com.apexglobal.apiEcommerce.response.ProductoResponse;
import com.apexglobal.apiEcommerce.service.ProductoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
@Validated
@Tag(name = "PRODUCTO", description = "Seccion para realizar acciones crud de productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;

	@Operation(summary = "Crear producto", description = "Endpoint que permite el registro de producto")
	@PostMapping
	public ResponseEntity<ProductoResponse> crearProducto(@RequestBody @Valid ProductoRequest productoRequest) {
		ProductoResponse productoResponse = productoService.crearProducto(productoRequest);
		return ResponseEntity.ok(productoResponse);
	}

	@Operation(summary = "Obtener productos", description = "Endpoint que permite la consulta de los productos registrados")
	@GetMapping
	public ResponseEntity<List<ProductoResponse>> obtenerProductos() {
		List<ProductoResponse> productosResponses = productoService.obtenerProductos();
		return ResponseEntity.ok(productosResponses);
	}

	@Operation(summary = "Obtener producto", description = "Endpoint que permite la consulta de un producto registrado por su id")
	@GetMapping("/{id}")
	public ResponseEntity<ProductoResponse> obtenerProductoPorId(@PathVariable String id) {
		ProductoResponse productoResponse = productoService.obtenerProductoPorId(id);
		return ResponseEntity.ok(productoResponse);
	}

	@Operation(summary = "Actualizar producto", description = "Endpoint que permite la actualizacion de un producto registrado por su id")
	@PutMapping("/{id}")
	public ResponseEntity<ProductoResponse> actualizarProducto(@PathVariable String id,
			@RequestBody @Valid ProductoRequest producto) {
		ProductoResponse productoResponse = productoService.actualizarProducto(id, producto);
		return ResponseEntity.ok(productoResponse);
	}

	@Operation(summary = "Eliminar producto", description = "Endpoint que permite borrar un producto registrado por su id")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
		productoService.eliminarProducto(id);
		return ResponseEntity.noContent().build();
	}
}
