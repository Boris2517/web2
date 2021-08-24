package com.example.fitness.repository;

import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    //FitnessCenter findByName(String fitnessCenterName);

    Hall findByMarkAndFitnessCenter(String mark, FitnessCenter fitnessCenter);
    //void deleteByFitnessCenterAndMark(FitnessCenter ft, String mark);
    //void deleteByFitnessCenterAndMark(FitnessCenter ft, String mark);

}
