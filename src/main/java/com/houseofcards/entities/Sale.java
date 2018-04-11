package com.houseofcards.entities;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sale")
public class Sale extends com.houseofcards.entities.Entity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer PK_SaleID;

    private Double saleTotal;
    
    private Date dateTime;
    
    private Integer FK_UserID;
    
    @Override
    public void print() {
	System.out.printf("Sale Id: %d%n"
		+ "Total: %.2f%n",
		getPK_SaleID(), getSaleTotal());
    }

    public Integer getPK_SaleID() {
	return PK_SaleID;
    }

    public void setPK_SaleID(Integer pK_SaleID) {
	PK_SaleID = pK_SaleID;
    }

    public Double getSaleTotal() {
	return saleTotal;
    }

    public void setSaleTotal(Double saleTotal) {
	this.saleTotal = saleTotal;
    }

    public Integer getFK_UserID() {
	return FK_UserID;
    }

    public void setFK_UserID(Integer fK_UserID) {
	FK_UserID = fK_UserID;
    }

    public Date getDateTime() {
	return dateTime;
    }

    public void setDateTime(Date dateTime) {
	this.dateTime = dateTime;
    }
    
}
