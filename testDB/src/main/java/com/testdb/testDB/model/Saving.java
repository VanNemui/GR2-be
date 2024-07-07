package com.testdb.testDB.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "savings")
public class Saving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saving_id")
    private long saving_id;

    @Column(name = "saving_type")
    private int saving_type;

    @Column(name = "saving_code")
    private String saving_code;

    @Column(name = "date_from")
    private String date_from;

    @Column(name = "date_to")
    private String date_to;

    @Column(name = "amount")
    private int amount;

    @Column(name = "interest_rates")
    private double interest_rates;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "description")
    private String description;
}
