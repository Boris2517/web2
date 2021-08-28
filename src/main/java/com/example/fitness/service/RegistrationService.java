package com.example.fitness.service;

import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.Trainer;

public interface RegistrationService {

    Member registerMember(UserDTO userDTO);
    Trainer registerTrainer(UserDTO userDTO);
}
