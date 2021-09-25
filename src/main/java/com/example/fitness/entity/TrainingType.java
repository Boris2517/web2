package com.example.fitness.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TrainingType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
//    STRENGTH,
//    AEROBIC,
//    BALANCE_AND_STABILITY,
//    COORDINATION_AND_AGILITY,
//    FLEXIBILITY_AND_MOBILITY


    public TrainingType() {
    }

    public TrainingType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
