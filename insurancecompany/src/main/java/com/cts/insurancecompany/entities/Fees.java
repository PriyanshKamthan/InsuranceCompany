package com.cts.insurancecompany.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fees {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feeId;
	private int estimatedStartLimit;
	private int estimatedEndLimit;
	private int fees;

	public int getFeeId() {
		return feeId;
	}

	public void setFeeId(int feeId) {
		this.feeId = feeId;
	}

	public int getEstimatedStartLimit() {
		return estimatedStartLimit;
	}

	public void setEstimatedStartLimit(int estimatedStartLimit) {
		this.estimatedStartLimit = estimatedStartLimit;
	}

	public int getEstimatedEndLimit() {
		return estimatedEndLimit;
	}

	public void setEstimatedEndLimit(int estimatedEndLimit) {
		this.estimatedEndLimit = estimatedEndLimit;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public Fees() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Fees(int feeId, int estimatedStartLimit, int estimatedEndLimit, int fees) {
		super();
		this.feeId = feeId;
		this.estimatedStartLimit = estimatedStartLimit;
		this.estimatedEndLimit = estimatedEndLimit;
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "Fees [feeId=" + feeId + ", estimatedStartLimit=" + estimatedStartLimit + ", estimatedEndLimit="
				+ estimatedEndLimit + ", fees=" + fees + "]";
	}
}
