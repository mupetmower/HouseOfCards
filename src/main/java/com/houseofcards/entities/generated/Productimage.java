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

/**
 * Productimage generated by hbm2java
 */
@Entity
@Table(name = "productimage", catalog = "houseofcards")
public class Productimage implements java.io.Serializable {

	private Integer pkId;
	private Products products;
	private String imageUri;
	private String viewName;

	public Productimage() {
	}

	public Productimage(Products products, String imageUri) {
		this.products = products;
		this.imageUri = imageUri;
	}

	public Productimage(Products products, String imageUri, String viewName) {
		this.products = products;
		this.imageUri = imageUri;
		this.viewName = viewName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_ID", unique = true, nullable = false)
	public Integer getPkId() {
		return this.pkId;
	}

	public void setPkId(Integer pkId) {
		this.pkId = pkId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductID", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "ImageUri", nullable = false, length = 80)
	public String getImageUri() {
		return this.imageUri;
	}

	public void setImageUri(String imageUri) {
		this.imageUri = imageUri;
	}

	@Column(name = "ViewName", length = 30)
	public String getViewName() {
		return this.viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
