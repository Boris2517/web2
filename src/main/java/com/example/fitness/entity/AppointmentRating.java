package com.example.fitness.entity;

import javax.persistence.*;

@Entity
public class AppointmentRating {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Appointment appointment;
    float rating;

    public AppointmentRating() {
    }

    public AppointmentRating(Long id, Appointment appointment, float rating) {
        this.id = id;
        this.appointment = appointment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "AppointmentRating{" +
                "id=" + id +
                ", appointment=" + appointment +
                ", rating=" + rating +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
