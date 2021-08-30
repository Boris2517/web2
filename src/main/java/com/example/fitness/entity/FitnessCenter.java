package com.example.fitness.entity;

import javax.persistence.*;
import java.util.*;

@Entity
public class FitnessCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phone;
    private String email;

    @OneToMany
    private Set<Trainer> trainers = new HashSet<>();

    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Hall> halls = new HashSet<>();

    //Raspored odrzavanja treninga zajedno sa cenama za svaki termin posebno
    @OneToMany(cascade = {CascadeType.ALL})
    private Set<Appointment> appointments = new HashSet<>();




    public FitnessCenter() {
    }

    public FitnessCenter(String name) {
        this.name = name;
    }

    public FitnessCenter(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public FitnessCenter(Long id, String name, String address, String phone, String email, Set<Trainer> trainers, Set<Hall> halls) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.trainers = trainers;
        this.halls = halls;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trainer> getTrainers() {
        return trainers;
    }

    public void setTrainers(Set<Trainer> trainers) {
        this.trainers = trainers;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void addTrainer(Trainer trainer){
        this.trainers.add(trainer);
    }

    public void addHall(Hall hall){
        this.halls.add(hall);
    }

    public void addAppointment(Appointment appointment){this.appointments.add(appointment);}


}
