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

    @ManyToMany(cascade = CascadeType.MERGE)
    private Set<Appointment> appointmentList = new HashSet<>();

    @OneToOne
    private FitnessCenter fitnessCenter;

    public Hall() {
    }

    public Hall(Integer capacity, String mark, FitnessCenter fitnessCenter) {
        this.capacity = capacity;
        this.mark = mark;
        this.fitnessCenter = fitnessCenter;
    }

    public Hall(Integer capacity, String mark, Set<Appointment> appointmentList, FitnessCenter fitnessCenter) {
        this.capacity = capacity;
        this.mark = mark;
        this.appointmentList = appointmentList;
        this.fitnessCenter = fitnessCenter;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", mark='" + mark + '\'' +
                ", trainingList=" + appointmentList +
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

    public Set<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public void setAppointmentList(Set<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }
}
