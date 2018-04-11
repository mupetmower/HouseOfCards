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
 * Topproducts generated by hbm2java
 */
@Entity
@Table(name = "topproducts", catalog = "houseofcards")
public class Topproducts implements java.io.Serializable {

	private Integer pkTpId;
	private Products products;

	public Topproducts() {
	}

	public Topproducts(Products products) {
		this.products = products;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_TP_ID", unique = true, nullable = false)
	public Integer getPkTpId() {
		return this.pkTpId;
	}

	public void setPkTpId(Integer pkTpId) {
		this.pkTpId = pkTpId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductId", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

}