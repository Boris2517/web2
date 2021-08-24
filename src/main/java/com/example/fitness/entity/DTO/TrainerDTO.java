package com.example.fitness.entity.DTO;

import com.example.fitness.entity.Role;

import javax.persistence.Column;
import java.util.Date;

public class TrainerDTO {

    private String username;

    private String password;

    private String name;

    private String surname;

    private String phone;

    private String email;

    private Date birthdate;

    private Role role;

    private Boolean active;

    public TrainerDTO() {
    }

    public TrainerDTO(String username, String password) {
        this.username = username;
        this.password = password;
        this.role = Role.TRAINER;
    }

    public TrainerDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = Role.TRAINER;
    }

    public TrainerDTO(String username, String password, String name, String surname, String phone, String email, Date birthdate) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
        this.role = Role.TRAINER;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
