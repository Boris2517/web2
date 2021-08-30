package com.example.fitness.service;

import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;

public interface MemberService {
    void signUpForAnAppointment(AppointmentSignUpDTO appointmentSignUpDTO) throws Exception;
}
