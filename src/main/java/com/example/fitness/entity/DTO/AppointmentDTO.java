package com.example.fitness.entity.DTO;

import com.example.fitness.entity.*;
import java.util.Date;

public class AppointmentDTO {

    private Long id;

    private String trainerUsername;

    private String trainingName;

    private Day trainingDay;

    private int hour;

    private int min;

    private int day;

    private int month;

    private int year;

    private String hall;

    private int numberOfAttendees;

    private float price;

    private String fitnessCenter;

    private String trainingType;


    public AppointmentDTO() {
    }

    public AppointmentDTO(String trainerUsername, String trainingName, int hour, int min, String hall, int numberOfAttendees, float price, String fitnessCenter) {
        this.trainerUsername = trainerUsername;
        this.trainingName = trainingName;
        this.hour = hour;
        this.min = min;
        this.hall = hall;
        this.numberOfAttendees = numberOfAttendees;
        this.price = price;
        this.fitnessCenter = fitnessCenter;
    }

    public AppointmentDTO(Long id, String trainerUsername, String trainingName, Day trainingDay, int hour, int min, String hall, int numberOfAttendees, float price, String fitnessCenter) {
        this.id = id;
        this.trainerUsername = trainerUsername;
        this.trainingName = trainingName;
        this.trainingDay = trainingDay;
        this.hour = hour;
        this.min = min;
        this.hall = hall;
        this.numberOfAttendees = numberOfAttendees;
        this.price = price;
        this.fitnessCenter = fitnessCenter;
    }

    public void setDate(MyDate date){
        this.day = date.getDay();
        this.month = date.getMonth();
        this.year = date.getYear();
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

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFitnessCenter() {
        return fitnessCenter;
    }

    public void setFitnessCenter(String fitnessCenter) {
        this.fitnessCenter = fitnessCenter;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }


    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
