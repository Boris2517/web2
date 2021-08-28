package com.example.fitness.entity.DTO;

import javax.persistence.Column;

public class TrainingDTO {

    private String name;
    private String description;
    private String type;
    private Integer duration;
    private String trainerUsername;


    public TrainingDTO() {
    }

    public TrainingDTO(String name, String description, String type, Integer duration, String trainerUsername) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.trainerUsername = trainerUsername;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getTrainerUsername() {
        return trainerUsername;
    }

    public void setTrainerUsername(String trainerUsername) {
        this.trainerUsername = trainerUsername;
    }
}
