package com.houseofcards.entities.generated;
// Generated Apr 19, 2018 1:09:43 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Discountedproducts generated by hbm2java
 */
@Entity
@Table(name = "discountedproducts", catalog = "houseofcards")
public class Discountedproducts implements java.io.Serializable {

	private Integer pkDiscountedProductId;
	private Discount discount;
	private Products products;

	public Discountedproducts() {
	}

	public Discountedproducts(Discount discount, Products products) {
		this.discount = discount;
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_DiscountedProductID", unique = true, nullable = false)
	public Integer getPkDiscountedProductId() {
		return this.pkDiscountedProductId;
	}

	public void setPkDiscountedProductId(Integer pkDiscountedProductId) {
		this.pkDiscountedProductId = pkDiscountedProductId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_DiscountID", nullable = false)
	public Discount getDiscount() {
		return this.discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductID", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}
