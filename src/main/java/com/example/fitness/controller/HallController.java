package com.example.fitness.controller;

import com.example.fitness.entity.DTO.HallDTO;
import com.example.fitness.entity.Hall;
import com.example.fitness.entity.UserDetails.MyUserDetails;
import com.example.fitness.service.HallService;
import com.example.fitness.service.imp.HallServiceImp;
import org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value = "/api/hall")
public class HallController {

    private final HallService hallService;

    @Autowired
    public HallController(HallService hallService){
        this.hallService = hallService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/trainer")
    public ResponseEntity<ArrayList<HallDTO>> getHallByTrainer(@AuthenticationPrincipal MyUserDetails myUserDetails){

        ArrayList<Hall> halls = this.hallService.getHallByTrainer(myUserDetails.getUsername());
        ArrayList<HallDTO> hallDTOS = new ArrayList<>();

        for (Hall hall: halls) {
            HallDTO hallDTO = new HallDTO();
            hallDTO.setCapacity(hall.getCapacity());
            hallDTO.setMark(hall.getMark());
            hallDTOS.add(hallDTO);
        }

        return new ResponseEntity<>(hallDTOS, HttpStatus.ACCEPTED);

    }

}
