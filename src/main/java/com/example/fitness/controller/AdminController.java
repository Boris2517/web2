package com.example.fitness.controller;


import com.example.fitness.entity.DTO.*;
import com.example.fitness.entity.FitnessCenter;
import com.example.fitness.entity.Hall;
import com.example.fitness.service.AdminService;
import com.example.fitness.service.FitnessCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    private final AdminService adminService;
    private final FitnessCenterService fitnessCenterService;

    @Autowired
    public AdminController(AdminService adminService, FitnessCenterService fitnessCenterService){
        this.adminService = adminService;
        this.fitnessCenterService = fitnessCenterService;
    }

    //dodavanje novog fitness centra
    @RequestMapping(value = "/center")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnessCenterDTO> addFitnessCenter(@RequestBody FitnessCenterDTO fitnessCenter) throws Exception {
    //public FitnessCenterDTO(String name, String address, String phone, String email)
        FitnessCenter center = new FitnessCenter(fitnessCenter.getName(),fitnessCenter.getAddress(), fitnessCenter.getPhone(),fitnessCenter.getEmail());

        FitnessCenter newCenter = adminService.addFitnessCenter(center);

        FitnessCenterDTO newCenterDTO = new FitnessCenterDTO(newCenter.getName(), newCenter.getAddress(), newCenter.getPhone(), newCenter.getEmail());

        return new ResponseEntity<>(newCenterDTO, HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnessCenterDTO>> getAllFitnessCenters(){
        List<FitnessCenterDTO> fitnessCenterDTOList = this.fitnessCenterService.getAll();

        return new ResponseEntity<>(fitnessCenterDTOList, HttpStatus.ACCEPTED);
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/center")
    public ResponseEntity<FitnessCenter> updateFitnessCenter(@RequestBody FitnessCenterNewDTO fitnessCenterNewDTO) throws Exception {
        FitnessCenter fitnessCenter = this.fitnessCenterService.updateFitnessCenter(fitnessCenterNewDTO);

        return new ResponseEntity<>(fitnessCenter, HttpStatus.ACCEPTED);
    }


    @DeleteMapping(value = "/center/{name}")
    public ResponseEntity<Void> removeFitnessCenter(@PathVariable String name) throws Exception {
        FitnessCenterNameDTO fitnessCenterNameDTO = new FitnessCenterNameDTO(name);

        this.fitnessCenterService.removeFitnessCenter(fitnessCenterNameDTO);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


//    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/center")
//    public ResponseEntity<Void> removeFitnessCenter(@RequestBody FitnessCenterNameDTO fitnessCenterNameDTO) throws Exception {
//
//
//        this.fitnessCenterService.removeFitnessCenter(fitnessCenterNameDTO);
//
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
//    }



    //---------------------------------------------------------------------------------------------------------------
    //--------------------------------------HALLS--------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/center/hall")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hall> addHall(@RequestBody HallDTO hall) throws Exception {

        Hall newHall = this.fitnessCenterService.addNewHall(hall);

        return new ResponseEntity<>(newHall,  HttpStatus.CREATED);
    }


    @PutMapping(value = "/center/hall",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Hall> updateHall(@RequestBody HallNewDTO hall) throws Exception {

        Hall newHall = this.fitnessCenterService.updateHall(hall);

        return new ResponseEntity<>(newHall,  HttpStatus.ACCEPTED);
    }



    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/center/hall")
    public ResponseEntity<Void> removeHall(@RequestBody HallDTO hall) throws Exception {


        this.fitnessCenterService.removeHall(hall);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
