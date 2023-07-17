package com.cts.insurancecompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.insurancecompany.entities.ClaimDetails;

public interface ClaimDetailsRepository extends JpaRepository<ClaimDetails, String>{
	
	// return list of open claims
	@Query("select c from ClaimDetails c where claimStatus = false order by dateOfAccident")
	public List<ClaimDetails> getOpenClaims();
	
	//Return the number of pending claims in a specific month and year.
	@Query("select c from ClaimDetails c WHERE claimStatus = false AND month(dateOfAccident) =:m AND year(dateOfAccident) =:y")
	public List<ClaimDetails> getPendingClaimsByMonthYear(@Param("m") int month, @Param("y") int year);
	
	// Return the amount approved by the insurance company in a particular month and year.
	@Query("select sum(amtApprovedBySurveyor) from ClaimDetails c where insuranceCompanyApproval = false AND month(dateOfAccident) =:m AND year(dateOfAccident) =:y")
	public int getCompanyApprovedAmountOfMonthYear(@Param("m") int month, @Param("y") int year);
	
	// Return surveyor fees of particular claim
	@Query("select c.surveyorFees from ClaimDetails c where c.claimId =:i")
	public int getSurveyorFeesById(@Param("i") String claimId);
}
