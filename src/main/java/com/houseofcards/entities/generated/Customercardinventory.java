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
 * Customercardinventory generated by hbm2java
 */
@Entity
@Table(name = "customercardinventory", catalog = "houseofcards")
public class Customercardinventory implements java.io.Serializable {

	private Integer pkCustCardInvId;
	private Premiumcustomerdetails premiumcustomerdetails;
	private Products products;
	private String notes;
	private Integer quantity;

	public Customercardinventory() {
	}

	public Customercardinventory(Premiumcustomerdetails premiumcustomerdetails, Products products) {
		this.premiumcustomerdetails = premiumcustomerdetails;
		this.products = products;
	}

	public Customercardinventory(Premiumcustomerdetails premiumcustomerdetails, Products products, String notes,
			Integer quantity) {
		this.premiumcustomerdetails = premiumcustomerdetails;
		this.products = products;
		this.notes = notes;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PK_CustCardInvID", unique = true, nullable = false)
	public Integer getPkCustCardInvId() {
		return this.pkCustCardInvId;
	}

	public void setPkCustCardInvId(Integer pkCustCardInvId) {
		this.pkCustCardInvId = pkCustCardInvId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_PremiumID", nullable = false)
	public Premiumcustomerdetails getPremiumcustomerdetails() {
		return this.premiumcustomerdetails;
	}

	public void setPremiumcustomerdetails(Premiumcustomerdetails premiumcustomerdetails) {
		this.premiumcustomerdetails = premiumcustomerdetails;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductID", nullable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "Notes", length = 45)
	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Column(name = "Quantity")
	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
