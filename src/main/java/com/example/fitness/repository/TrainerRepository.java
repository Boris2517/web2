package com.example.fitness.repository;

import com.example.fitness.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  TrainerRepository extends JpaRepository<Trainer,Long> {
    //Optional<Trainer> findByUsername(String username);
    Trainer findByUsername(String username);
    Trainer findByEmail(String email);
}
