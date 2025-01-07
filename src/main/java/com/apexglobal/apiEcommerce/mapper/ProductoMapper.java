package com.apexglobal.apiEcommerce.mapper;

import java.time.LocalDateTime;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.apexglobal.apiEcommerce.entity.Producto;
import com.apexglobal.apiEcommerce.request.ProductoRequest;
import com.apexglobal.apiEcommerce.response.ProductoResponse;

@Mapper(componentModel = "spring")
public interface ProductoMapper {

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Producto paraEntidad(ProductoRequest productoRequest);

	@Mapping(target = "id", ignore = true)
	@Mapping(target = "createdAt", ignore = true)
	@Mapping(target = "updatedAt", ignore = true)
	Producto paraEntidadActualizacion(ProductoRequest productoRequest, @MappingTarget Producto productoEncontrado);

	ProductoResponse paraResponse(Producto producto);

	@AfterMapping
	default void setTimestamps(@MappingTarget Producto producto) {
		if (producto.getCreatedAt() == null) {
			producto.setCreatedAt(LocalDateTime.now());
		}
		producto.setUpdatedAt(LocalDateTime.now());
	}
}
