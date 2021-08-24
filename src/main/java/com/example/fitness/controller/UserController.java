package com.example.fitness.controller;

import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Registracija novog clana
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> createEmployee(@RequestBody UserDTO userDTO) throws Exception {
        // Kreiramo objekat klase Employee, tako što za vrednosti atributa uzimamo
        // vrednosti iz primljenog DTO objekta
        Member user = new Member(userDTO.getUsername(), userDTO.getPassword(),userDTO.getName(),userDTO.getSurname(),userDTO.getPhone(),userDTO.getEmail());
        user.setId(10l);
        // Pozivanjem metode servisa kreiramo novog zaposlenog
        Member newMember = userService.create(user);

        // Mapiramo novog zaposlenog na DTO objekat koji vraćamo kroz body odgovora
        UserDTO newUserDTO = new UserDTO(newMember.getId(), userDTO.getUsername(), userDTO.getPassword(),userDTO.getName(),userDTO.getSurname(),userDTO.getPhone(),userDTO.getEmail());

        // Vraćamo odgovor 201 CREATED, a kroz body odgovora šaljemo podatke o novokreiranom
        // zaposlenom, uključujući i ID koji mu je dodeljen
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }




}
