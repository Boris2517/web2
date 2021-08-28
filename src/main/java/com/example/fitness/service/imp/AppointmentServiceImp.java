package com.example.fitness.service.imp;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.repository.AppointmentRepository;
import com.example.fitness.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImp implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentServiceImp(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) {
        return null;
    }
}
