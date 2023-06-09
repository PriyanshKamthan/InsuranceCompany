package com.cts.insurancecompany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.insurancecompany.dao.ClaimDetailsRepository;
import com.cts.insurancecompany.entities.ClaimDetails;
import com.cts.insurancecompany.entities.Policy;
import com.cts.insurancecompany.entities.Surveyor;
import com.cts.insurancecompany.exceptions.InvalidClaimDetailsException;
import com.cts.insurancecompany.exceptions.InvalidSurveyorException;
import com.cts.insurancecompany.exceptions.MaximumClaimLimitReachedException;
import com.cts.insurancecompany.services.ClaimDetailsService;
import com.cts.insurancecompany.services.InsuranceCompanyUtil;
import com.cts.insurancecompany.services.PolicyService;
import com.cts.insurancecompany.services.SurveyorService;

@Service
public class ClaimDetailsServiceImpl implements ClaimDetailsService {

	@Autowired
	private ClaimDetailsRepository claimDetailsRepo;

	@Autowired
	private PolicyService policyService;

	@Autowired
	private SurveyorService surveyorService;

	@Override
	public int getApprovedAmount(int month, int year) {
		try {
			int sum = this.claimDetailsRepo.getCompanyApprovedAmountOfMonthYear(month, year);
			return sum;
		} catch(Exception e) {
			return 0;
		}
	}

	@Override
	public int getOpenClaimsByMonthYear(int month, int year) {
		return this.claimDetailsRepo.getPendingClaimsByMonthYear(month, year).size();
	}

	@Override
	public List<ClaimDetails> getAllOpenClaims() {
		return this.claimDetailsRepo.getOpenClaims();
	}

	@Override
	public ClaimDetails updateClaim(String claimId, ClaimDetails claimDetails) {
		this.findClaimByClaimId(claimId);
		return claimDetailsRepo.save(claimDetails);
	}

	@Override
	public ClaimDetails updateClaimAmount(String claimId, int claimAmount) {
		ClaimDetails cd = this.findClaimByClaimId(claimId);
		cd.setAmtApprovedBySurveyor(claimAmount);
		cd.setClaimStatus(true);
		return claimDetailsRepo.save(cd);
	}

	@Override
	public int getSurveyorFees(String claimId) {
		ClaimDetails claim = this.findClaimByClaimId(claimId);

		int estimatedLoss = claim.getEstimatedLoss();
		int surveyorFees = InsuranceCompanyUtil.calculateSurveyorFees(estimatedLoss);

		claim.setSurveyorFees(surveyorFees);
		claimDetailsRepo.save(claim);

		return this.claimDetailsRepo.getSurveyorFeesById(claimId);
	}

	@Override
	public List<ClaimDetails> getAllClaims() {
		return claimDetailsRepo.findAll();
	}

	@Override
	public ClaimDetails addClaim(ClaimDetails claimDetails) {
		if (claimDetails == null) {
			throw new InvalidClaimDetailsException("Claim Details object is null");
		}

		String policyNo = claimDetails.getPolicy().getPolicyNo();
		int surveyorId = claimDetails.getSurveyor().getSurveyorId();

		return this.addClaim(claimDetails, policyNo, surveyorId);
	}

	@Override
	public ClaimDetails addClaim(ClaimDetails claimDetails, String policyNo, int surveyorId) {
		if (claimDetails == null)
			throw new InvalidClaimDetailsException("Claim Details object is null");

		Policy policy = policyService.findPolicyByPolicyNo(policyNo);
		Surveyor surveyor = surveyorService.findSurveyorBySurveyorId(surveyorId);
		String claimId = InsuranceCompanyUtil.generateClaimId(policyNo);

		if (surveyor.getEstimateLimit() < claimDetails.getEstimatedLoss())
			throw new InvalidSurveyorException("Surveyor's estimate limit is less than estimated loss");

		if (this.claimDetailsRepo.existsById(claimId))
			throw new MaximumClaimLimitReachedException("You can claim only once in an Year");

		claimDetails.setClaimId(claimId);
		claimDetails.setPolicy(policy);
		claimDetails.setSurveyor(surveyor);

		return this.claimDetailsRepo.save(claimDetails);
	}

	@Override
	public ClaimDetails findClaimByClaimId(String claimId) {
		ClaimDetails claimDetails = this.claimDetailsRepo.findById(claimId)
				.orElseThrow(() -> new InvalidClaimDetailsException("Invalid Claim ID: " + claimId));
		return claimDetails;
	}
}
