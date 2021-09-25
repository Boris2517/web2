package com.example.fitness.repository;

import com.example.fitness.entity.MyTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTimeRepository extends JpaRepository<MyTime, Long> {
}
