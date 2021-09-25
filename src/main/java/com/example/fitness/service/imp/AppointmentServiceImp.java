package com.example.fitness.service.imp;

import com.example.fitness.entity.*;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
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
    private final MyTimeRepository myTimeRepository;
    private final MyDateRepository myDateRepository;
    private final TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public AppointmentServiceImp(AppointmentRepository appointmentRepository, TrainerRepository trainerRepository, FitnessCenterRepository fitnessCenterRepository, HallRepository hallRepository, TrainingRepository trainingRepository, MyTimeRepository myTimeRepository, MyDateRepository myDateRepository, TrainingTypeRepository trainingTypeRepository){
        this.appointmentRepository = appointmentRepository;
        this.trainerRepository = trainerRepository;
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.hallRepository = hallRepository;
        this.trainingRepository = trainingRepository;
        this.myTimeRepository = myTimeRepository;
        this.myDateRepository = myDateRepository;
        this.trainingTypeRepository = trainingTypeRepository;
    }


    @Override
    public Appointment createAppointment(AppointmentDTO appointmentDTO, String username) throws Exception {
        System.out.println("Appointment service begin");
        Appointment appointment = new Appointment();
        Trainer trainer = this.trainerRepository.findByUsername(username);
        TrainingType trainingType = this.trainingTypeRepository.findByName(appointmentDTO.getTrainingType());
        //Trainer trainer = this.trainerRepository.findByUsername(appointmentDTO.getTrainerUsername());
        if(trainer == null) throw new Exception("Trainer is null in service");
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByTrainers(trainer);
        if(fitnessCenter == null) throw new Exception("FitnessCenter is null in service");

        MyTime time = new MyTime(appointmentDTO.getHour(), appointmentDTO.getMin());
        this.myTimeRepository.save(time);
        System.out.println("Saved time!");
        appointment.setTime(time);
        MyDate date = new MyDate();
        date.setDay(appointmentDTO.getDay());
        date.setMonth(appointmentDTO.getMonth());
        date.setYear(appointmentDTO.getYear());
        this.myDateRepository.save(date);
        appointment.setDate(date);
        Hall hall = this.hallRepository.findByMarkAndFitnessCenter(appointmentDTO.getHall(),fitnessCenter);
        if(hall == null) throw new Exception("Hall is null in service");



        appointment.setHall(hall);
        appointment.setPrice(appointmentDTO.getPrice());
        appointment.setNumberOfAttendees(appointmentDTO.getNumberOfAttendees());
        appointment.setFitnessCenter(fitnessCenter);
        Training training = new Training();
        training.setCreator(trainer);
        training.setType(trainingType);
        training.setName(appointmentDTO.getTrainingName());
        appointment.setTraining(this.trainingRepository.findByName(appointmentDTO.getTrainingName()));
        appointment.setTrainer(trainer);
        System.out.println("Appointment service end");
        Appointment newAppointment = this.appointmentRepository.save(appointment);
        if(newAppointment ==  null) throw new Exception("New appointment is NULL");
        return newAppointment;
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

    @Override
    public ArrayList<Appointment> getTrainerAppointments(String username) throws Exception  {
        Trainer trainer = this.trainerRepository.findByUsername(username);
        if(trainer == null) throw new Exception("Trainer is NULL");
        ArrayList<Appointment> appointments = this.appointmentRepository.findByTrainer(trainer);
        return appointments;
    }
}
