package com.testdb.testDB.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "money_jar")
public class MoneyJar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "money_jar_id")
    private int money_jar_id;

    @Column(name = "jar_name")
    private String jar_name;

    @Column(name = "amount_max")
    private int amount_max;

    @Column(name = "jar_balance")
    private double jar_balance;

    @Column(name = "category_id")
    private int category_id;

    @Column (name = "user_id")
    private int user_id;

    @Column (name = "description")
    private String description;

    public int getMoney_jar_id() {
        return money_jar_id;
    }

    public void setMoney_jar_id(int money_jar_id) {
        this.money_jar_id = money_jar_id;
    }

    public String getJar_name() {
        return jar_name;
    }

    public void setJar_name(String jar_name) {
        this.jar_name = jar_name;
    }

    public int getAmount_max() {
        return amount_max;
    }

    public void setAmount_max(int amount_max) {
        this.amount_max = amount_max;
    }

    public double getJar_balance() {
        return jar_balance;
    }

    public void setJar_balance(double jar_balance) {
        this.jar_balance = jar_balance;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
