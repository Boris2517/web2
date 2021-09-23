package com.example.fitness.service.imp;

import com.example.fitness.entity.DTO.UserDTO;
import com.example.fitness.entity.Member;
import com.example.fitness.entity.Role;
import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.MemberRepository;
import com.example.fitness.repository.TrainerRepository;
import com.example.fitness.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImp implements RegistrationService {

  private final MemberRepository memberRepository;
  private final TrainerRepository trainerRepository;

  @Autowired
  public RegistrationServiceImp(MemberRepository memberRepository, TrainerRepository trainerRepository){
    this.memberRepository = memberRepository;
    this.trainerRepository = trainerRepository;
  }


    @Override
    public Member registerMember(UserDTO userDTO) {

      Member newMember = new Member();
      newMember.setName(userDTO.getName());
      newMember.setSurname(userDTO.getSurname());
      newMember.setUsername(userDTO.getUsername());
      newMember.setPassword(userDTO.getPassword());
      newMember.setEmail(userDTO.getEmail());
      newMember.setBirthdate(userDTO.getBirthdate());
      newMember.setPhone(userDTO.getPhone());
      newMember.setActive(true);
      newMember.setRole(Role.MEMBER);



      return this.memberRepository.save(newMember);
    }

  @Override
  public Trainer registerTrainer(UserDTO userDTO) {

    System.out.println("Trainer Reg Service");
    System.out.println(userDTO.getUsername());

    Trainer newTrainer = new Trainer();
    newTrainer.setName(userDTO.getName());
    newTrainer.setSurname(userDTO.getSurname());
    newTrainer.setUsername(userDTO.getUsername());
    newTrainer.setPassword(userDTO.getPassword());
    newTrainer.setPhone(userDTO.getPhone());
    newTrainer.setEmail(userDTO.getEmail());
    newTrainer.setBirthdate(userDTO.getBirthdate());
    newTrainer.setRole(Role.TRAINER);
    newTrainer.setActive(false);
    return this.trainerRepository.save(newTrainer);
  }
}
