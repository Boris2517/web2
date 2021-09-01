package com.example.fitness.controller;

import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.DTO.UsernameAndRoleDTO;
import com.example.fitness.entity.DTO.UsernameDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.User;
import com.example.fitness.entity.UserDetails.MyUserDetails;
import com.example.fitness.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/user")
public class UserController {


    Logger logger = LoggerFactory.getLogger(UserController.class);

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

    @GetMapping(value ="/username", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsernameAndRoleDTO> getUsername(@AuthenticationPrincipal MyUserDetails userDetails){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //logger.info(authentication.getName()); //Log username
        UsernameAndRoleDTO usernameAndRoleDTO = new UsernameAndRoleDTO();
        usernameAndRoleDTO.setUsername(userDetails.getUsername());
        usernameAndRoleDTO.setRole(userDetails.getRole());
        System.out.println(userDetails.getUsername());
        return new ResponseEntity<>(usernameAndRoleDTO, HttpStatus.ACCEPTED);
    }



}
