package com.cts.insurancecompany.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ClaimDetails")
public class ClaimDetails {
	@Id
	@Column(length = 10)
	private String claimId;

	@ManyToOne(targetEntity = Policy.class)
	@JoinColumn(name = "policyNo")
	private Policy policy;

	private int estimatedLoss;

	@Temporal(TemporalType.DATE)
	private Date dateOfAccident;

	// false-claimOpen and true-claimClosed
	private boolean claimStatus;

	@ManyToOne(targetEntity = Surveyor.class)
	@JoinColumn(name = "surveyorId")
	private Surveyor surveyor;

	private int amtApprovedBySurveyor;

	@Column(columnDefinition = "boolean default false")
	private boolean insuranceCompanyApproval;

	@Column(columnDefinition = "boolean default false")
	private boolean withdrawClaim;

	private int surveyorFees;

	public ClaimDetails(String claimId, Policy policy, int estimatedLoss, Date dateOfAccident, boolean claimStatus,
			Surveyor surveyor, int amtApprovedBySurveyor, boolean insuranceCompanyApproval, boolean withdrawClaim,
			int surveyorFees) {
		super();
		this.claimId = claimId;
		this.policy = policy;
		this.estimatedLoss = estimatedLoss;
		this.dateOfAccident = dateOfAccident;
		this.claimStatus = claimStatus;
		this.surveyor = surveyor;
		this.amtApprovedBySurveyor = amtApprovedBySurveyor;
		this.insuranceCompanyApproval = insuranceCompanyApproval;
		this.withdrawClaim = withdrawClaim;
		this.surveyorFees = surveyorFees;
	}

	public ClaimDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getClaimId() {
		return claimId;
	}

	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}

	public int getEstimatedLoss() {
		return estimatedLoss;
	}

	public void setEstimatedLoss(int estimatedLoss) {
		this.estimatedLoss = estimatedLoss;
	}

	public Date getDateOfAccident() {
		return dateOfAccident;
	}

	public void setDateOfAccident(Date dateOfAccident) {
		this.dateOfAccident = dateOfAccident;
	}

	public boolean isClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(boolean claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Surveyor getSurveyor() {
		return surveyor;
	}

	public void setSurveyor(Surveyor surveyor) {
		this.surveyor = surveyor;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public int getAmtApprovedBySurveyor() {
		return amtApprovedBySurveyor;
	}

	public void setAmtApprovedBySurveyor(int amtApprovedBySurveyor) {
		this.amtApprovedBySurveyor = amtApprovedBySurveyor;
	}

	public boolean isInsuranceCompanyApproval() {
		return insuranceCompanyApproval;
	}

	public void setInsuranceCompanyApproval(boolean insuranceCompanyApproval) {
		this.insuranceCompanyApproval = insuranceCompanyApproval;
	}

	public boolean isWithdrawClaim() {
		return withdrawClaim;
	}

	public void setWithdrawClaim(boolean withdrawClaim) {
		this.withdrawClaim = withdrawClaim;
	}

	public int getSurveyorFees() {
		return surveyorFees;
	}

	public void setSurveyorFees(int surveyorFees) {
		this.surveyorFees = surveyorFees;
	}

	@Override
	public String toString() {
		return "ClaimDetails [claimId=" + claimId + ", policy=" + policy + ", estimatedLoss=" + estimatedLoss
				+ ", dateOfAccident=" + dateOfAccident + ", claimStatus=" + claimStatus + ", surveyor=" + surveyor
				+ ", amtApprovedBySurveyor=" + amtApprovedBySurveyor + ", insuranceCompanyApproval="
				+ insuranceCompanyApproval + ", withdrawClaim=" + withdrawClaim + ", surveyorFees=" + surveyorFees
				+ "]";
	}
}
