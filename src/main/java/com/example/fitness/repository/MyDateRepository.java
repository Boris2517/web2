package com.example.fitness.repository;

import com.example.fitness.entity.MyDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDateRepository extends JpaRepository<MyDate, Long> {
}
