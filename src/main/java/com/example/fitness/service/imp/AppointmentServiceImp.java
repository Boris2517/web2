package com.example.fitness.service.imp;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.*;
import com.example.fitness.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImp implements AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final TrainerRepository trainerRepository;
    private final FitnessCenterRepository fitnessCenterRepository;
    private final HallRepository hallRepository;
    private final TrainingRepository trainingRepository;

    @Autowired
    public AppointmentServiceImp(AppointmentRepository appointmentRepository, TrainerRepository trainerRepository, FitnessCenterRepository fitnessCenterRepository, HallRepository hallRepository, TrainingRepository trainingRepository){
        this.appointmentRepository = appointmentRepository;
        this.trainerRepository = trainerRepository;
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.hallRepository = hallRepository;
        this.trainingRepository = trainingRepository;
    }


    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO) throws Exception {
        Appointment appointment = new Appointment();
        Trainer trainer = this.trainerRepository.findByUsername(appointmentDTO.getTrainerUsername());
        if(trainer == null) throw new Exception("Trainer is null in service");
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByTrainers(trainer);
        if(fitnessCenter == null) throw new Exception("FitnessCenter is null in service");
        //appointment.setDate(appointmentDTO.getDate());
        //appointment.setTime(appointmentDTO.getTime());
        appointment.setHall(this.hallRepository.findByMarkAndFitnessCenter(appointmentDTO.getHall(),fitnessCenter));
        appointment.setPrice(appointmentDTO.getPrice());
        appointment.setNumberOfAttendees(appointmentDTO.getNumberOfAttendees());
        appointment.setFitnessCenter(fitnessCenter);
        appointment.setTraining(this.trainingRepository.findByName(appointmentDTO.getTrainingName()));


        return this.appointmentRepository.save(appointment);
    }

    @Override
    public ArrayList<Appointment> getAppointmentsByFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO) {
        FitnessCenter fitnessCenter =  this.fitnessCenterRepository.findByName(fitnessCenterNameDTO.getName());
        ArrayList<Appointment> appointments = this.appointmentRepository.findByFitnessCenter(fitnessCenter);
        return appointments;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointments = this.appointmentRepository.findAll();

        return appointments;
    }

    @Override
    public List<Appointment> getMemberAppointments(String username) {
        //List<Appointment> appointments = this.appointmentRepository.
        return null;
    }
}
