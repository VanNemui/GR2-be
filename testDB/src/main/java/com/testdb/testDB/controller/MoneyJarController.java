package com.testdb.testDB.controller;

import com.testdb.testDB.model.MoneyJar;
import com.testdb.testDB.service.MoneyJarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/moneyjar")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MoneyJarController {
    @Autowired
    private MoneyJarService moneyJarService;

    @GetMapping("/all")
    public ResponseEntity<List<MoneyJar>> getAllMoneyJar() {
        return ResponseEntity.ok(moneyJarService.getAllMoneyJar());
    }
}
