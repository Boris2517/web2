package com.example.fitness.service.imp;

import com.example.fitness.entity.Member;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {


    private final MemberRepository memberRepository;

    // constructor-based dependency injection
    @Autowired
    public UserServiceImp(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member create(Member user) throws Exception {

        /*
        *  if (employee.getId() != null) {
            throw new Exception("ID must be null!");
        }
        Employee newEmployee = this.employeeRepository.save(employee);
        return newEmployee;*/
        /*
        if (user.getId() != null) {
            throw new Exception("ID must be null!");
        }
        */

        Member newMember =  this.memberRepository.save(user);
        return newMember;
    }
}
