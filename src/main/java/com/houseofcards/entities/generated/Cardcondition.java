package com.houseofcards.entities.generated;
// Generated Apr 5, 2018 12:11:56 PM by Hibernate Tools 5.2.8.Final

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
 * Cardcondition generated by hbm2java
 */
@Entity
@Table(name = "cardcondition", catalog = "houseofcards")
public class Cardcondition implements java.io.Serializable {

	private Integer pkConditionId;
	private String conditionName;
	private String conditionDescription;
	private Set<Mtgcards> mtgcardses = new HashSet<Mtgcards>(0);
	private Set<Pokemoncards> pokemoncardses = new HashSet<Pokemoncards>(0);
	private Set<Ygocards> ygocardses = new HashSet<Ygocards>(0);

	public Cardcondition() {
	}

	public Cardcondition(String conditionName, String conditionDescription) {
		this.conditionName = conditionName;
		this.conditionDescription = conditionDescription;
	}

	public Cardcondition(String conditionName, String conditionDescription, Set<Mtgcards> mtgcardses,
			Set<Pokemoncards> pokemoncardses, Set<Ygocards> ygocardses) {
		this.conditionName = conditionName;
		this.conditionDescription = conditionDescription;
		this.mtgcardses = mtgcardses;
		this.pokemoncardses = pokemoncardses;
		this.ygocardses = ygocardses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_ConditionID", unique = true, nullable = false)
	public Integer getPkConditionId() {
		return this.pkConditionId;
	}

	public void setPkConditionId(Integer pkConditionId) {
		this.pkConditionId = pkConditionId;
	}

	@Column(name = "ConditionName", nullable = false, length = 25)
	public String getConditionName() {
		return this.conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	@Column(name = "ConditionDescription", nullable = false, length = 250)
	public String getConditionDescription() {
		return this.conditionDescription;
	}

	public void setConditionDescription(String conditionDescription) {
		this.conditionDescription = conditionDescription;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardcondition")
	public Set<Mtgcards> getMtgcardses() {
		return this.mtgcardses;
	}

	public void setMtgcardses(Set<Mtgcards> mtgcardses) {
		this.mtgcardses = mtgcardses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardcondition")
	public Set<Pokemoncards> getPokemoncardses() {
		return this.pokemoncardses;
	}

	public void setPokemoncardses(Set<Pokemoncards> pokemoncardses) {
		this.pokemoncardses = pokemoncardses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardcondition")
	public Set<Ygocards> getYgocardses() {
		return this.ygocardses;
	}

	public void setYgocardses(Set<Ygocards> ygocardses) {
		this.ygocardses = ygocardses;
	}

}