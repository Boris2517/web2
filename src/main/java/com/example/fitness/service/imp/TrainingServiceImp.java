package com.example.fitness.service.imp;

import com.example.fitness.entity.DTO.TrainerUsernameDTO;
import com.example.fitness.entity.DTO.TrainingDTO;
import com.example.fitness.entity.DTO.TrainingNewDTO;
import com.example.fitness.entity.Trainer;
import com.example.fitness.entity.Training;
import com.example.fitness.entity.TrainingType;
import com.example.fitness.repository.TrainerRepository;
import com.example.fitness.repository.TrainingRepository;
import com.example.fitness.repository.TrainingTypeRepository;
import com.example.fitness.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TrainingServiceImp implements TrainingService {

    private final TrainerRepository trainerRepository;
    private final TrainingRepository trainingRepository;
    private final TrainingTypeRepository trainingTypeRepository;

    @Autowired
    public TrainingServiceImp(TrainingRepository trainingRepository, TrainerRepository trainerRepository, TrainingTypeRepository trainingTypeRepository){
        this.trainingRepository = trainingRepository;
        this.trainerRepository = trainerRepository;
        this.trainingTypeRepository = trainingTypeRepository;
    }


    @Override
    public Training addNewTraining(TrainingDTO trainingDTO) throws Exception{

        Trainer trainer = this.trainerRepository.findByUsername(trainingDTO.getTrainerUsername());
        Training exist = this.trainingRepository.findByName(trainingDTO.getName());
        if(exist != null) throw new Exception("Traning name already exist!");
        Training newTraining = new Training();
        newTraining.setCreator(trainer);
        newTraining.setDescription(trainingDTO.getDescription());
        newTraining.setDuration(trainingDTO.getDuration());
        newTraining.setName(trainingDTO.getName());
        newTraining.setType(trainingDTO.getType());

        return this.trainingRepository.save(newTraining);
    }

    @Override
    public Training updateTraining(TrainingNewDTO trainingNewDTO) throws Exception {
        Trainer trainer = this.trainerRepository.findByUsername(trainingNewDTO.getTrainerUsername());
        Training training = this.trainingRepository.findByNameAndCreator(trainingNewDTO.getName(),trainer);
        //training.setType(trainingNewDTO.getType());
        training.setName(trainingNewDTO.getNewName());
        training.setDuration(trainingNewDTO.getDuration());
        training.setDescription(trainingNewDTO.getNewDescription());
        return this.trainingRepository.save(training);
    }

    @Override
    public ArrayList<Training> getAllTrainings(TrainerUsernameDTO trainerUsernameDTO) {
        Trainer trainer  = this.trainerRepository.findByUsername(trainerUsernameDTO.getUsername());
        return this.trainingRepository.findByCreator(trainer);
    }

    @Override
    public ArrayList<TrainingType> getAllTrainingTypes() {
        ArrayList<TrainingType> trainingTypes = (ArrayList<TrainingType>) this.trainingTypeRepository.findAll();
        return trainingTypes;
    }
}
