package com.cts.insurancecompany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.insurancecompany.dao.SurveyorRepository;
import com.cts.insurancecompany.entities.Surveyor;
import com.cts.insurancecompany.exceptions.InvalidSurveyorException;
import com.cts.insurancecompany.services.SurveyorService;

@Service
public class SurveyorServiceImpl implements SurveyorService {

	@Autowired
	private SurveyorRepository surveyorRepository;

	@Override
	public List<Surveyor> getAllSurveyorsByEstimatedLoss(int estimatedLoss) {
		return this.surveyorRepository.retrieveAllSurveyor(estimatedLoss);
	}

	@Override
	public Surveyor addSurveyor(Surveyor surveyor) {
		return this.surveyorRepository.save(surveyor);
	}

	@Override
	public List<Surveyor> getAllSurveyors() {
		return this.surveyorRepository.findAll();
	}

	@Override
	public Surveyor findSurveyorBySurveyorId(int surveyorId) {
		Surveyor surveyor = this.surveyorRepository.findById(surveyorId)
				.orElseThrow(() -> new InvalidSurveyorException("Invalid Surveyor ID: " + surveyorId));
		return surveyor;
	}

	@Override
	public Surveyor updateSurveyor(int surveyorId, Surveyor surveyor) {
		this.findSurveyorBySurveyorId(surveyorId);
		return this.surveyorRepository.save(surveyor);
	}

	@Override
	public void deleteSurveyor(int surveyorId) {
		this.findSurveyorBySurveyorId(surveyorId);
		this.surveyorRepository.deleteById(surveyorId);
	}

}
