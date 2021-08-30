package com.example.fitness.controller;

import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.DTO.TrainingDTO;
import com.example.fitness.entity.DTO.TrainingNewDTO;
import com.example.fitness.entity.Training;
import com.example.fitness.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/training")
public class TrainingController {

    private final TrainingService trainingService;

    @Autowired
    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> addTraining(@RequestBody TrainingDTO trainingDTO) throws Exception{

        Training training = this.trainingService.addNewTraining(trainingDTO);
        TrainingDTO newTraining = new TrainingDTO();
        newTraining.setName(training.getName());
        newTraining.setDescription(training.getDescription());
        newTraining.setDuration(training.getDuration());
        newTraining.setType(training.getType());
        newTraining.setTrainerUsername(training.getCreator().getUsername());

        return new ResponseEntity<>(newTraining, HttpStatus.ACCEPTED);

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrainingDTO> updateTraining(@RequestBody TrainingNewDTO training) throws Exception {

        Training updatedTraining = this.trainingService.updateTraining(training);
        TrainingDTO trDTO = new TrainingDTO();
        trDTO.setType(updatedTraining.getType());
        trDTO.setDuration(updatedTraining.getDuration());
        trDTO.setDescription(updatedTraining.getDescription());
        trDTO.setName(updatedTraining.getName());
        trDTO.setTrainerUsername(updatedTraining.getCreator().getUsername());
        return new ResponseEntity<>(trDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE ,value = "/all")
    public ResponseEntity<ArrayList<TrainingDTO>> allTrainings(@RequestBody TrainerUsernameDTO trainerUsernameDTO){


        ArrayList<Training> allTrainings = this.trainingService.getAllTrainings(trainerUsernameDTO);
        ArrayList<TrainingDTO> allTrainingsDTO = new ArrayList<>();


        for (Training training : allTrainings) {
            TrainingDTO trainingDTO = new TrainingDTO();
            trainingDTO.setName(training.getName());
            trainingDTO.setDescription(training.getDescription());
            trainingDTO.setType(training.getType());
            trainingDTO.setDuration(training.getDuration());
            trainingDTO.setTrainerUsername(training.getCreator().getUsername());
            allTrainingsDTO.add(trainingDTO);
        }
        return new ResponseEntity<>(allTrainingsDTO, HttpStatus.ACCEPTED);
    }

}
