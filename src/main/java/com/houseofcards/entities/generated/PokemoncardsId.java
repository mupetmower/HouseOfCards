package com.houseofcards.entities.generated;
// Generated Apr 30, 2018 1:29:43 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PokemoncardsId generated by hbm2java
 */
@Embeddable
public class PokemoncardsId implements java.io.Serializable {

	private int pkPokemonCardId;
	private int fkProductId;

	public PokemoncardsId() {
	}

	public PokemoncardsId(int pkPokemonCardId, int fkProductId) {
		this.pkPokemonCardId = pkPokemonCardId;
		this.fkProductId = fkProductId;
	}

	@Column(name = "PK_PokemonCardID", unique = true, nullable = false)
	public int getPkPokemonCardId() {
		return this.pkPokemonCardId;
	}

	public void setPkPokemonCardId(int pkPokemonCardId) {
		this.pkPokemonCardId = pkPokemonCardId;
	}

	@Column(name = "FK_ProductID", unique = true, nullable = false)
	public int getFkProductId() {
		return this.fkProductId;
	}

	public void setFkProductId(int fkProductId) {
		this.fkProductId = fkProductId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PokemoncardsId))
			return false;
		PokemoncardsId castOther = (PokemoncardsId) other;

		return (this.getPkPokemonCardId() == castOther.getPkPokemonCardId())
				&& (this.getFkProductId() == castOther.getFkProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPkPokemonCardId();
		result = 37 * result + this.getFkProductId();
		return result;
	}

}
