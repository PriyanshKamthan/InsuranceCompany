package com.cts.insurancecompany.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "policy")
public class Policy {

	@Id
	@Column(length =7)
	private String policyNo;
	
	@Column(length =5)
	private String insuredFirstName;
	
	@Column(length =5)
	private String insuredLastName;
	
	@Temporal(TemporalType.DATE)
    private Date dateOfInsurance;
	private String emailId;
	private String vehicleNo;
	private boolean status;

	@JsonIgnore
	@OneToMany(mappedBy = "policy", fetch = FetchType.EAGER)
	private List<ClaimDetails> claimList = new ArrayList<ClaimDetails>();

	public Policy(String policyNo, String insuredFirstName, String insuredLastName, Date dateOfInsurance,
			String emailId, String vehicleNo, boolean status, List<ClaimDetails> claimList) {
		super();
		this.policyNo = policyNo;
		this.insuredFirstName = insuredFirstName;
		this.insuredLastName = insuredLastName;
		this.dateOfInsurance = dateOfInsurance;
		this.emailId = emailId;
		this.vehicleNo = vehicleNo;
		this.status = status;
		this.claimList = claimList;
	}

	public Policy() {
		super();
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getInsuredFirstName() {
		return insuredFirstName;
	}

	public void setInsuredFirstName(String insuredFirstName) {
		this.insuredFirstName = insuredFirstName;
	}

	public String getInsuredLastName() {
		return insuredLastName;
	}

	public void setInsuredLastName(String insuredLastName) {
		this.insuredLastName = insuredLastName;
	}

	public Date getDateOfInsurance() {
		return dateOfInsurance;
	}

	public void setDateOfInsurance(Date dateOfInsurance) {
		this.dateOfInsurance = dateOfInsurance;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<ClaimDetails> getClaimList() {
		return claimList;
	}

	public void setClaimList(List<ClaimDetails> claimList) {
		this.claimList = claimList;
	}

	@Override
	public String toString() {
		return "Policy [policyNo=" + policyNo + ", insuredFirstName=" + insuredFirstName + ", insuredLastName="
				+ insuredLastName + ", dateOfInsurance=" + dateOfInsurance + ", emailId=" + emailId + ", vehicleNo="
				+ vehicleNo + ", status=" + status +"]";
	}
}
