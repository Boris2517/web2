package com.example.fitness.service;

import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.DTO.TrainingDTO;
import com.example.fitness.entity.DTO.TrainingNewDTO;
import com.example.fitness.entity.Training;

import java.util.ArrayList;


public interface TrainingService {

    Training addNewTraining(TrainingDTO trainingDTO) throws Exception;
    Training updateTraining(TrainingNewDTO trainingNewDTO) throws Exception;
    ArrayList<Training> getAllTrainings(TrainerUsernameDTO trainerUsernameDTO);

}
