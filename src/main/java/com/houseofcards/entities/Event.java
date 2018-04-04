package com.houseofcards.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import com.houseofcards.services.CrudService;

@Entity
@Table(name = "events")
public class Event extends com.houseofcards.entities.Entity {

    @Id
    @Column(name = "PK_EventID", nullable = true)
    private Integer PK_EventID;

    private String eventName;
    
    private String eventDescription;
    
    private Date dateBegin;
    
    private Date dateEnd;
        
    
    @Override
    public void print() {
	System.out.printf("Event Id: %d%n"
		+ "Name: %.2f",
		getPK_EventID(), getEventName());
    }
    
    
    public Integer getPK_EventID() {
	return PK_EventID;
    }

    public void setPK_EventID(Integer PK_EventID) {
	this.PK_EventID = PK_EventID;
    }

    public String getEventName() {
	return eventName;
    }

    public void setEventName(String eventName) {
	this.eventName = eventName;
    }


    public String getEventDescription() {
	return eventDescription;
    }


    public void setEventDescription(String eventDescription) {
	this.eventDescription = eventDescription;
    }


    public Date getDateBegin() {
	return dateBegin;
    }


    public void setDateBegin(Date dateBegin) {
	this.dateBegin = dateBegin;
    }


    public Date getDateEnd() {
	return dateEnd;
    }


    public void setDateEnd(Date dateEnd) {
	this.dateEnd = dateEnd;
    }
    
}
