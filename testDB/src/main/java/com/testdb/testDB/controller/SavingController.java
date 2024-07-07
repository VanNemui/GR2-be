package com.testdb.testDB.controller;

import com.testdb.testDB.model.LoanAmount;
import com.testdb.testDB.model.Saving;
import com.testdb.testDB.service.LoanAmountService;
import com.testdb.testDB.service.SavingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/save")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SavingController {

    @Autowired
    private SavingService savingService;

    @GetMapping("/all")
    public ResponseEntity<List<Saving>> getAllSaving() {
        return ResponseEntity.ok(savingService.getAllSaving());
    }
}
