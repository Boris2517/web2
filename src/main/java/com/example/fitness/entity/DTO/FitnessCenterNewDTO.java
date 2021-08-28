package com.example.fitness.entity.DTO;

public class FitnessCenterNewDTO {

    private String name;
    private String address;
    private String phone;
    private String email;

    private String newName;
    private String newAddress;
    private String newPhone;
    private String newEmail;

    public FitnessCenterNewDTO(String name, String address, String phone, String email, String newName, String newAddress, String newPhone, String newEmail) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.newName = newName;
        this.newAddress = newAddress;
        this.newPhone = newPhone;
        this.newEmail = newEmail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewAddress() {
        return newAddress;
    }

    public void setNewAddress(String newAddress) {
        this.newAddress = newAddress;
    }

    public String getNewPhone() {
        return newPhone;
    }

    public void setNewPhone(String newPhone) {
        this.newPhone = newPhone;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }
}
