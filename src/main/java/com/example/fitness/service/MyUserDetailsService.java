package com.example.fitness.service;

import com.example.fitness.entity.Admin;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.Role;
import com.example.fitness.entity.Trainer;
import com.example.fitness.entity.UserDetails.MyUserDetails;
import com.example.fitness.repository.AdminRepository;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    private  AdminRepository adminRepository;
    @Autowired
    private  TrainerRepository trainerRepository;
    @Autowired
    private  MemberRepository memberRepository;






    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Member> member = this.memberRepository.findByUsername(username);
        if(member.isEmpty()) {
            Trainer trainer = this.trainerRepository.findByUsername(username);
            if(trainer == null){
                Optional<Admin> admin = this.adminRepository.findByUsername(username);

                return admin.map(MyUserDetails::new).get();
            }
            return new MyUserDetails(trainer);
        }
//        if(member == null) {
//            System.out.println("member is null");
//            Trainer trainer = this.trainerRepository.findByUsername(username);
//            if(trainer == null) throw new UsernameNotFoundException("Cound not find user!");
//
//
//            return new MyUserDetails(trainer);
//
//        }



        return member.map(MyUserDetails::new).get();
    }



}
