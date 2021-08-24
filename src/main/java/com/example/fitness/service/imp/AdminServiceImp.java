package com.example.fitness.service.imp;

import com.example.fitness.entity.DTO.HallDTO;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import com.example.fitness.repository.AdminRepository;
import com.example.fitness.repository.FitnessCenterRepository;
import com.example.fitness.repository.HallRepository;
import com.example.fitness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp implements AdminService {

    private final FitnessCenterRepository fitnessCenterRepository;
    private final HallRepository hallRepository;

    @Autowired
    public AdminServiceImp(FitnessCenterRepository fitnessCenterRepository, HallRepository hallRepository){
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.hallRepository = hallRepository;
    }


    @Override
    public FitnessCenter addFitnessCenter(FitnessCenter fitnessCenter) throws Exception {

       FitnessCenter fitCenter = this.fitnessCenterRepository.save(fitnessCenter);

       return fitCenter;
    }


}
