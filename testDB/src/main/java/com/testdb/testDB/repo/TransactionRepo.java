package com.testdb.testDB.repo;

import com.testdb.testDB.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTransactionDate(String transactionDate);

    List<Transaction> findByTransactionType(int transactionType);
    // Custom query methods (if any)...
}