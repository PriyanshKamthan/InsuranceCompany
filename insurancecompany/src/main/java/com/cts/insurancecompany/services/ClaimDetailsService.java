package com.cts.insurancecompany.services;

import java.util.List;

import com.cts.insurancecompany.entities.ClaimDetails;

public interface ClaimDetailsService {

	// return list of claims whose claimStatus is true/open
	public List<ClaimDetails> getAllOpenClaims();

	// return the sum of amount approved by company in particular month and year
	public int getApprovedAmount(int month, int year);

	// return the total number of pending claim of particular month and year
	public int getOpenClaimsByMonthYear(int month, int year);

	// return the updated claim after updating the claim amount of the claim
	// called by surveyor
	public ClaimDetails updateClaimAmount(String claimId, int claimAmount);

	// return the surveyor's fee that is internally calculated using estimated loss
	public int getSurveyorFees(String claimId);

	// Read all claims
	public List<ClaimDetails> getAllClaims();

	// Read one claim, by Id
	public ClaimDetails findClaimByClaimId(String claimId);

	// Create claim
	public ClaimDetails addClaim(ClaimDetails claimDetails);

	// Create claim with policyNo, surveyorId
	public ClaimDetails addClaim(ClaimDetails claimDetails, String policyNo, int surveyorId);

	// Update particular claim
	public ClaimDetails updateClaim(String claimId, ClaimDetails claimDetails);
}
