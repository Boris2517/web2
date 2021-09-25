package com.example.fitness.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    private List<Member> participants;

    @OneToOne(cascade = CascadeType.ALL)
    private Training training;
    @Column(name="training_day", unique=false, nullable=true)
    private Day trainingDay;
    @OneToOne
    private MyTime time;
    @Column(name="num_of_attendees", unique=false, nullable=true)
    private int numberOfAttendees;
    @OneToOne
    private MyDate date;

    @ManyToOne(cascade = {CascadeType.ALL})
    private FitnessCenter fitnessCenter;

    @OneToOne
    private Hall hall;

    @OneToOne
    private Trainer trainer;

    //Cena
    private float price;


    public Appointment() {
    }

    public Appointment(Long id, Training training, Day trainingDay, MyTime time, int numberOfAttendees, MyDate date) {
        this.id = id;
        this.training = training;
        this.trainingDay = trainingDay;
        this.time = time;
        this.numberOfAttendees = numberOfAttendees;
        this.date = date;
    }

    public Appointment(Long id, List<Member> participants, Training training, Day trainingDay, MyTime time, int numberOfAttendees, MyDate date, FitnessCenter fitnessCenter, Hall hall, float price) {
        this.id = id;
        this.participants = participants;
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

    public MyTime getTime() {
        return time;
    }

    public void setTime(MyTime time) {
        this.time = time;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public List<Member> getParticipants() {
        return participants;
    }

    public void setParticipants(Member member) {
        this.participants.add(member);
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


    public Trainer getTrainer() {
        return trainer;
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }
}
