package com.cts.insurancecompany;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.cts.insurancecompany.controllers.MyController;
import com.cts.insurancecompany.entities.ClaimDetails;
import com.cts.insurancecompany.entities.Surveyor;
import com.cts.insurancecompany.services.ClaimDetailsService;
import com.cts.insurancecompany.services.SurveyorService;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class InsurancecompanyApplicationTests {
	private static MockMvc mockMvc;

	@Mock
	private SurveyorService surveyorService;

	@Mock
	private ClaimDetailsService claimDetailsService;

	@InjectMocks
	private MyController myController;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
	}

	@Test
	public void testGetAllClaimsList() throws Exception {
		// Arrange
		List<ClaimDetails> claimsList = new ArrayList<ClaimDetails>();
		claimsList.add(new ClaimDetails());
		claimsList.add(new ClaimDetails());
		when(claimDetailsService.getAllOpenClaims()).thenReturn(claimsList);

		// Act
		mockMvc.perform(get("/api/claims")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(2)));

		// Assert
		verify(claimDetailsService, times(1)).getAllOpenClaims();
	}

	@Test
	public void testAddClaim() throws Exception {
		// Arrange
		ClaimDetails claimDetails = new ClaimDetails();
		when(claimDetailsService.addClaim(any(ClaimDetails.class))).thenReturn(claimDetails);

		// Act
		mockMvc.perform(post("/api/claims/new").contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", notNullValue()));

		// Assert
		verify(claimDetailsService, times(1)).addClaim(any(ClaimDetails.class));
	}

	@Test
	public void testGetAllSurveyors() throws Exception {
		// Arrange
		List<Surveyor> surveyorsList = new ArrayList<>();
		surveyorsList.add(new Surveyor());
		surveyorsList.add(new Surveyor());
		when(surveyorService.getAllSurveyorsByEstimatedLoss(anyInt())).thenReturn(surveyorsList);

		// Act
		mockMvc.perform(get("/api/surveyors/{estimatedLoss}", 5000)).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)));

		// Assert
		verify(surveyorService, times(1)).getAllSurveyorsByEstimatedLoss(anyInt());
	}

	@Test
	public void testUpdateClaimById() throws Exception {
		// Arrange
		String claimId = "CL00000001";
		ClaimDetails claimDetails = new ClaimDetails();
		when(claimDetailsService.updateClaim(eq(claimId), any(ClaimDetails.class))).thenReturn(claimDetails);

		// Act
		mockMvc.perform(
				put("/api/claims/{claimId}/update", claimId).contentType(MediaType.APPLICATION_JSON).content("{}"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", notNullValue()));

		// Assert
		verify(claimDetailsService, times(1)).updateClaim(eq(claimId), any(ClaimDetails.class));
	}

	@Test
	public void testGetSurveyorFeesByClaimId() throws Exception {
		// Arrange
		String claimId = "CL00000001";
		int surveyorFees = 2000;
		when(claimDetailsService.getSurveyorFees(eq(claimId))).thenReturn(surveyorFees);

		// Act
		mockMvc.perform(get("/api/surveyorfees/{claimId}", claimId)).andExpect(status().isOk())
				.andExpect(content().string(String.valueOf(surveyorFees)));

		// Assert
		verify(claimDetailsService, times(1)).getSurveyorFees(eq(claimId));
	}

	@Test
	public void testUpdateClaimAmount() throws Exception {
		// Arrange
		String claimId = "CL00000001";
		int claimAmount = 10000;
		ClaimDetails claimDetails = new ClaimDetails();
		when(claimDetailsService.updateClaimAmount(eq(claimId), eq(claimAmount))).thenReturn(claimDetails);

		// Act
		mockMvc.perform(put("/api/claims/{claimId}/{claimAmount}/update", claimId, claimAmount))
				.andExpect(status().isOk()).andExpect(jsonPath("$.id", notNullValue()));

		// Assert
		verify(claimDetailsService, times(1)).updateClaimAmount(eq(claimId), eq(claimAmount));
	}

	@Test
	public void testGetPendingClaims() throws Exception {
		// Arrange
		int month = 5;
		int year = 2023;
		int pendingClaims = 10;
		when(claimDetailsService.getOpenClaimsByMonthYear(eq(month), eq(year))).thenReturn(pendingClaims);

		// Act
		mockMvc.perform(get("/api/claimStatus/report/{month}/{year}", month, year)).andExpect(status().isOk())
				.andExpect(content().string(String.valueOf(pendingClaims)));

		// Assert
		verify(claimDetailsService, times(1)).getOpenClaimsByMonthYear(eq(month), eq(year));
	}

	@Test
	public void testGetApprovedAmount() throws Exception {
		// Arrange
		int month = 5;
		int year = 2023;
		int approvedAmount = 50000;
		when(claimDetailsService.getApprovedAmount(eq(month), eq(year))).thenReturn(approvedAmount);

		// Act
		mockMvc.perform(get("/api/paymentStatus/report/{month}/{year}", month, year)).andExpect(status().isOk())
				.andExpect(content().string(String.valueOf(approvedAmount)));

		// Assert
		verify(claimDetailsService, times(1)).getApprovedAmount(eq(month), eq(year));
	}
}
