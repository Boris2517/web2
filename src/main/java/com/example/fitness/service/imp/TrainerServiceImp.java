package com.example.fitness.service.imp;

import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.Role;
import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.TrainerRepository;
import com.example.fitness.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerServiceImp implements TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerServiceImp(TrainerRepository trainerRepository){
        this.trainerRepository = trainerRepository;
    }

    @Override
    public Trainer approveTrainer(TrainerUsernameDTO trainerUsernameDTO) {
        Trainer trainer = this.trainerRepository.findByUsername(trainerUsernameDTO.getUsername());
        if(trainer.getActive() != true) trainer.setActive(true);
        return this.trainerRepository.save(trainer);

    }

    @Override
    public void deleteTrainer(TrainerUsernameDTO trainerUsernameDTO) {
        Trainer trainer = this.trainerRepository.findByUsername(trainerUsernameDTO.getUsername());
        this.trainerRepository.deleteById(trainer.getId());
    }

    @Override
    public Trainer addNewActiveTrainer(Trainer trainer) throws Exception {

        Trainer trainerByUsername = this.trainerRepository.findByUsername(trainer.getUsername());
        Trainer trainerByEmail = this.trainerRepository.findByEmail(trainer.getEmail());
        //1.provera da li postoji username provera da li postoji email
        if(trainerByUsername != null || trainerByEmail != null) throw new Exception("Username or email already exist in database");
        trainer.setActive(true);
        trainer.setRole(Role.ADMIN);

        Trainer newTrainer = this.trainerRepository.save(trainer);
        return newTrainer;
    }

    @Override
    public List<Trainer> getAllTrainers() throws Exception {
        List<Trainer> trainers = this.trainerRepository.findAll();
        return trainers;
    }
}
