package com.example.fitness.controller;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;
import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.UserDetails.MyUserDetails;
import com.example.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/appointment")
    public void signUpForAnAppointment(@RequestBody AppointmentSignUpDTO appointmentSignUpDTO, @AuthenticationPrincipal MyUserDetails userDetails) throws Exception{

        this.memberService.signUpForAnAppointment(appointmentSignUpDTO,userDetails.getUsername());

    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> updateMemberInfo(@AuthenticationPrincipal MyUserDetails userDetails , @RequestBody UserDTO userDTO){
        Optional<Member> member = this.memberService.updateUserInfo(userDetails.getUsername(), userDTO);

        UserDTO userDTO1 = new UserDTO();

        userDTO1.setName(member.get().getName());
        userDTO1.setSurname(member.get().getSurname());
        userDTO1.setPassword(member.get().getPassword());
        userDTO1.setUsername(member.get().getUsername());
        userDTO1.setEmail(member.get().getEmail());
        userDTO1.setBirthdate(member.get().getBirthdate());
        userDTO1.setPhone(member.get().getPhone());

        return new ResponseEntity<>(userDTO1, HttpStatus.ACCEPTED);

    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/app")
    public ResponseEntity<List<Appointment>> getMemberAppointments(@AuthenticationPrincipal MyUserDetails userDetails){
        List<Appointment> appointments = this.memberService.getMemberAppointments(userDetails.getUsername());

        ArrayList<Appointment> appointments1 = new ArrayList<>();
        for (Appointment app: appointments) {
            appointments1.add(app);
        }


        return new ResponseEntity<>(appointments1, HttpStatus.ACCEPTED);
    }

//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Appointment> applyForAppointment(@AuthenticationPrincipal MyUserDetails userDetails,  @RequestBody AppointmentDTO appointmentDTO){
//        Appointment appointment = this.memberService.
//    }


}
