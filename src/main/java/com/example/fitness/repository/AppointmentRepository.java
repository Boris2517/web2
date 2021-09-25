package com.example.fitness.repository;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Trainer;
import com.example.fitness.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    ArrayList<Appointment> findByFitnessCenter(FitnessCenter fitnessCenter);
    ArrayList<Appointment> findByTraining(Training training);
    ArrayList<Appointment> findByTrainer(Trainer trainer);
}
