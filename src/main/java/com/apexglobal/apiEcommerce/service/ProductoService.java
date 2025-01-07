package com.apexglobal.apiEcommerce.service;

import java.util.List;

import com.apexglobal.apiEcommerce.request.ProductoRequest;
import com.apexglobal.apiEcommerce.response.ProductoResponse;

public interface ProductoService {

	public ProductoResponse crearProducto(ProductoRequest productoRequest);

	public List<ProductoResponse> obtenerProductos();

	public ProductoResponse obtenerProductoPorId(String id);

	public ProductoResponse actualizarProducto(String id, ProductoRequest productoRequest);

	public void eliminarProducto(String id);
}
