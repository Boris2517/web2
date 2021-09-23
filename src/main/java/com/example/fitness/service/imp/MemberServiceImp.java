package com.example.fitness.service.imp;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentSignUpDTO;
import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.repository.AppointmentRepository;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
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
    public void signUpForAnAppointment(AppointmentSignUpDTO appointmentSignUpDTO, String username) throws Exception {

        Optional<Appointment> appointment = this.appointmentRepository.findById(appointmentSignUpDTO.getAppointmentId());
        Optional<Member> member = this.memberRepository.findByUsername(username);
        appointment.get().setParticipants(member.get());
        this.appointmentRepository.save(appointment.get());

    }

    @Override
    public Optional<Member> getMemberByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> member = this.memberRepository.findByUsername(username);
        member.orElseThrow(() -> new UsernameNotFoundException("User Not Found with that username"));
        return member;
    }

    @Override
    public Optional<Member> updateUserInfo(String username, UserDTO userDTO) {

        Optional<Member> member = this.memberRepository.findByUsername(username);

        member.get().setName(userDTO.getName());
        member.get().setSurname(userDTO.getSurname());
        member.get().setPhone(userDTO.getPhone());
        member.get().setEmail(userDTO.getEmail());
        member.get().setBirthdate(userDTO.getBirthdate());

        this.memberRepository.save(member.get());
        return member;
    }

    @Override
    public List<Appointment> getMemberAppointments(String username) {
        Optional<Member> member = this.memberRepository.findByUsername(username);
        List<Appointment> appointments = new ArrayList<>();

//        for (Appointment app: member.get().getFutureTrainings()) {
//            appointments.add(app);
//        }

        return appointments;
    }


}
