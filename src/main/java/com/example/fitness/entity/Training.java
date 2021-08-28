package com.example.fitness.entity;

import javax.persistence.*;

@Entity
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @Column(name="name", unique=false, nullable=false)
    private String name;
    @Column(name="description", unique=false, nullable=false)
    private String description;
    @Column(name="type", unique=false, nullable=false)
    private String type;
    @Column(name="duration", unique=false, nullable=false)
    private Integer duration;
    @OneToOne
    private Trainer creator;


    public Training() {
    }

    public Training(Long id, String name, String description, String type, Integer duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "Training{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Trainer getCreator() {
        return creator;
    }

    public void setCreator(Trainer creator) {
        this.creator = creator;
    }
}
