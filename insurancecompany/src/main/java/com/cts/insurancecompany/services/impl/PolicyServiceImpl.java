package com.cts.insurancecompany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.insurancecompany.dao.PolicyRepository;
import com.cts.insurancecompany.entities.Policy;
import com.cts.insurancecompany.exceptions.InvalidPolicyException;
import com.cts.insurancecompany.services.InsuranceCompanyUtil;
import com.cts.insurancecompany.services.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {

	@Autowired
	private PolicyRepository policyRepository;

	@Override
	public List<Policy> getAllPolicies() {
		return this.policyRepository.findAll();
	}

	@Override
	public Policy addPolicy(Policy policy) {
		String policyNo = InsuranceCompanyUtil.generatePolicyNo(policy);
		policy.setPolicyNo(policyNo);
		return this.policyRepository.save(policy);
	}

	public Policy findPolicyByPolicyNo(String policyNo) {
		Policy policy = this.policyRepository.findById(policyNo)
				.orElseThrow(() -> new InvalidPolicyException("Invalid Policy Number: " + policyNo));

		return policy;
	}

	@Override
	public Policy updatePolicy(String policyNo, Policy policy) {
		this.findPolicyByPolicyNo(policyNo);
		return policyRepository.save(policy);
	}

	@Override
	public void deletePolicy(String policyNo) {
		this.findPolicyByPolicyNo(policyNo);
		this.policyRepository.deleteById(policyNo);
	}
}
