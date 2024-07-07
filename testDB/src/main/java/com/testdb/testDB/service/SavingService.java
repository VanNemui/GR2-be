package com.testdb.testDB.service;

import com.testdb.testDB.model.LoanAmount;
import com.testdb.testDB.model.Saving;
import com.testdb.testDB.repo.LoanAmountRepo;
import com.testdb.testDB.repo.SavingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingService {
    @Autowired
    private SavingRepo savingRepo;

    public List<Saving> getAllSaving() {
        List<Saving> list = savingRepo.findAll();
        return list;
    }
}
