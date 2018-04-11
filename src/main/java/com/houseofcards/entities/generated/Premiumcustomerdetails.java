package com.houseofcards.entities.generated;
// Generated Apr 10, 2018 11:28:08 AM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Premiumcustomerdetails generated by hbm2java
 */
@Entity
@Table(name = "premiumcustomerdetails", catalog = "houseofcards", uniqueConstraints = {
		@UniqueConstraint(columnNames = "FK_UserID"), @UniqueConstraint(columnNames = "PK_PremiumID") })
public class Premiumcustomerdetails implements java.io.Serializable {

	private PremiumcustomerdetailsId id;
	private User user;
	private Integer rewardPoints;
	private Date dateAccountOpened;
	private Set<Customercardinventory> customercardinventories = new HashSet<Customercardinventory>(0);

	public Premiumcustomerdetails() {
	}

	public Premiumcustomerdetails(PremiumcustomerdetailsId id, User user) {
		this.id = id;
		this.user = user;
	}

	public Premiumcustomerdetails(PremiumcustomerdetailsId id, User user, Integer rewardPoints, Date dateAccountOpened,
			Set<Customercardinventory> customercardinventories) {
		this.id = id;
		this.user = user;
		this.rewardPoints = rewardPoints;
		this.dateAccountOpened = dateAccountOpened;
		this.customercardinventories = customercardinventories;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "pkPremiumId", column = @Column(name = "PK_PremiumID", unique = true, nullable = false)),
			@AttributeOverride(name = "fkUserId", column = @Column(name = "FK_UserID", unique = true, nullable = false)) })
	public PremiumcustomerdetailsId getId() {
		return this.id;
	}

	public void setId(PremiumcustomerdetailsId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "RewardPoints")
	public Integer getRewardPoints() {
		return this.rewardPoints;
	}

	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateAccountOpened", length = 10)
	public Date getDateAccountOpened() {
		return this.dateAccountOpened;
	}

	public void setDateAccountOpened(Date dateAccountOpened) {
		this.dateAccountOpened = dateAccountOpened;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "premiumcustomerdetails")
	public Set<Customercardinventory> getCustomercardinventories() {
		return this.customercardinventories;
	}

	public void setCustomercardinventories(Set<Customercardinventory> customercardinventories) {
		this.customercardinventories = customercardinventories;
	}

}
