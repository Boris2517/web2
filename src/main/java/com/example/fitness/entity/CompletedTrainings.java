package com.example.fitness.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class CompletedTrainings {
    @Id
    private long id;

    @OneToOne
    Member member;

    @ManyToOne
    Appointment appointment;

    boolean rated;

    float rate;
}
