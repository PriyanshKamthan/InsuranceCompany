package com.cts.insurancecompany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.insurancecompany.entities.Policy;
import com.cts.insurancecompany.services.PolicyService;

@RestController
@CrossOrigin
@RequestMapping("/api/policy")
public class PolicyController {

	@Autowired
	private PolicyService policyService;

	// get list of all policies
	@GetMapping("/all")
	public List<Policy> getAllPolicies() {
		return this.policyService.getAllPolicies();
	}

	// get policy by policyNo
	@GetMapping("/{policyNo}")
	public Policy getPolicyByPolicyNo(@PathVariable String policyNo) {
		return this.policyService.findPolicyByPolicyNo(policyNo);
	}

	// add new policy without policyNo, as policyNo is auto generated
	@PostMapping(path = "/new", consumes = "application/json")
	public Policy addClaim(@RequestBody Policy policy) {
		return this.policyService.addPolicy(policy);
	}

	// update operation on particular policy
	@PutMapping("/{policyNo}/update")
	public Policy updatePolicyByPolicyNo(@PathVariable String policyNo, @RequestBody Policy policy) {
		return this.policyService.updatePolicy(policyNo, policy);
	}
	
	// Deleting policy by policy no
	@DeleteMapping("/{policyNo}/delete")
	public void deletePolicyByPolicyNo(@PathVariable String policyNo) {
		this.policyService.deletePolicy(policyNo);
	}
}
