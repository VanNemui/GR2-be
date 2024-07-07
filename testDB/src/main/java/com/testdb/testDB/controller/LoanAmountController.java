package com.testdb.testDB.controller;

import com.testdb.testDB.model.LoanAmount;
import com.testdb.testDB.model.MoneyJar;
import com.testdb.testDB.service.LoanAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/loan")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LoanAmountController {

    @Autowired
    private LoanAmountService loanAmountService;

    @GetMapping("/all")
    public ResponseEntity<List<LoanAmount>> getAllLoanAmount() {
        return ResponseEntity.ok(loanAmountService.getAllLoanAmount());
    }
}
