package com.example.fitness.controller;

import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;
import com.example.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
@RequestMapping(value="/api/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/appointment")
    public void signUpForAnAppointment(@RequestBody AppointmentSignUpDTO appointmentSignUpDTO) throws Exception{

        this.memberService.signUpForAnAppointment(appointmentSignUpDTO);

    }




}
