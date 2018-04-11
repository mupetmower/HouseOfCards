package com.houseofcards.entities.generated;
// Generated Apr 10, 2018 11:28:08 AM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Saleitems generated by hbm2java
 */
@Entity
@Table(name = "saleitems", catalog = "houseofcards")
public class Saleitems implements java.io.Serializable {

	private Integer pkSaleItemId;
	private Products products;
	private Sale sale;
	private int quantity;

	public Saleitems() {
	}

	public Saleitems(Products products, Sale sale, int quantity) {
		this.products = products;
		this.sale = sale;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_SaleItemID", unique = true, nullable = false)
	public Integer getPkSaleItemId() {
		return this.pkSaleItemId;
	}

	public void setPkSaleItemId(Integer pkSaleItemId) {
		this.pkSaleItemId = pkSaleItemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductID", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_SaleID", nullable = false)
	public Sale getSale() {
		return this.sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	@Column(name = "Quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
