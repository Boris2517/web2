package com.example.fitness.entity;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.InheritanceType.TABLE_PER_CLASS;


@Entity
@Inheritance(strategy = TABLE_PER_CLASS)
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="username", unique=true, nullable=false)
    private String username;
    @Column(name="password", unique=false, nullable=false)
    private String password;
    @Column(name="name", unique=false, nullable=false)
    private String name;
    @Column(name="surname", unique=false, nullable=false)
    private String surname;
    @Column(name="phone", unique=false, nullable=false)
    private String phone;
    @Column(name="email", unique=true, nullable=false)
    private String email;
    @Column(name="birth_date", unique=false, nullable=true)
    private Date birthdate;
    @Column(name="role", unique=false, nullable=false)
    private Role role;
    @Column(name="active_status", unique=false, nullable=false)
    private Boolean active;

    public User() {
    }

    public User(String username, String password, String name, String surname, String phone, String email) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", role=" + role +
                ", active=" + active +
                '}';
    }
}
