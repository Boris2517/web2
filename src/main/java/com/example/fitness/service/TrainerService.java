package com.example.fitness.service;

import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.Trainer;

import java.util.List;

public interface TrainerService {
    Trainer approveTrainer(TrainerUsernameDTO trainerUsernameDTO);
    void deleteTrainer(TrainerUsernameDTO trainerUsernameDTO);
    Trainer addNewActiveTrainer(Trainer trainer) throws Exception;
    List<Trainer> getAllTrainers() throws Exception;
}
