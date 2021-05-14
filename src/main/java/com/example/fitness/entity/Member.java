package com.example.fitness.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="members")
public class Member extends User{

    //Lista odradjenih treninga
    @ManyToMany
    @JoinTable(name = "ODRADJENI",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    Set<Appointment> completedTrainings = new HashSet<>();


    //Lista treninga za koje su se prijavili ali ih nisu odradili
    @ManyToMany
    @JoinTable(name = "NEODRADJENI",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointment_id", referencedColumnName = "id"))
    Set<Appointment> futureTrainings = new HashSet<>();

    //Lista ocena za odredjene treninge
    @ManyToMany
    @JoinTable(name = "OCENE",
            joinColumns = @JoinColumn(name = "member_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "appointmentRating_id", referencedColumnName = "id"))
    Set<AppointmentRating> appointmentRatings= new HashSet<>();

    public Member(String username, String password, String name, String surname, String phone, String email) {
        super(username, password, name, surname, phone, email);
    }

    public Member() {
        super();
    }

    public Member(Set<Appointment> completedTrainings, Set<Appointment> futureTrainings, Set<AppointmentRating> appointmentRatings) {
        this.completedTrainings = completedTrainings;
        this.futureTrainings = futureTrainings;
        this.appointmentRatings = appointmentRatings;
    }

    public Set<Appointment> getCompletedTrainings() {
        return completedTrainings;
    }

    public void setCompletedTrainings(Set<Appointment> completedTrainings) {
        this.completedTrainings = completedTrainings;
    }

    public Set<Appointment> getFutureTrainings() {
        return futureTrainings;
    }

    public void setFutureTrainings(Set<Appointment> futureTrainings) {
        this.futureTrainings = futureTrainings;
    }

    public Set<AppointmentRating> getAppointmentRatings() {
        return appointmentRatings;
    }

    public void setAppointmentRatings(Set<AppointmentRating> appointmentRatings) {
        this.appointmentRatings = appointmentRatings;
    }
}
