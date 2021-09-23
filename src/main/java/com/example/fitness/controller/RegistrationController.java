package com.example.fitness.controller;

import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.Trainer;
import com.example.fitness.service.imp.RegistrationServiceImp;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;

@RestController
@RequestMapping(value = "/api/registration")
public class RegistrationController {

    private final RegistrationServiceImp registrationServiceImp;

    @Autowired
    public RegistrationController(RegistrationServiceImp registrationServiceImp){
        this.registrationServiceImp = registrationServiceImp;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/member")
    public ResponseEntity<UserDTO> registerMember(@RequestBody UserDTO userDTO){

        Member newUser = this.registrationServiceImp.registerMember(userDTO);
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setEmail(newUser.getEmail());
        newUserDTO.setName(newUser.getName());
        newUserDTO.setUsername(newUser.getUsername());
        newUserDTO.setSurname(newUser.getSurname());
        newUserDTO.setPhone(newUser.getPhone());
        newUserDTO.setRole(newUser.getRole());

        return new ResponseEntity<>(newUserDTO, HttpStatus.ACCEPTED);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/trainer")
    public ResponseEntity<UserDTO> registerTrainer(@RequestBody UserDTO userDTO){

        System.out.println("Trainer Reg Controller");
        System.out.println(userDTO.getUsername());

        Trainer newTrainer = this.registrationServiceImp.registerTrainer(userDTO);
        UserDTO newUserDTO = new UserDTO();
        newUserDTO.setEmail(newTrainer.getEmail());
        newUserDTO.setName(newTrainer.getName());
        newUserDTO.setUsername(newTrainer.getUsername());
        newUserDTO.setSurname(newTrainer.getSurname());
        newUserDTO.setPhone(newTrainer.getPhone());
        newUserDTO.setRole(newTrainer.getRole());

        return new ResponseEntity<>(newUserDTO, HttpStatus.ACCEPTED);
    }

}
