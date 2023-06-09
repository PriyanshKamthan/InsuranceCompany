package com.cts.insurancecompany;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InsurancecompanyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(InsurancecompanyApplication.class, args);	
	}
}

//FeesRepository feesRepository = context.getBean(FeesRepository.class);
//
//Fees fee = new Fees();
//
//// creating fee object
//fee.setEstimatedStartLimit(5000);
//fee.setEstimatedEndLimit(10000);
//fee.setFees(500);
//
//// saving to database
//Fees returnfees = feesRepository.save(fee);
//System.out.println(returnfees);
//
//ClaimDetailsRepository claimRepo = context.getBean(ClaimDetailsRepository.class);
//PolicyRepository policyRepo = context.getBean(PolicyRepository.class);
//SurveyorRepository surveyorRepo = context.getBean(SurveyorRepository.class);
//
//
//// saving random policies
//Policy policy1 = new Policy();
//policy1.setPolicyNo("KA06623");
//policy1.setInsuredFirstName("Priyansh");
//policy1.setInsuredLastName("Kamthan");
//policy1.setDateOfInsurance(new SimpleDateFormat("dd/MM/yyyy").parse("22/08/2023"));
//policy1.setEmailId("priyansh.kamthan123@gmail.com");
//policy1.setVehicleNo("UP-32-BF-0669");
//policy1.setStatus(true);
//
//Policy policy2 = new Policy();
//policy2.setPolicyNo("GA01123");
//policy2.setInsuredFirstName("Ashish");
//policy2.setInsuredLastName("Gangwar");
//policy2.setDateOfInsurance(new SimpleDateFormat("dd/MM/yyyy").parse("27/09/2023"));
//policy2.setEmailId("ashu969027@gmail.com");
//policy2.setVehicleNo("UP-16-AR-8981");
//policy2.setStatus(true);
//
//Policy policy3 = new Policy();
//policy3.setPolicyNo("SA19123");
//policy3.setInsuredFirstName("Sudhanshu");
//policy3.setInsuredLastName("Saini");
//policy3.setDateOfInsurance(new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2023"));
//policy3.setEmailId("sudhanshusaini546@gmail.com");
//policy3.setVehicleNo("UP-25-AY-1913");
//policy3.setStatus(true);
//
//// saving random surveyors
//Surveyor surveyor1 = new Surveyor();
//surveyor1.setFirstName("Anurag");
//surveyor1.setLastName("Katheriya");
//surveyor1.setEstimateLimit(1000000);
//
//Surveyor surveyor2 = new Surveyor();
//surveyor2.setFirstName("Shivam");
//surveyor2.setLastName("Sharma");
//surveyor2.setEstimateLimit(700000);
//
//Surveyor surveyor3 = new Surveyor();
//surveyor3.setFirstName("Manjeet");
//surveyor3.setLastName("Rai");
//surveyor3.setEstimateLimit(500000);
//
//ClaimDetails claim1 = new ClaimDetails();
//claim1.setClaimId("CLKA062023");
//claim1.setPolicy(policy1);
//claim1.setEstimatedLoss(50000);
//claim1.setDateOfAccident(new SimpleDateFormat("dd/MM/yyyy").parse("18/10/2023"));
//claim1.setClaimStatus(true);
//claim1.setSurveyor(surveyor3);
//claim1.setAmtApprovedBySurveyor(30000);
//claim1.setSurveyorFees(1000);
//
//policyRepo.saveAll(List.of(policy1, policy2, policy3));
//surveyorRepo.saveAll(List.of(surveyor1, surveyor2, surveyor3));
//claimRepo.save(claim1);
//
//System.out.println("Saved Data...");
//List<ClaimDetails> list = policyRepo.getActiveClaimsByMonthYear("september",2023);
//System.out.println(list);

//System.out.println(policyRepo.getCompanyApprovedAmountOfMonthYear("october",2023));

//SurveyorRepository surveyorRepo = context.getBean(SurveyorRepository.class);
//System.out.println(surveyorRepo.retrieveAllSurveyor());
