package com.apexglobal.apiEcommerce.request;

import java.util.Objects;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductoRequest {

	@NotNull(message = "El productoId no puede ser nulo")
	@Size(min = 1, message = "El productoId debe tener al menos 1 caracter o mas")
	private String productId;
	@NotNull(message = "El nombre del producto no puede ser nulo")
	@Size(min = 3, message = "El nombre del producto debe tener al menos 3 caracteres")
	private String name;
	@NotNull(message = "La descripcion del producto no puede ser nulo")
	@Size(min = 3, message = "La descripcion del producto debe tener al menos 3 caracteres")
	private String description;
	@NotNull(message = "El precio no puede ser nulo")
	@DecimalMin(value = "1.0", inclusive = true)
	private Double price;
	@NotNull(message = "El stock no puede ser nulo")
	@Min(value = 1, message = "El stock debe ser al menos 1")
	private Integer stock;

	public ProductoRequest(String productId, String name, String description, Double price, Integer stock) {
		super();
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;

	}

	public ProductoRequest() {
		super();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name, price, productId, stock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoRequest other = (ProductoRequest) obj;
		return Objects.equals(description, other.description) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(productId, other.productId)
				&& Objects.equals(stock, other.stock);
	}

	@Override
	public String toString() {
		return "ProductoRequest [productId=" + productId + ", name=" + name + ", description=" + description
				+ ", price=" + price + ", stock=" + stock + "]";
	}

}
