package com.testdb.testDB.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "loan_amount")
public class LoanAmount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loan_amount_id")
    private long loan_amount_id;

    @Column(name = "loan_amount_name")
    private String loan_amount_name;

    @Column(name = "interest_rates")
    private double interest_rates;

    @Column(name = "date_from")
    private String date_from;

    @Column(name = "date_to")
    private String date_to;

    @Column(name = "loan_amount_type")
    private int loan_amount_type;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "loan_amount")
    private int loan_amount;

    @Column(name = "description")
    private String description;

    public String getLoan_amount_name() {
        return loan_amount_name;
    }

    public void setLoan_amount_name(String loan_amount_name) {
        this.loan_amount_name = loan_amount_name;
    }

    public double getInterest_rates() {
        return interest_rates;
    }

    public void setInterest_rates(double interest_rates) {
        this.interest_rates = interest_rates;
    }

    public String getDate_from() {
        return date_from;
    }

    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    public String getDate_to() {
        return date_to;
    }

    public void setDate_to(String date_to) {
        this.date_to = date_to;
    }

    public int getLoan_amount_type() {
        return loan_amount_type;
    }

    public void setLoan_amount_type(int loan_amount_type) {
        this.loan_amount_type = loan_amount_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getLoan_amount() {
        return loan_amount;
    }

    public void setLoan_amount(int loan_amount) {
        this.loan_amount = loan_amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
