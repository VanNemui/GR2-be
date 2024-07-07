package com.testdb.testDB.service;

import com.testdb.testDB.model.LoanAmount;
import com.testdb.testDB.model.MoneyJar;
import com.testdb.testDB.repo.LoanAmountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanAmountService {
    @Autowired
    private LoanAmountRepo loanAmountRepo;

    public List<LoanAmount> getAllLoanAmount() {
        List<LoanAmount> list = loanAmountRepo.findAll();
        return list;
    }
}
