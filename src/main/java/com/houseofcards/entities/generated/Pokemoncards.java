package com.houseofcards.entities.generated;
// Generated Apr 19, 2018 1:09:43 PM by Hibernate Tools 5.2.8.Final

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
 * Pokemoncards generated by hbm2java
 */
@Entity
@Table(name = "pokemoncards", catalog = "houseofcards", uniqueConstraints = {
		@UniqueConstraint(columnNames = "FK_ProductID"), @UniqueConstraint(columnNames = "PK_PokemonCardID") })
public class Pokemoncards implements java.io.Serializable {

	private PokemoncardsId id;
	private Cardcondition cardcondition;
	private Pokemonrarity pokemonrarity;
	private Pokemonsetseries pokemonsetseries;
	private Products products;
	private String cardName;
	private int numberInSet;

	public Pokemoncards() {
	}

	public Pokemoncards(PokemoncardsId id, Products products, String cardName, int numberInSet) {
		this.id = id;
		this.products = products;
		this.cardName = cardName;
		this.numberInSet = numberInSet;
	}

	public Pokemoncards(PokemoncardsId id, Cardcondition cardcondition, Pokemonrarity pokemonrarity,
			Pokemonsetseries pokemonsetseries, Products products, String cardName, int numberInSet) {
		this.id = id;
		this.cardcondition = cardcondition;
		this.pokemonrarity = pokemonrarity;
		this.pokemonsetseries = pokemonsetseries;
		this.products = products;
		this.cardName = cardName;
		this.numberInSet = numberInSet;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pkPokemonCardId", column = @Column(name = "PK_PokemonCardID", unique = true, nullable = false)),
			@AttributeOverride(name = "fkProductId", column = @Column(name = "FK_ProductID", unique = true, nullable = false)) })
	public PokemoncardsId getId() {
		return this.id;
	}

	public void setId(PokemoncardsId id) {
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
	public Pokemonrarity getPokemonrarity() {
		return this.pokemonrarity;
	}

	public void setPokemonrarity(Pokemonrarity pokemonrarity) {
		this.pokemonrarity = pokemonrarity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_SetSeries")
	public Pokemonsetseries getPokemonsetseries() {
		return this.pokemonsetseries;
	}

	public void setPokemonsetseries(Pokemonsetseries pokemonsetseries) {
		this.pokemonsetseries = pokemonsetseries;
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

	@Column(name = "NumberInSet", nullable = false)
	public int getNumberInSet() {
		return this.numberInSet;
	}

	public void setNumberInSet(int numberInSet) {
		this.numberInSet = numberInSet;
	}

}
