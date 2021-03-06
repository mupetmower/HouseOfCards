package com.houseofcards.entities.generated;
// Generated Apr 30, 2018 1:29:43 PM by Hibernate Tools 5.2.8.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MtgcardsId generated by hbm2java
 */
@Embeddable
public class MtgcardsId implements java.io.Serializable {

	private int pkMtgCardId;
	private int fkProductId;

	public MtgcardsId() {
	}

	public MtgcardsId(int pkMtgCardId, int fkProductId) {
		this.pkMtgCardId = pkMtgCardId;
		this.fkProductId = fkProductId;
	}

	@Column(name = "PK_MtgCardID", unique = true, nullable = false)
	public int getPkMtgCardId() {
		return this.pkMtgCardId;
	}

	public void setPkMtgCardId(int pkMtgCardId) {
		this.pkMtgCardId = pkMtgCardId;
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
		if (!(other instanceof MtgcardsId))
			return false;
		MtgcardsId castOther = (MtgcardsId) other;

		return (this.getPkMtgCardId() == castOther.getPkMtgCardId())
				&& (this.getFkProductId() == castOther.getFkProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getPkMtgCardId();
		result = 37 * result + this.getFkProductId();
		return result;
	}

}
