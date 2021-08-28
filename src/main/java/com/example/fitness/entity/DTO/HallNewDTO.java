package com.example.fitness.entity.DTO;

public class HallNewDTO {

    private Integer capacity;
    private String mark;
    private String fitnessCenterName;

    private Integer newCapacity;
    private String newMark;


    public HallNewDTO(Integer capacity, String mark, String fitnessCenterName, Integer newCapacity, String newMark) {
        this.capacity = capacity;
        this.mark = mark;
        this.fitnessCenterName = fitnessCenterName;
        this.newCapacity = newCapacity;
        this.newMark = newMark;
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

    public String getFitnessCenterName() {
        return fitnessCenterName;
    }

    public void setFitnessCenterName(String fitnessCenterName) {
        this.fitnessCenterName = fitnessCenterName;
    }

    public Integer getNewCapacity() {
        return newCapacity;
    }

    public void setNewCapacity(Integer newCapacity) {
        this.newCapacity = newCapacity;
    }

    public String getNewMark() {
        return newMark;
    }

    public void setNewMark(String newMark) {
        this.newMark = newMark;
    }
}
