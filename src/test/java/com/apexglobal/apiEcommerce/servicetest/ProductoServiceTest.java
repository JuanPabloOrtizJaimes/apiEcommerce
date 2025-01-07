package com.apexglobal.apiEcommerce.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.apexglobal.apiEcommerce.entity.Producto;
import com.apexglobal.apiEcommerce.exception.ProductoNoEncontradoException;
import com.apexglobal.apiEcommerce.mapper.ProductoMapper;
import com.apexglobal.apiEcommerce.repository.ProductoRepository;
import com.apexglobal.apiEcommerce.request.ProductoRequest;
import com.apexglobal.apiEcommerce.response.ProductoResponse;
import com.apexglobal.apiEcommerce.serviceImpl.ProductoServiceImpl;

public class ProductoServiceTest {

	@Mock
	private ProductoRepository productoRepository;

	@Mock
	private ProductoMapper productoMapper;

	@InjectMocks
	private ProductoServiceImpl productoServiceImpl;

	private Producto producto;
	private ProductoRequest productoRequest;
	private ProductoResponse productoResponse;

	@BeforeEach
	private void setUp() {
		MockitoAnnotations.openMocks(this);

		producto = new Producto();
		producto.setId("1");
		producto.setProductId("P001");
		producto.setName("Shampoo Prueba");
		producto.setDescription("Descripción de prueba");
		producto.setPrice(100.0);
		producto.setStock(10);
		producto.setCreatedAt(LocalDateTime.now());
		producto.setUpdatedAt(LocalDateTime.now());

		productoRequest = new ProductoRequest();
		productoRequest.setProductId("P001");
		productoRequest.setName("Shampoo Prueba");
		productoRequest.setDescription("Descripción de prueba");
		productoRequest.setPrice(100.0);
		productoRequest.setStock(10);

		productoResponse = new ProductoResponse();
		productoResponse.setId("1");
		productoResponse.setProductId("P001");
		productoResponse.setName("Shampoo Prueba");
		productoResponse.setDescription("Descripción de prueba");
		productoResponse.setPrice(100.0);
		productoResponse.setStock(10);

	}

	@Test
	void crearProductoConExito() {
		when(productoMapper.paraEntidad(productoRequest)).thenReturn(producto);
		when(productoRepository.save(producto)).thenReturn(producto);
		when(productoMapper.paraResponse(producto)).thenReturn(productoResponse);

		ProductoResponse response = productoServiceImpl.crearProducto(productoRequest);

		assertNotNull(response);
		assertEquals(productoResponse.getId(), response.getId());
		verify(productoMapper).paraEntidad(productoRequest);
		verify(productoRepository).save(producto);
		verify(productoMapper).paraResponse(producto);

	}

	@Test
	void obtenerProductoPorIdExito() {
		when(productoRepository.findById("1")).thenReturn(Optional.of(producto));
		when(productoMapper.paraResponse(producto)).thenReturn(productoResponse);

		ProductoResponse response = productoServiceImpl.obtenerProductoPorId("1");

		assertNotNull(response);
		assertEquals("1", response.getId());
		verify(productoRepository).findById("1");
		verify(productoMapper).paraResponse(producto);
	}

	@Test
	void obtenerProductoPorIdNoEncontrado() {
		when(productoRepository.findById("1")).thenReturn(Optional.empty());

		Exception exception = assertThrows(ProductoNoEncontradoException.class,
				() -> productoServiceImpl.obtenerProductoPorId("1"));
		assertEquals("Producto con ID 1 no encontrado", exception.getMessage());
		verify(productoRepository).findById("1");
	}

	@Test
	void actualizarProductoExito() {

		productoRequest.setName("Shampoo Anticaspa Prueba");

		when(productoRepository.findById("1")).thenReturn(Optional.of(producto));
		when(productoMapper.paraEntidadActualizacion(productoRequest, producto)).thenReturn(producto);
		producto.setName("Shampoo Anticaspa Prueba");
		when(productoRepository.save(producto)).thenReturn(producto);
		when(productoMapper.paraResponse(producto)).thenReturn(productoResponse);
		productoResponse.setName("Shampoo Anticaspa Prueba");

		ProductoResponse response = productoServiceImpl.actualizarProducto("1", productoRequest);

		assertNotNull(response);
		assertEquals(productoResponse.getId(), response.getId());
		assertEquals(productoResponse.getName(), response.getName());
		verify(productoMapper).paraEntidadActualizacion(productoRequest, producto);
		verify(productoRepository).save(producto);
		verify(productoMapper).paraResponse(producto);

	}

	@Test
	void eliminarProductoConExito() {

		when(productoRepository.existsById("1")).thenReturn(true);
		doNothing().when(productoRepository).deleteById("1");

		productoServiceImpl.eliminarProducto("1");

		verify(productoRepository).existsById("1");
		verify(productoRepository).deleteById("1");

	}
	
	@Test
	void eliminarProductoNoEncontrado() {

		when(productoRepository.existsById("1")).thenReturn(false);
		
		Exception exception=assertThrows(ProductoNoEncontradoException.class, ()->productoServiceImpl.eliminarProducto("1"));

        assertEquals("Producto con ID 1 no encontrado", exception.getMessage());
		verify(productoRepository).existsById("1");
		

	}
}
