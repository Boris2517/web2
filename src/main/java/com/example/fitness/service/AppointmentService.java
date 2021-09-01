package com.example.fitness.service;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;

import java.util.ArrayList;
import java.util.List;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO) throws Exception;
    ArrayList<Appointment> getAppointmentsByFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO);
    List<Appointment> getAllAppointments();
    List<Appointment> getMemberAppointments(String username);
}
