package com.example.fitness.entity.DTO;

public class AppointmentSignUpDTO {

    private Long appointmentId;
    private String memberUsername;


    public AppointmentSignUpDTO() {
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }
}
