package com.cts.insurancecompany.services;

import java.util.List;

import com.cts.insurancecompany.entities.Policy;

public interface PolicyService {

	// Create policy
	public Policy addPolicy(Policy policy);

	// Read one policy
	public Policy findPolicyByPolicyNo(String policyNo);

	// Read all policies
	public List<Policy> getAllPolicies();

	// Update policy
	public Policy updatePolicy(String policyNo, Policy policy);

	// Delete policy by policy no
	public void deletePolicy(String policyNo);
}
