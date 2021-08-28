package com.example.fitness.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="trainers")
public class Trainer extends User{

    //Lista treninga koje on drzi
    @OneToMany
    @Column(nullable = true)
    private Set<Training> trainingList = new HashSet<>();


    //Prosecna ocena srednja ocena koja se izracunava svaki put kada neko oceni trening koji je on odrzao
    @Column(name="average_rating", unique=false, nullable=true)
    private float averageRating;

    public Trainer() {
    }

    public Trainer(String username, String password, String name, String surname, String phone, String email) {
        super(username, password, name, surname, phone, email);
        this.setRole(Role.TRAINER);
        this.setActive(true);
    }

    public Trainer(Set<Training> trainingList, float averageRating) {
        super();
        this.trainingList = trainingList;
        this.averageRating = averageRating;
    }

    public Set<Training> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(Set<Training> trainingList) {
        this.trainingList = trainingList;
    }

    public float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(float averageRating) {
        this.averageRating = averageRating;
    }
}
