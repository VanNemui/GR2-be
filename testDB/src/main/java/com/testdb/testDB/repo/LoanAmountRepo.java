package com.testdb.testDB.repo;

import com.testdb.testDB.model.LoanAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface LoanAmountRepo extends JpaRepository<LoanAmount, Long> {
}
