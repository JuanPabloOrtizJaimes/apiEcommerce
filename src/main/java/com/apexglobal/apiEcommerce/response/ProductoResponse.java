package com.apexglobal.apiEcommerce.response;

import java.time.LocalDateTime;
import java.util.Objects;

public class ProductoResponse {

	private String id;

	private String productId;

	private String name;

	private String description;

	private Double price;

	private Integer stock;

	private LocalDateTime createdAt;

	private LocalDateTime updatedAt;

	public ProductoResponse(String id, String productId, String name, String description, Double price, Integer stock,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.productId = productId;
		this.name = name;
		this.description = description;
		this.price = price;
		this.stock = stock;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public ProductoResponse() {
		super();

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, id, name, price, productId, stock, updatedAt);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoResponse other = (ProductoResponse) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(price, other.price) && Objects.equals(productId, other.productId)
				&& Objects.equals(stock, other.stock) && Objects.equals(updatedAt, other.updatedAt);
	}

	@Override
	public String toString() {
		return "ProductoResponse [id=" + id + ", productId=" + productId + ", name=" + name + ", description="
				+ description + ", price=" + price + ", stock=" + stock + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + "]";
	}

}
