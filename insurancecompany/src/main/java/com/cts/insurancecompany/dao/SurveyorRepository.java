package com.cts.insurancecompany.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.insurancecompany.entities.Surveyor;

@Repository
public interface SurveyorRepository extends JpaRepository<Surveyor, Integer> {
	@Query("select c from Surveyor c where c.estimateLimit >=:e")
	public List<Surveyor> retrieveAllSurveyor(@Param("e") int estimatedLoss);
}
