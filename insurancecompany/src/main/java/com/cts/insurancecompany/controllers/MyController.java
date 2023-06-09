package com.cts.insurancecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.insurancecompany.entities.ClaimDetails;
import com.cts.insurancecompany.entities.Surveyor;
import com.cts.insurancecompany.services.ClaimDetailsService;
import com.cts.insurancecompany.services.SurveyorService;

@RestController
@RequestMapping("/api")
public class MyController {

	@Autowired
	private SurveyorService surveyorService;

	@Autowired
	private ClaimDetailsService claimDetailsService;

	@GetMapping("/home")
	public String home() {
		return "Welcome to Insurance Company Home Page";
	}

	// endpoint 1
	@GetMapping("/claims")
	public List<ClaimDetails> getAllClaimsList() {
		return this.claimDetailsService.getAllOpenClaims();
	}

	// endpoint 2
	@PostMapping(path = "/claims/new", consumes = "application/json")
	public ClaimDetails addClaim(@RequestBody ClaimDetails cd) {
		return this.claimDetailsService.addClaim(cd);
	}

	// endpoint 3
	@GetMapping("/surveyors/{estimatedLoss}")
	public List<Surveyor> getAllSurveyors(@PathVariable int estimatedLoss) {
		return this.surveyorService.getAllSurveyorsByEstimatedLoss(estimatedLoss);
	}

	// endpoint 4
	@PutMapping("/claims/{claimId}/update")
	public ClaimDetails updateClaimById(@PathVariable String claimId, @RequestBody ClaimDetails claimDetails) {
		return this.claimDetailsService.updateClaim(claimId, claimDetails);
	}

	//endpoint 5
	@GetMapping("/surveyorfees/{claimId}")
	public int getSurveyorFeesByClaimId(@PathVariable String claimId) {
		return this.claimDetailsService.getSurveyorFees(claimId);
	}
	
	//endpoint 6
	@PutMapping("/claims/{claimId}/{claimAmount}/update")
	public ClaimDetails updateClaimAmount(@PathVariable String claimId, @PathVariable int claimAmount) {
		return this.claimDetailsService.updateClaimAmount(claimId, claimAmount);
	}
	
	// endpoint 7
	@GetMapping("/claimStatus/report/{month}/{year}")
	public int getPendingClaims(@PathVariable int month, @PathVariable int year) {
		return this.claimDetailsService.getOpenClaimsByMonthYear(month, year);
	}

	// endpoint 8
	@GetMapping("/paymentStatus/report/{month}/{year}")
	public int getApprovedAmount(@PathVariable int month, @PathVariable int year) {
		return this.claimDetailsService.getApprovedAmount(month, year);
	}
}
