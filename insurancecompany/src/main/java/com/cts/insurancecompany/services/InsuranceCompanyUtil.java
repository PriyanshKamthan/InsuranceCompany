package com.cts.insurancecompany.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cts.insurancecompany.entities.Policy;
import com.cts.insurancecompany.entities.Surveyor;

public class InsuranceCompanyUtil {

	// Check whether surveyor' limit is withing estimatedLoss or not
	public static boolean isWithinSurveyorLimit(int estimatedLoss, Surveyor surveyor) {
		return estimatedLoss >= 0 && estimatedLoss <= surveyor.getEstimateLimit();
	}

	// Implement the logic to generate the PolicyID based on the provided format
	public static String generatePolicyNo(Policy policy) {
		String lastNamePrefix = policy.getInsuredLastName().substring(0, 2).toUpperCase();
		String vehicleNumber = policy.getVehicleNo().split("-")[3].substring(0, 3);
		String year = LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
		return lastNamePrefix + vehicleNumber + year;
	}

	// Implement the logic to generate the ClaimID based on the provided format
	public static String generateClaimId(String policyId) {
		String year = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy"));
		return "CL" + policyId.substring(2) + year;
	}

	// Calculate the surveyor's fee based on the estimated loss
	public static int calculateSurveyorFees(int estimatedLoss) {
		if (estimatedLoss >= 5000 && estimatedLoss < 10000) {
			return 1000;
		} else if (estimatedLoss >= 10000 && estimatedLoss < 20000) {
			return 2000;
		} else if (estimatedLoss >= 20000 && estimatedLoss < 70000) {
			return 7000;
		} else if (estimatedLoss >= 70000) {
			return 10000;
		} else {
			return 0;
		}
	}
}
