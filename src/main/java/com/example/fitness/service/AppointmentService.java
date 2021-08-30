package com.example.fitness.service;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
import com.example.fitness.entity.FitnessCenter;

import java.util.ArrayList;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO) throws Exception;
    ArrayList<Appointment> getAppointmentsByFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO);
}
