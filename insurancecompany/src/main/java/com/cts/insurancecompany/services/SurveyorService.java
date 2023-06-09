package com.cts.insurancecompany.services;

import java.util.List;

import com.cts.insurancecompany.entities.Surveyor;

public interface SurveyorService {

	// return list of all surveyors within the estimate limit
	public List<Surveyor> getAllSurveyorsByEstimatedLoss(int estimatedLoss);

	// Create surveyor
	public Surveyor addSurveyor(Surveyor surveyor);

	// Read all surveyors
	public List<Surveyor> getAllSurveyors();

	// Read one surveyor
	public Surveyor findSurveyorBySurveyorId(int surveyorId);

	// Update surveyor
	public Surveyor updateSurveyor(int surveyorId, Surveyor surveyor);

	// Delete surveyor
	public void deleteSurveyor(int surveyorId);
}
