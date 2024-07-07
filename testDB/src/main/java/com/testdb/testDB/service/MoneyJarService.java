package com.testdb.testDB.service;

import com.testdb.testDB.model.MoneyJar;
import com.testdb.testDB.repo.MoneyJarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoneyJarService {

    @Autowired
    private MoneyJarRepo moneyJarRepo;

    public List<MoneyJar> getAllMoneyJar() {
        List<MoneyJar> list = moneyJarRepo.findAll();
        return list;
    }

    public MoneyJar createMoneyJar(MoneyJar moneyJar) {
        moneyJar.setJar_balance(moneyJar.getJar_balance());
        return moneyJarRepo.save(moneyJar);
    }

    public MoneyJar updateMoneyJar(Long money_jar_id, MoneyJar updatedMoneyJar) {
        MoneyJar moneyJar = moneyJarRepo.findById(money_jar_id)
                .orElseThrow(() -> new ResourceNotFoundException("Money Jar not found"));
        moneyJar.setJar_name(updatedMoneyJar.getJar_name());
        moneyJar.setDescription(updatedMoneyJar.getDescription());
        return moneyJarRepo.save(moneyJar);
    }

    public void deleteMoneyJar(Long moneyJarId) {
        MoneyJar moneyJar = moneyJarRepo.findById(moneyJarId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));
        moneyJarRepo.delete(moneyJar);
    }

    public MoneyJar transferMoney(Long fromMoneyJarId, Long toMoneyJarId, Double amount) {
        MoneyJar fromMoney = moneyJarRepo.findById(fromMoneyJarId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));
        MoneyJar toMoney = moneyJarRepo.findById(toMoneyJarId)
                .orElseThrow(() -> new ResourceNotFoundException("Wallet not found"));

//        if (fromMoney.getJar_balance() < amount) {
//            throw new InsufficientFundsException("Not enough balance");
//        }

        fromMoney.setJar_balance(fromMoney.getJar_balance() - amount);
        toMoney.setJar_balance(toMoney.getJar_balance() + amount);

        moneyJarRepo.save(fromMoney);
        moneyJarRepo.save(toMoney);

        return toMoney;
    }

}
