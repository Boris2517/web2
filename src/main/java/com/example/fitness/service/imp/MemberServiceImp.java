package com.example.fitness.service.imp;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.repository.AppointmentRepository;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImp implements MemberService {

    private final AppointmentRepository appointmentRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImp(AppointmentRepository appointmentRepository, MemberRepository memberRepository){
        this.appointmentRepository = appointmentRepository;
        this.memberRepository = memberRepository;
    }


    @Override
    public void signUpForAnAppointment(AppointmentSignUpDTO appointmentSignUpDTO) throws Exception {

        Optional<Appointment> appointment = this.appointmentRepository.findById(appointmentSignUpDTO.getAppointmentId());
        Member member = this.memberRepository.findByUsername(appointmentSignUpDTO.getMemberUsername());
        appointment.get().setParticipants(member);
        this.appointmentRepository.save(appointment.get());
    }
}
