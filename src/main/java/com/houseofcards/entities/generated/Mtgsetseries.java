package com.houseofcards.entities.generated;
// Generated Apr 5, 2018 12:11:56 PM by Hibernate Tools 5.2.8.Final

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
 * Mtgsetseries generated by hbm2java
 */
@Entity
@Table(name = "mtgsetseries", catalog = "houseofcards")
public class Mtgsetseries implements java.io.Serializable {

	private Integer pkSetSeriesId;
	private Integer amountCards;
	private String setName;
	private String seriesName;
	private Date releaseDate;
	private Set<Mtgcards> mtgcardses = new HashSet<Mtgcards>(0);

	public Mtgsetseries() {
	}

	public Mtgsetseries(String setName, Date releaseDate) {
		this.setName = setName;
		this.releaseDate = releaseDate;
	}

	public Mtgsetseries(Integer amountCards, String setName, String seriesName, Date releaseDate,
			Set<Mtgcards> mtgcardses) {
		this.amountCards = amountCards;
		this.setName = setName;
		this.seriesName = seriesName;
		this.releaseDate = releaseDate;
		this.mtgcardses = mtgcardses;
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

	@Column(name = "SeriesName", length = 45)
	public String getSeriesName() {
		return this.seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ReleaseDate", nullable = false, length = 10)
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mtgsetseries")
	public Set<Mtgcards> getMtgcardses() {
		return this.mtgcardses;
	}

	public void setMtgcardses(Set<Mtgcards> mtgcardses) {
		this.mtgcardses = mtgcardses;
	}

}
