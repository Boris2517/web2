package com.example.fitness.service.imp;


import com.example.fitness.entity.DTO.*;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import com.example.fitness.repository.FitnessCenterRepository;
import com.example.fitness.repository.HallRepository;
import com.example.fitness.service.FitnessCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FitnessCenterImp implements FitnessCenterService {

    private final FitnessCenterRepository fitnessCenterRepository;
    private final HallRepository hallRepository;

    @Autowired
    public FitnessCenterImp(FitnessCenterRepository fitnessCenterRepository, HallRepository hallRepository) {
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.hallRepository = hallRepository;
    }

    @Override
    public void removeFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO) throws Exception {
        FitnessCenter fc = this.fitnessCenterRepository.findByName(fitnessCenterNameDTO.getName());
        this.fitnessCenterRepository.deleteById(fc.getId());
    }

    @Override
    public FitnessCenter updateFitnessCenter(FitnessCenterNewDTO fitnessCenterNewDTO) throws Exception {
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByName(fitnessCenterNewDTO.getName());
        fitnessCenter.setName(fitnessCenterNewDTO.getNewName());
        fitnessCenter.setAddress(fitnessCenterNewDTO.getNewAddress());
        fitnessCenter.setPhone(fitnessCenterNewDTO.getNewPhone());
        fitnessCenter.setEmail(fitnessCenterNewDTO.getNewEmail());

        return this.fitnessCenterRepository.save(fitnessCenter);
    }

    @Override
    public List<FitnessCenterDTO> getAll() {
        List<FitnessCenter> fitnessCenterList = this.fitnessCenterRepository.findAll();
        List<FitnessCenterDTO> fitnessCenterDTOList = new ArrayList<>();
        for (FitnessCenter center : fitnessCenterList) {
            FitnessCenterDTO ft = new FitnessCenterDTO();
            ft.setName(center.getName());
            ft.setEmail(center.getEmail());
            ft.setAddress(center.getAddress());
            ft.setPhone(center.getPhone());
            fitnessCenterDTOList.add(ft);
        }

        return fitnessCenterDTOList;
    }

    @Override
    public Hall addNewHall(HallDTO hall) throws Exception {

        //1.pronadjemo id zeljenog centar
        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByName(hall.getFitnessCenterName());
        System.out.println(fitnessCenter.getName());
        System.out.println(fitnessCenter.getId());
        //2.dodamo hall
        Hall newHall = new Hall(hall.getCapacity(), hall.getMark(), fitnessCenter);

        return this.hallRepository.save(newHall);
    }

    @Override
    public Hall updateHall(HallNewDTO hall) throws Exception {



        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByName(hall.getFitnessCenterName());
        Hall oldHall = this.hallRepository.findByMarkAndCapacityAndFitnessCenter(hall.getMark(),hall.getCapacity(), fitnessCenter);


        oldHall.setCapacity(hall.getNewCapacity());
        oldHall.setMark(hall.getNewMark());

//        Hall hall1 = this.hallRepository.findByMarkAndFitnessCenter(hall.getMark(), fitnessCenter);
//        if(hall1 == null){
//            throw new Exception("Hall does not exist!");
//        }
//        hall1.setCapacity(hall.getCapacity());
//        hall1.setMark(hall.getMark());

        return this.hallRepository.save(oldHall);
    }

    @Override
    public void removeHall(HallDTO hall) throws Exception {

        FitnessCenter fitnessCenter = this.fitnessCenterRepository.findByName(hall.getFitnessCenterName());
        System.out.println(fitnessCenter.getId());
        Hall hall1 = this.hallRepository.findByMarkAndFitnessCenter(hall.getMark(), fitnessCenter);
        System.out.println(hall1.getId());
        //this.hallRepository.deleteByFitnessCenterAndMark(fitnessCenter,hall.getMark());
        this.hallRepository.deleteById(hall1.getId());

    }
}
