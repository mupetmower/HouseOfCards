package com.houseofcards.entities.generated;
// Generated Apr 30, 2018 1:29:43 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
@Table(name = "premiumcustomerdetails", catalog = "houseofcards", uniqueConstraints = @UniqueConstraint(columnNames = "FK_UserID"))
public class Premiumcustomerdetails implements java.io.Serializable {

	private Integer pkPremiumId;
	private User user;
	private Integer rewardPoints;
	private Date dateAccountOpened;
	private Set<Customercardinventory> customercardinventories = new HashSet<Customercardinventory>(0);

	public Premiumcustomerdetails() {
	}

	public Premiumcustomerdetails(User user) {
		this.user = user;
	}

	public Premiumcustomerdetails(User user, Integer rewardPoints, Date dateAccountOpened,
			Set<Customercardinventory> customercardinventories) {
		this.user = user;
		this.rewardPoints = rewardPoints;
		this.dateAccountOpened = dateAccountOpened;
		this.customercardinventories = customercardinventories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_PremiumID", unique = true, nullable = false)
	public Integer getPkPremiumId() {
		return this.pkPremiumId;
	}

	public void setPkPremiumId(Integer pkPremiumId) {
		this.pkPremiumId = pkPremiumId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_UserID", unique = true, nullable = false)
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

	public void addCardToCustomercardinventories(Customercardinventory userCard) {
		customercardinventories.add(userCard);
	}

}
