package com.cts.insurancecompany.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Surveyor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int surveyorId;
	
	private String firstName;
	private String lastName;
	
	private int estimateLimit;

	@JsonIgnore
	@OneToMany(mappedBy = "surveyor")
	private List<ClaimDetails> claimList;

	public Surveyor(int surveyorId, String firstName, String lastName, int estimateLimit,
			List<ClaimDetails> claimList) {
		super();
		this.surveyorId = surveyorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.estimateLimit = estimateLimit;
		this.claimList = claimList;
	}

	public Surveyor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSurveyorId() {
		return surveyorId;
	}

	public void setSurveyorId(int surveyorId) {
		this.surveyorId = surveyorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getEstimateLimit() {
		return estimateLimit;
	}

	public void setEstimateLimit(int estimateLimit) {
		this.estimateLimit = estimateLimit;
	}

	public List<ClaimDetails> getClaimList() {
		return claimList;
	}

	public void setClaimList(List<ClaimDetails> claimList) {
		this.claimList = claimList;
	}

	@Override
	public String toString() {
		return "Surveyor [surveyorId=" + surveyorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", estimateLimit=" + estimateLimit + "]";
	}
}
