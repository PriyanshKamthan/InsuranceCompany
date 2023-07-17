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

import com.cts.insurancecompany.entities.Surveyor;
import com.cts.insurancecompany.services.SurveyorService;

@RestController
@CrossOrigin
@RequestMapping("/api/surveyor")
public class SurveyorController {

	@Autowired
	private SurveyorService surveyorService;

	// get list of all surveyors
	@GetMapping("/all")
	public List<Surveyor> getAllSurveyors() {
		return this.surveyorService.getAllSurveyors();
	}

	// get surveyor by surveyorId
	@GetMapping("/{surveyorId}")
	public Surveyor getSurveyorBySurveyorId(@PathVariable int surveyorId) {
		return this.surveyorService.findSurveyorBySurveyorId(surveyorId);
	}

	// add new surveyor
	@PostMapping(path = "/new", consumes = "application/json")
	public Surveyor addClaim(@RequestBody Surveyor surveyor) {
		return this.surveyorService.addSurveyor(surveyor);
	}

	// update operation on particular surveyor
	@PutMapping("/{surveyorId}/update")
	public Surveyor updateSurveyorBySurveyorId(@PathVariable int surveyorId, @RequestBody Surveyor surveyor) {
		return this.surveyorService.updateSurveyor(surveyorId, surveyor);
	}

	// Deleting surveyor by surveyorId
	@DeleteMapping("/{surveyorId}/delete")
	public void deleteSurveyorBySurveyorId(@PathVariable int surveyorId) {
		this.surveyorService.deleteSurveyor(surveyorId);
	}
}
