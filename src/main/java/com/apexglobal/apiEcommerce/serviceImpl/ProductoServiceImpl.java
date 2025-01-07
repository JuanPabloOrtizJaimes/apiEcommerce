package com.apexglobal.apiEcommerce.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apexglobal.apiEcommerce.entity.Producto;
import com.apexglobal.apiEcommerce.exception.ProductoNoEncontradoException;
import com.apexglobal.apiEcommerce.mapper.ProductoMapper;
import com.apexglobal.apiEcommerce.repository.ProductoRepository;
import com.apexglobal.apiEcommerce.request.ProductoRequest;
import com.apexglobal.apiEcommerce.response.ProductoResponse;
import com.apexglobal.apiEcommerce.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private ProductoMapper productoMapper;

	@Override
	public ProductoResponse crearProducto(ProductoRequest productoRequest) {
		Producto producto = productoMapper.paraEntidad(productoRequest);
		Producto productoCreado = productoRepository.save(producto);
		return productoMapper.paraResponse(productoCreado);
	}

	@Override
	public ProductoResponse actualizarProducto(String id, ProductoRequest productoRequest) {
		Producto productoEncontrado = productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNoEncontradoException(id));
		productoMapper.paraEntidadActualizacion(productoRequest,productoEncontrado);
		Producto productoActualizado = productoRepository.save(productoEncontrado);
		return productoMapper.paraResponse(productoActualizado);

	}

	@Override
	public List<ProductoResponse> obtenerProductos() {
		List<Producto> productos = productoRepository.findAll();
		return productos.stream().map(producto -> productoMapper.paraResponse(producto)).collect(Collectors.toList());
	}

	@Override
	public ProductoResponse obtenerProductoPorId(String id) {
		Producto producto = productoRepository.findById(id).orElseThrow(() -> new ProductoNoEncontradoException(id));
		return productoMapper.paraResponse(producto);
	}

	@Override
	public void eliminarProducto(String id) {
		if (!productoRepository.existsById(id)) {
			throw new ProductoNoEncontradoException(id);
		}
		productoRepository.deleteById(id);

	}
}
