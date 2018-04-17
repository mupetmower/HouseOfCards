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
 * Ygocards generated by hbm2java
 */
@Entity
@Table(name = "ygocards", catalog = "houseofcards", uniqueConstraints = {
		@UniqueConstraint(columnNames = "FK_ProductID"), @UniqueConstraint(columnNames = "PK_YgoCardID") })
public class Ygocards implements java.io.Serializable {

	private YgocardsId id;
	private Cardcondition cardcondition;
	private Products products;
	private Ygorarity ygorarity;
	private Ygosetseries ygosetseries;
	private String cardName;
	private boolean promo;

	public Ygocards() {
	}

	public Ygocards(YgocardsId id, Products products, String cardName, boolean promo) {
		this.id = id;
		this.products = products;
		this.cardName = cardName;
		this.promo = promo;
	}

	public Ygocards(YgocardsId id, Cardcondition cardcondition, Products products, Ygorarity ygorarity,
			Ygosetseries ygosetseries, String cardName, boolean promo) {
		this.id = id;
		this.cardcondition = cardcondition;
		this.products = products;
		this.ygorarity = ygorarity;
		this.ygosetseries = ygosetseries;
		this.cardName = cardName;
		this.promo = promo;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pkYgoCardId", column = @Column(name = "PK_YgoCardID", unique = true, nullable = false)),
			@AttributeOverride(name = "fkProductId", column = @Column(name = "FK_ProductID", unique = true, nullable = false)) })
	public YgocardsId getId() {
		return this.id;
	}

	public void setId(YgocardsId id) {
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
	@JoinColumn(name = "FK_ProductID", unique = true, nullable = false, insertable = false, updatable = false)
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_Rarity")
	public Ygorarity getYgorarity() {
		return this.ygorarity;
	}

	public void setYgorarity(Ygorarity ygorarity) {
		this.ygorarity = ygorarity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_SetSeries")
	public Ygosetseries getYgosetseries() {
		return this.ygosetseries;
	}

	public void setYgosetseries(Ygosetseries ygosetseries) {
		this.ygosetseries = ygosetseries;
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
