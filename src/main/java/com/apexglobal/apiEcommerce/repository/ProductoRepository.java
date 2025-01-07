package com.apexglobal.apiEcommerce.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apexglobal.apiEcommerce.entity.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

	Optional<Producto> findById(String productId);

}
