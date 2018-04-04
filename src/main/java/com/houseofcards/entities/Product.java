package com.houseofcards.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "products")
public class Product extends com.houseofcards.entities.Entity {
    
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @Version
//    private Integer version;


    @Id
    @Column(name = "PK_ProductID", nullable = true)
    private Integer productId;
    
    @Column(name = "ProductName")
    private String productName;
    
    @Column(name = "ProductDescription")
    private String description;
    
    @Column(name = "ThumbnailURI")
    private String imageUri;
    
    @Column(name = "Price")
    private BigDecimal price;
    
    @Column(name = "InventoryQuantity")
    private Integer quantity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Integer getVersion() {
//        return version;
//    }
//
//    public void setVersion(Integer version) {
//        this.version = version;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
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

    public Integer getQuantity() {
	return quantity;
    }

    public void setQuantity(Integer quantity) {
	this.quantity = quantity;
    }

	@Override
	public void print() {
		System.out.printf("Product Id: %d%n"
				+ "Name: %s%n"
				+ "Price: %.2f%n",
				productId, productName, price);
		
	}
}