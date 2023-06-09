package com.cts.insurancecompany.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cts.insurancecompany.entities.Policy;

public interface PolicyRepository extends JpaRepository<Policy, String> {

}
