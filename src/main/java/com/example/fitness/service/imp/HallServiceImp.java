package com.example.fitness.service.imp;

import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.FitnessCenterRepository;
import com.example.fitness.repository.HallRepository;
import com.example.fitness.repository.TrainerRepository;
import com.example.fitness.service.HallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class HallServiceImp implements HallService {

    private final HallRepository hallRepository;
    private final TrainerRepository trainerRepository;
    private final FitnessCenterRepository fitnessCenterRepository;

    @Autowired
    public HallServiceImp(HallRepository hallRepository, TrainerRepository trainerRepository, FitnessCenterRepository fitnessCenterRepository){
        this.hallRepository = hallRepository;
        this.trainerRepository = trainerRepository;

        this.fitnessCenterRepository = fitnessCenterRepository;
    }

    @Override
    public ArrayList<Hall> getHallByTrainer(String username) {
        Trainer trainer = this.trainerRepository.findByUsername(username);
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByTrainers(trainer);

        Set<Hall> halls = fitnessCenter.getHalls();
        List<Hall> mainList = new ArrayList<Hall>();
        mainList.addAll(halls);
        return (ArrayList<Hall>) mainList;
    }
}
