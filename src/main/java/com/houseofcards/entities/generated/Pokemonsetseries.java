package com.houseofcards.entities.generated;
// Generated Apr 16, 2018 2:29:30 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Pokemonsetseries generated by hbm2java
 */
@Entity
@Table(name = "pokemonsetseries", catalog = "houseofcards")
public class Pokemonsetseries implements java.io.Serializable {

	private Integer pkSetSeriesId;
	private Integer amountCards;
	private String setName;
	private Date releaseDate;
	private Set<Pokemoncards> pokemoncardses = new HashSet<Pokemoncards>(0);

	public Pokemonsetseries() {
	}

	public Pokemonsetseries(String setName, Date releaseDate) {
		this.setName = setName;
		this.releaseDate = releaseDate;
	}

	public Pokemonsetseries(Integer amountCards, String setName, Date releaseDate, Set<Pokemoncards> pokemoncardses) {
		this.amountCards = amountCards;
		this.setName = setName;
		this.releaseDate = releaseDate;
		this.pokemoncardses = pokemoncardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_SetSeriesID", unique = true, nullable = false)
	public Integer getPkSetSeriesId() {
		return this.pkSetSeriesId;
	}

	public void setPkSetSeriesId(Integer pkSetSeriesId) {
		this.pkSetSeriesId = pkSetSeriesId;
	}

	@Column(name = "AmountCards")
	public Integer getAmountCards() {
		return this.amountCards;
	}

	public void setAmountCards(Integer amountCards) {
		this.amountCards = amountCards;
	}

	@Column(name = "SetName", nullable = false, length = 45)
	public String getSetName() {
		return this.setName;
	}

	public void setSetName(String setName) {
		this.setName = setName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ReleaseDate", nullable = false, length = 10)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pokemonsetseries")
	public Set<Pokemoncards> getPokemoncardses() {
		return this.pokemoncardses;
	}

	public void setPokemoncardses(Set<Pokemoncards> pokemoncardses) {
		this.pokemoncardses = pokemoncardses;
	}

}
