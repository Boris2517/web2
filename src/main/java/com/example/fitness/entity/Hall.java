package com.example.fitness.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Hall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="capacity", unique=false, nullable=false)
    private Integer capacity;
    private String mark;

    @ManyToMany
    Set<Appointment> trainingList = new HashSet<>();

    @OneToOne(cascade = CascadeType.PERSIST)
    FitnessCenter fitnessCenter;

    public Hall() {
    }

    public Hall(Integer capacity, String mark, FitnessCenter fitnessCenter) {
        this.capacity = capacity;
        this.mark = mark;
        this.fitnessCenter = fitnessCenter;
    }

    public Hall(Long id, Integer capacity, String mark, Set<Appointment> trainingList) {
        this.id = id;
        this.capacity = capacity;
        this.mark = mark;
        this.trainingList = trainingList;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", mark='" + mark + '\'' +
                ", trainingList=" + trainingList +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Set<Appointment> getTrainingList() {
        return trainingList;
    }

    public void setTrainingList(Set<Appointment> trainingList) {
        this.trainingList = trainingList;
    }
}
