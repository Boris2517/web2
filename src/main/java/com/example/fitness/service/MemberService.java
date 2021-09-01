package com.example.fitness.service;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;
import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberService {
    void signUpForAnAppointment(AppointmentSignUpDTO appointmentSignUpDTO, String username) throws Exception;
    Optional<Member> getMemberByUsername(String username);
    Optional<Member> updateUserInfo(String username, UserDTO userDTO);
    List<Appointment> getMemberAppointments(String username);
}
