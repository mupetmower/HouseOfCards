package com.houseofcards.entities;

import java.math.BigDecimal;

import com.houseofcards.entities.generated.Products;


public class ProductResult {
	
	private Integer pkProductId;
	private BigDecimal price;
	private String productName;
	private Integer inventoryQuantity;
	private String thumbnailUri;
	private String productDescription;
	
	
	public ProductResult() {
		
	}
	
	public ProductResult(Products product) {
		this.pkProductId = product.getPkProductId();
		this.price = product.getPrice();
		this.productName = product.getProductName();
		this.inventoryQuantity = product.getInventoryQuantity();
		this.thumbnailUri = product.getThumbnailUri();
		this.productDescription = product.getProductDescription();
	}
	
	public ProductResult(BigDecimal price, String productName, Integer inventoryQuantity, String thumbnailUri,
			String productDescription) {
		this.price = price;
		this.productName = productName;
		this.inventoryQuantity = inventoryQuantity;
		this.thumbnailUri = thumbnailUri;
		this.productDescription = productDescription;
	}
	
	
	public Integer getPkProductId() {
		return pkProductId;
	}
	public void setPkProductId(Integer pkProductId) {
		this.pkProductId = pkProductId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getInventoryQuantity() {
		return inventoryQuantity;
	}
	public void setInventoryQuantity(Integer inventoryQuantity) {
		this.inventoryQuantity = inventoryQuantity;
	}
	public String getThumbnailUri() {
		return thumbnailUri;
	}
	public void setThumbnailUri(String thumbnailUri) {
		this.thumbnailUri = thumbnailUri;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	
	
	
	

}
