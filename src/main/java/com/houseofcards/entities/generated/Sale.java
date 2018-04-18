package com.houseofcards.entities.generated;
// Generated Apr 18, 2018 1:58:05 PM by Hibernate Tools 5.2.8.Final

import java.math.BigDecimal;
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

/**
 * Sale generated by hbm2java
 */
@Entity
@Table(name = "sale", catalog = "houseofcards")
public class Sale implements java.io.Serializable {

	private Integer pkSaleId;
	private User user;
	private Date dateTime;
	private BigDecimal saleTotal;
	private Set<Saleitems> saleitemses = new HashSet<Saleitems>(0);

	public Sale() {
	}

	public Sale(Date dateTime, BigDecimal saleTotal) {
		this.dateTime = dateTime;
		this.saleTotal = saleTotal;
	}

	public Sale(User user, Date dateTime, BigDecimal saleTotal, Set<Saleitems> saleitemses) {
		this.user = user;
		this.dateTime = dateTime;
		this.saleTotal = saleTotal;
		this.saleitemses = saleitemses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_SaleID", unique = true, nullable = false)
	public Integer getPkSaleId() {
		return this.pkSaleId;
	}

	public void setPkSaleId(Integer pkSaleId) {
		this.pkSaleId = pkSaleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_UserID")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateTime", nullable = false, length = 10)
	public Date getDateTime() {
		return this.dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "SaleTotal", nullable = false, precision = 10)
	public BigDecimal getSaleTotal() {
		return this.saleTotal;
	}

	public void setSaleTotal(BigDecimal saleTotal) {
		this.saleTotal = saleTotal;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sale")
	public Set<Saleitems> getSaleitemses() {
		return this.saleitemses;
	}

	public void setSaleitemses(Set<Saleitems> saleitemses) {
		this.saleitemses = saleitemses;
	}

}
