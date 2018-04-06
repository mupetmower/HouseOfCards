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
 * Ygorarity generated by hbm2java
 */
@Entity
@Table(name = "ygorarity", catalog = "houseofcards")
public class Ygorarity implements java.io.Serializable {

	private Integer pkRarityId;
	private String rarityDescription;
	private Set<Ygocards> ygocardses = new HashSet<Ygocards>(0);

	public Ygorarity() {
	}

	public Ygorarity(String rarityDescription) {
		this.rarityDescription = rarityDescription;
	}

	public Ygorarity(String rarityDescription, Set<Ygocards> ygocardses) {
		this.rarityDescription = rarityDescription;
		this.ygocardses = ygocardses;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ygorarity")
	public Set<Ygocards> getYgocardses() {
		return this.ygocardses;
	}

	public void setYgocardses(Set<Ygocards> ygocardses) {
		this.ygocardses = ygocardses;
	}

}