package com.example.fitness.entity;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    List<Member> participans;

    @OneToOne
    Training training;
    @Column(name="training_day", unique=false, nullable=true)
    Day trainingDay;
    @Column(name="time", unique=false, nullable=true)
    LocalTime time;
    @Column(name="num_of_attendees", unique=false, nullable=true)
    int numberOfAttendees;
    @Column(name="date", unique=false, nullable=true)
    Date date;
    //Fintes centar
    @OneToOne
    FitnessCenter fitnessCenter;

    @OneToOne
    Hall hall;

    //Cena
    float price;


    public Appointment() {
    }


    public Appointment(Long id, Training training, Day trainingDay, LocalTime time, int numberOfAttendees, Date date) {
        this.id = id;
        this.training = training;
        this.trainingDay = trainingDay;
        this.time = time;
        this.numberOfAttendees = numberOfAttendees;
        this.date = date;
    }

    public Appointment(Long id, List<Member> participans, Training training, Day trainingDay, LocalTime time, int numberOfAttendees, Date date, FitnessCenter fitnessCenter, Hall hall, float price) {
        this.id = id;
        this.participans = participans;
        this.training = training;
        this.trainingDay = trainingDay;
        this.time = time;
        this.numberOfAttendees = numberOfAttendees;
        this.date = date;
        this.fitnessCenter = fitnessCenter;
        this.hall = hall;
        this.price = price;
    }


    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", trainings=" + training +
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
        return training;
    }

    public void setTrainings(Training training) {
        this.training = training;
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

    public List<Member> getParticipans() {
        return participans;
    }

    public void setParticipans(List<Member> participans) {
        this.participans = participans;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public FitnessCenter getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(FitnessCenter fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
