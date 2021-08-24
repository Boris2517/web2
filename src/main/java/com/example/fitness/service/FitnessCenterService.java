package com.example.fitness.service;

import com.example.fitness.entity.DTO.FitnessCenterDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
import com.example.fitness.entity.DTO.HallDTO;
import com.example.fitness.entity.Hall;

import java.util.List;

public interface FitnessCenterService{

    void removeFitnessCenter(FitnessCenterNameDTO fitnessCenterNameDTO) throws Exception;
    List<FitnessCenterDTO> getAll();

    //--------------------HALLS--------------------
    Hall addNewHall(HallDTO hall) throws Exception;
    Hall updateHall(HallDTO hall) throws Exception;
    void removeHall(HallDTO hall) throws Exception;


}
