package com.houseofcards.entities.generated;
// Generated Apr 18, 2018 1:58:05 PM by Hibernate Tools 5.2.8.Final

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
 * Events generated by hbm2java
 */
@Entity
@Table(name = "events", catalog = "houseofcards")
public class Events implements java.io.Serializable {

	private Integer pkEventId;
	private String eventName;
	private String eventDescription;
	private Date dateBegin;
	private Date dateEnd;
	private String eventImageUri;
	private Set<Discount> discounts = new HashSet<Discount>(0);

	public Events() {
	}

	public Events(String eventName, Date dateBegin, Date dateEnd) {
		this.eventName = eventName;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
	}

	public Events(String eventName, String eventDescription, Date dateBegin, Date dateEnd, String eventImageUri,
			Set<Discount> discounts) {
		this.eventName = eventName;
		this.eventDescription = eventDescription;
		this.dateBegin = dateBegin;
		this.dateEnd = dateEnd;
		this.eventImageUri = eventImageUri;
		this.discounts = discounts;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "PK_EventID", unique = true, nullable = false)
	public Integer getPkEventId() {
		return this.pkEventId;
	}

	public void setPkEventId(Integer pkEventId) {
		this.pkEventId = pkEventId;
	}

	@Column(name = "EventName", nullable = false, length = 30)
	public String getEventName() {
		return this.eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	@Column(name = "EventDescription", length = 800)
	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateBegin", nullable = false, length = 10)
	public Date getDateBegin() {
		return this.dateBegin;
	}

	public void setDateBegin(Date dateBegin) {
		this.dateBegin = dateBegin;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "DateEnd", nullable = false, length = 10)
	public Date getDateEnd() {
		return this.dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	@Column(name = "EventImageURI", length = 45)
	public String getEventImageUri() {
		return this.eventImageUri;
	}

	public void setEventImageUri(String eventImageUri) {
		this.eventImageUri = eventImageUri;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "events")
	public Set<Discount> getDiscounts() {
		return this.discounts;
	}

	public void setDiscounts(Set<Discount> discounts) {
		this.discounts = discounts;
	}

}
