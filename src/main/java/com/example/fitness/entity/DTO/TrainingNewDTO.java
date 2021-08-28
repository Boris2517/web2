package com.example.fitness.entity.DTO;

public class TrainingNewDTO {

    private String name;
    private String description;
    private String type;
    private Integer duration;
    private String trainerUsername;

    private String newName;
    private String newDescription;
    private String newType;
    private Integer newDuration;

    public TrainingNewDTO() {
    }

    public TrainingNewDTO(String name, String description, String type, Integer duration, String trainerUsername, String newName, String newDescription, String newType, Integer newDuration) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
        this.trainerUsername = trainerUsername;
        this.newName = newName;
        this.newDescription = newDescription;
        this.newType = newType;
        this.newDuration = newDuration;
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

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public String getNewType() {
        return newType;
    }

    public void setNewType(String newType) {
        this.newType = newType;
    }

    public Integer getNewDuration() {
        return newDuration;
    }

    public void setNewDuration(Integer newDuration) {
        this.newDuration = newDuration;
    }
}
