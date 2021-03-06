package com.houseofcards.entities.generated;
// Generated Apr 30, 2018 1:29:43 PM by Hibernate Tools 5.2.8.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pokemonrarity generated by hbm2java
 */
@Entity
@Table(name = "pokemonrarity", catalog = "houseofcards")
public class Pokemonrarity implements java.io.Serializable {

	private Integer pkRarityId;
	private String rarityDescription;
	private Set<Pokemoncards> pokemoncardses = new HashSet<Pokemoncards>(0);

	public Pokemonrarity() {
	}

	public Pokemonrarity(String rarityDescription) {
		this.rarityDescription = rarityDescription;
	}

	public Pokemonrarity(String rarityDescription, Set<Pokemoncards> pokemoncardses) {
		this.rarityDescription = rarityDescription;
		this.pokemoncardses = pokemoncardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_RarityID", unique = true, nullable = false)
	public Integer getPkRarityId() {
		return this.pkRarityId;
	}

	public void setPkRarityId(Integer pkRarityId) {
		this.pkRarityId = pkRarityId;
	}

	@Column(name = "RarityDescription", nullable = false, length = 30)
	public String getRarityDescription() {
		return this.rarityDescription;
	}

	public void setRarityDescription(String rarityDescription) {
		this.rarityDescription = rarityDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pokemonrarity")
	public Set<Pokemoncards> getPokemoncardses() {
		return this.pokemoncardses;
	}

	public void setPokemoncardses(Set<Pokemoncards> pokemoncardses) {
		this.pokemoncardses = pokemoncardses;
	}

}
