package com.example.fitness.service;

import com.example.fitness.entity.DTO.*;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;

import java.util.List;

public interface FitnessCenterService{

    void removeFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO) throws Exception;
    FitnessCenter updateFitnessCenter(FitnessCenterNewDTO fitnessCenterNewDTO) throws Exception;
    List<FitnessCenterDTO> getAll();

    //--------------------HALLS--------------------
    Hall addNewHall(HallDTO hall) throws Exception;
    Hall updateHall(HallNewDTO hall) throws Exception;
    void removeHall(HallDTO hall) throws Exception;


}
