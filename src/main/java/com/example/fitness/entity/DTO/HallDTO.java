package com.example.fitness.entity.DTO;

public class HallDTO {


    private Integer capacity;
    private String mark;
    private String fitnessCenterName;

    public HallDTO(Integer capacity, String mark, String fitnessCenterName) {
        this.capacity = capacity;
        this.mark = mark;
        this.fitnessCenterName = fitnessCenterName;
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
}
