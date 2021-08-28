package com.example.fitness.entity.DTO;

import com.example.fitness.entity.Day;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import com.example.fitness.entity.Training;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.time.LocalTime;
import java.util.Date;

public class AppointmentDTO {

    String trainerUsername;

    String trainingName;

    Day trainingDay;

    LocalTime time;

    Date date;

    String hall;

    int numberOfAttendees;

    float price;


    public AppointmentDTO() {
    }

    public AppointmentDTO(String trainerUsername, String trainingName, Day trainingDay, LocalTime time, Date date, String hall, int numberOfAttendees, float price) {
        this.trainerUsername = trainerUsername;
        this.trainingName = trainingName;
        this.trainingDay = trainingDay;
        this.time = time;
        this.date = date;
        this.hall = hall;
        this.numberOfAttendees = numberOfAttendees;
        this.price = price;
    }

    public String getTrainerUsername() {
        return trainerUsername;
    }

    public void setTrainerUsername(String trainerUsername) {
        this.trainerUsername = trainerUsername;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHall() {
        return hall;
    }

    public void setHall(String hall) {
        this.hall = hall;
    }

    public int getNumberOfAttendees() {
        return numberOfAttendees;
    }

    public void setNumberOfAttendees(int numberOfAttendees) {
        this.numberOfAttendees = numberOfAttendees;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
