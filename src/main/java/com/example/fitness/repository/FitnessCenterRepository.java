package com.example.fitness.repository;

import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FitnessCenterRepository extends JpaRepository<FitnessCenter, Long> {


    FitnessCenter findByName(String fitnessCenterName);
    FitnessCenter findByTrainers(Trainer trainer);
}
