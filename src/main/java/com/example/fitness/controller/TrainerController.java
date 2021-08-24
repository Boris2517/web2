package com.example.fitness.controller;

import com.example.fitness.entity.DTO.TrainerDTO;
import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.Trainer;
import com.example.fitness.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin/trainers")
public class TrainerController {

    private final TrainerService trainerService;


    @Autowired
    public TrainerController(TrainerService trainerService){
        this.trainerService = trainerService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> addNewActiveTrainer(@RequestBody TrainerDTO trainerDTO) throws Exception {
        Trainer trainer = new Trainer(trainerDTO.getUsername(), trainerDTO.getPassword(), trainerDTO.getName(),trainerDTO.getSurname(),trainerDTO.getPhone(), trainerDTO.getEmail() );
        Trainer newTrainer = this.trainerService.addNewActiveTrainer(trainer);
        return new ResponseEntity<>(newTrainer, HttpStatus.CREATED);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Trainer> approveTrainer(@RequestBody TrainerUsernameDTO trainerUsernameDTO) throws Exception{

        Trainer trainer = this.trainerService.approveTrainer(trainerUsernameDTO);
        return new ResponseEntity<>(trainer, HttpStatus.ACCEPTED);
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteTrainer(@RequestBody TrainerUsernameDTO trainerUsernameDTO) throws Exception {
        this.trainerService.deleteTrainer(trainerUsernameDTO);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Trainer>> getAllTrainers() throws Exception {
        List<Trainer> trainers = this.trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.ACCEPTED);
    }

}
