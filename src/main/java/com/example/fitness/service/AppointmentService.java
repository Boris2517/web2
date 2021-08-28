package com.example.fitness.service;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;

public interface AppointmentService {
    Appointment createAppointment(AppointmentDTO appointmentDTO);
}
