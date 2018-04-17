package com.houseofcards.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.houseofcards.entities.generated.Logininfo;
import com.houseofcards.entities.generated.Paymentdetails;
import com.houseofcards.entities.generated.Premiumcustomerdetails;
import com.houseofcards.entities.generated.Sale;
import com.houseofcards.entities.generated.Saleitems;
import com.houseofcards.entities.generated.User;


public class SalesByUser {

	
	private User user;
	private BigDecimal saleTotal;
	

	public SalesByUser(User user, BigDecimal saleTotal) {
		this.user = user;
		this.saleTotal = saleTotal;
	}

	public BigDecimal getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(BigDecimal saleTotal) {
		this.saleTotal = saleTotal;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
}
