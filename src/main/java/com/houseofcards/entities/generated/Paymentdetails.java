package com.houseofcards.entities.generated;
// Generated Apr 19, 2018 1:09:43 PM by Hibernate Tools 5.2.8.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Paymentdetails generated by hbm2java
 */
@Entity
@Table(name = "paymentdetails", catalog = "houseofcards")
public class Paymentdetails implements java.io.Serializable {

	private Integer pkPaymentId;
	private User user;
	private String cardType;
	private String cardNumber;
	private String cardSecurityCode;
	private String cardHolderName;
	private Date cardExpiration;
	private Boolean cardPresent;

	public Paymentdetails() {
	}

	public Paymentdetails(User user, String cardType, String cardNumber, String cardSecurityCode, String cardHolderName,
			Date cardExpiration) {
		this.user = user;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardSecurityCode = cardSecurityCode;
		this.cardHolderName = cardHolderName;
		this.cardExpiration = cardExpiration;
	}

	public Paymentdetails(User user, String cardType, String cardNumber, String cardSecurityCode, String cardHolderName,
			Date cardExpiration, Boolean cardPresent) {
		this.user = user;
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cardSecurityCode = cardSecurityCode;
		this.cardHolderName = cardHolderName;
		this.cardExpiration = cardExpiration;
		this.cardPresent = cardPresent;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_PaymentID", unique = true, nullable = false)
	public Integer getPkPaymentId() {
		return this.pkPaymentId;
	}

	public void setPkPaymentId(Integer pkPaymentId) {
		this.pkPaymentId = pkPaymentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FK_UserID", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "CardType", nullable = false, length = 20)
	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	@Column(name = "CardNumber", nullable = false, length = 16)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "CardSecurityCode", nullable = false, length = 3)
	public String getCardSecurityCode() {
		return this.cardSecurityCode;
	}

	public void setCardSecurityCode(String cardSecurityCode) {
		this.cardSecurityCode = cardSecurityCode;
	}

	@Column(name = "CardHolderName", nullable = false, length = 35)
	public String getCardHolderName() {
		return this.cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CardExpiration", nullable = false, length = 10)
	public Date getCardExpiration() {
		return this.cardExpiration;
	}

	public void setCardExpiration(Date cardExpiration) {
		this.cardExpiration = cardExpiration;
	}

	@Column(name = "CardPresent")
	public Boolean getCardPresent() {
		return this.cardPresent;
	}

	public void setCardPresent(Boolean cardPresent) {
		this.cardPresent = cardPresent;
	}

}
