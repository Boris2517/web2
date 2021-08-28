package com.example.fitness.entity.UserDetails;

import com.example.fitness.entity.Admin;
import com.example.fitness.entity.Role;
import com.example.fitness.entity.Trainer;
import com.example.fitness.repository.AdminRepository;
import com.example.fitness.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DemoData {


    private final TrainerRepository trainerRepository;
    private final AdminRepository adminRepository;

    @Autowired
    public DemoData(TrainerRepository trainerRepository, AdminRepository adminRepository) {
        this.trainerRepository = trainerRepository;
        this.adminRepository = adminRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event){
        Admin admin = new Admin("admin", "admin","Boris","Knezevic","0621914681","boris.knezevic@mail.ru");
        Trainer trainer1 = new Trainer("trainer1", "sifra1", "Boris","Knezevic","0621914681","boris.knezevic@mail.ru");
//        trainer1.setActive(true);
//        trainer1.setRole(Role.TRAINER);
        this.adminRepository.save(admin);
        this.trainerRepository.save(trainer1);

    }

}
