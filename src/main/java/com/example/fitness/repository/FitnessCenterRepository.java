package com.example.fitness.repository;

import com.example.fitness.entity.FitnessCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface FitnessCenterRepository extends JpaRepository<FitnessCenter, Long> {

    //@Transactional
    FitnessCenter findByName(String fitnessCenterName);
}