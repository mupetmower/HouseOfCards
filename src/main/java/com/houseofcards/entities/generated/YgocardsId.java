package com.houseofcards.entities.generated;
// Generated Apr 30, 2018 1:29:43 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * YgocardsId generated by hbm2java
 */
@Embeddable
public class YgocardsId implements java.io.Serializable {

	private int pkYgoCardId;
	private int fkProductId;

	public YgocardsId() {
	}

	public YgocardsId(int pkYgoCardId, int fkProductId) {
		this.pkYgoCardId = pkYgoCardId;
		this.fkProductId = fkProductId;
	}

	@Column(name = "PK_YgoCardID", unique = true, nullable = false)
	public int getPkYgoCardId() {
		return this.pkYgoCardId;
	}

	public void setPkYgoCardId(int pkYgoCardId) {
		this.pkYgoCardId = pkYgoCardId;
	}

	@Column(name = "FK_ProductID", unique = true, nullable = false)
	public int getFkProductId() {
		return this.fkProductId;
	}

	public void setFkProductId(int fkProductId) {
		this.fkProductId = fkProductId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof YgocardsId))
			return false;
		YgocardsId castOther = (YgocardsId) other;

		return (this.getPkYgoCardId() == castOther.getPkYgoCardId())
				&& (this.getFkProductId() == castOther.getFkProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPkYgoCardId();
		result = 37 * result + this.getFkProductId();
		return result;
	}

}
