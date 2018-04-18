package com.houseofcards.entities.generated;
// Generated Apr 17, 2018 1:12:49 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Mtgcards generated by hbm2java
 */
@Entity
@Table(name = "mtgcards", catalog = "houseofcards", uniqueConstraints = {
		@UniqueConstraint(columnNames = "FK_ProductID"), @UniqueConstraint(columnNames = "PK_MtgCardID") })
public class Mtgcards implements java.io.Serializable {

	private MtgcardsId id;
	private Cardcondition cardcondition;
	private Mtgrarity mtgrarity;
	private Mtgsetseries mtgsetseries;
	private Products products;
	private String cardName;
	private boolean promo;

	public Mtgcards() {
	}

	public Mtgcards(MtgcardsId id, Products products, String cardName, boolean promo) {
		this.id = id;
		this.products = products;
		this.cardName = cardName;
		this.promo = promo;
	}

	public Mtgcards(MtgcardsId id, Cardcondition cardcondition, Mtgrarity mtgrarity, Mtgsetseries mtgsetseries,
			Products products, String cardName, boolean promo) {
		this.id = id;
		this.cardcondition = cardcondition;
		this.mtgrarity = mtgrarity;
		this.mtgsetseries = mtgsetseries;
		this.products = products;
		this.cardName = cardName;
		this.promo = promo;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pkMtgCardId", column = @Column(name = "PK_MtgCardID", unique = true, nullable = false)),
			@AttributeOverride(name = "fkProductId", column = @Column(name = "FK_ProductID", unique = true, nullable = false)) })
	public MtgcardsId getId() {
		return this.id;
	}

	public void setId(MtgcardsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_Condition")
	public Cardcondition getCardcondition() {
		return this.cardcondition;
	}

	public void setCardcondition(Cardcondition cardcondition) {
		this.cardcondition = cardcondition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_Rarity")
	public Mtgrarity getMtgrarity() {
		return this.mtgrarity;
	}

	public void setMtgrarity(Mtgrarity mtgrarity) {
		this.mtgrarity = mtgrarity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_SetSeries")
	public Mtgsetseries getMtgsetseries() {
		return this.mtgsetseries;
	}

	public void setMtgsetseries(Mtgsetseries mtgsetseries) {
		this.mtgsetseries = mtgsetseries;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_ProductID", unique = true, nullable = false, insertable = false, updatable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Column(name = "CardName", nullable = false, length = 30)
	public String getCardName() {
		return this.cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	@Column(name = "Promo", nullable = false)
	public boolean isPromo() {
		return this.promo;
	}

	public void setPromo(boolean promo) {
		this.promo = promo;
	}

}
