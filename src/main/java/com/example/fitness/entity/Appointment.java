package com.example.fitness.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    Training trainings;
    @Column(name="training_day", unique=false, nullable=true)
    Day trainingDay;
    @Column(name="time", unique=false, nullable=true)
    LocalTime time;
    @Column(name="num_of_attendees", unique=false, nullable=true)
    int numberOfAttendees;
    @Column(name="date", unique=false, nullable=true)
    Date date;


    public Appointment() {
    }

    public Appointment(Long id, Training trainings, Day trainingDay, LocalTime time, int numberOfAttendees, Date date) {
        this.id = id;
        this.trainings = trainings;
        this.trainingDay = trainingDay;
        this.time = time;
        this.numberOfAttendees = numberOfAttendees;
        this.date = date;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", trainings=" + trainings +
                ", trainingDay=" + trainingDay +
                ", time=" + time +
                ", numberOfAttendees=" + numberOfAttendees +
                ", date=" + date +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Training getTrainings() {
        return trainings;
    }

    public void setTrainings(Training trainings) {
        this.trainings = trainings;
    }

    public Day getTrainingDay() {
        return trainingDay;
    }

    public void setTrainingDay(Day trainingDay) {
        this.trainingDay = trainingDay;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
