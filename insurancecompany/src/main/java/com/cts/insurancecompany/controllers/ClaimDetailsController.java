package com.cts.insurancecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.insurancecompany.entities.ClaimDetails;
import com.cts.insurancecompany.services.ClaimDetailsService;

@RestController
@RequestMapping("api/claims")
public class ClaimDetailsController {

	@Autowired
	private ClaimDetailsService claimDetailsService;

	@GetMapping("/all")
	private List<ClaimDetails> getAllClaims() {
		return this.claimDetailsService.getAllClaims();
	}
	
	@GetMapping("/{claimId}")
	private ClaimDetails getClaimDetailsById(@PathVariable String claimId) {
		return this.claimDetailsService.findClaimByClaimId(claimId);
	}

	// add new claim
	// endpoint 2.1
	@PostMapping(path = "/new/{policyNo}/{surveyorId}", consumes = "application/json")
	public ClaimDetails addClaim(@RequestBody ClaimDetails claimDetails, @PathVariable String policyNo,
			@PathVariable int surveyorId) {
		return this.claimDetailsService.addClaim(claimDetails, policyNo, surveyorId);
	}

	// update claim
	// endpoint 3 - view in MyController
}
