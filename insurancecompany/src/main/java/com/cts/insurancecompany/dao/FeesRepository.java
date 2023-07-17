package com.cts.insurancecompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.insurancecompany.entities.Fees;

public interface FeesRepository extends JpaRepository<Fees, Integer> {

}
