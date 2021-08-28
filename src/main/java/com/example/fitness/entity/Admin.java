package com.example.fitness.entity;

import javax.persistence.Entity;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin extends User{

    public Admin(){}

    public Admin(String username, String password, String name, String surname, String email, String phone){
        super(username, password, name, surname, phone, email);
        this.setActive(true);
        this.setRole(Role.ADMIN);
    }
}
