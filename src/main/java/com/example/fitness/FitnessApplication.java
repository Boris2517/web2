package com.example.fitness;

import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.AdminRepository;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {AdminRepository.class, TrainerRepository.class, MemberRepository.class})
public class FitnessApplication {




	public static void main(String[] args) {


		SpringApplication.run(FitnessApplication.class, args);


	}

}
