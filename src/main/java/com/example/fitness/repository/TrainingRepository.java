package com.example.fitness.repository;

import com.example.fitness.entity.Trainer;
import com.example.fitness.entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {
    Training findByName(String name);
    Training findByNameAndCreator(String name, Trainer trainer);
}
