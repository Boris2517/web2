package com.example.fitness.controller;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
import com.example.fitness.entity.MyDate;
import com.example.fitness.entity.UserDetails.MyUserDetails;
import com.example.fitness.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
    }


    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AppointmentDTO> createAppointment(@AuthenticationPrincipal MyUserDetails userDetails,  @RequestBody AppointmentDTO appointmentDTO) throws Exception {
        System.out.println("controller begin!");
        Appointment appointment = this.appointmentService.createAppointment(appointmentDTO, userDetails.getUsername());
        System.out.println("controller gets appointment");
        if(appointment == null) throw new Exception("Appointment null in controller");
        AppointmentDTO appointmentDTO1 = new AppointmentDTO();
        System.out.println("1");
        appointmentDTO1.setDate(appointment.getDate());
        appointmentDTO1.setHall(appointment.getHall().getMark());
        System.out.println("2");
        appointmentDTO1.setPrice(appointment.getPrice());
        System.out.println("3");
        appointmentDTO1.setTrainerUsername(appointment.getTrainer().getUsername());
        System.out.println("4");
        appointmentDTO1.setNumberOfAttendees(appointment.getNumberOfAttendees());
        System.out.println("5");
        appointmentDTO1.setFitnessCenter(appointment.getFitnessCenter().getName());
        appointmentDTO1.setTrainingType(appointment.getTraining().getType().getName());
        System.out.println("6");
        appointmentDTO1.setHour(appointment.getTime().getHour());
        System.out.println("7");
        appointmentDTO1.setMin(appointment.getTime().getMin());
        System.out.println("8");

        return new ResponseEntity<>(appointmentDTO1, HttpStatus.ACCEPTED);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value="/fitness")
    public ResponseEntity<ArrayList<AppointmentDTO>> getAppointmentsByFitnessCenter(@RequestBody FitnessCenterNameDTO fitnessCenterNameDTO){
        ArrayList<Appointment> appointments = this.appointmentService.getAppointmentsByFitnessCenter(fitnessCenterNameDTO);
        ArrayList<AppointmentDTO> appointmentDTOS = new ArrayList<>();

        for (Appointment appointment: appointments) {

            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setId(appointment.getId());
            appointmentDTO.setNumberOfAttendees(appointment.getNumberOfAttendees());
            appointmentDTO.setDate(appointment.getDate());
            appointmentDTO.setPrice(appointment.getPrice());
            appointmentDTO.setHall(appointment.getHall().getMark());
            appointmentDTO.setTrainingName(appointment.getTraining().getName());
            appointmentDTO.setTrainerUsername(appointment.getTraining().getCreator().getUsername());
            appointmentDTOS.add(appointmentDTO);
        }

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.ACCEPTED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/all")
    public ResponseEntity<ArrayList<AppointmentDTO>> getAllAppointments(){
        List<Appointment> appointments = this.appointmentService.getAllAppointments();
        ArrayList<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        for (Appointment appointment: appointments) {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            appointmentDTO.setId(appointment.getId());
            appointmentDTO.setHall(appointment.getHall().getMark());
            appointmentDTO.setDate(appointment.getDate());
            appointmentDTO.setTrainingName(appointment.getTraining().getName());
            appointmentDTO.setPrice(appointment.getPrice());
            appointmentDTO.setTrainerUsername(appointment.getTrainer().getUsername());
            appointmentDTO.setNumberOfAttendees(appointment.getNumberOfAttendees());
            appointmentDTO.setFitnessCenter(appointment.getFitnessCenter().getName());
            appointmentDTO.setTrainingType(appointment.getTraining().getType().getName());
            appointmentDTO.setMin(appointment.getTime().getMin());
            appointmentDTO.setHour(appointment.getTime().getHour());
            appointmentDTOS.add(appointmentDTO);
        }
        return new ResponseEntity<>(appointmentDTOS, HttpStatus.ACCEPTED);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value="/trainer")
    public ResponseEntity<ArrayList<AppointmentDTO>> getTrainerAppointments(@AuthenticationPrincipal MyUserDetails userDetails) throws Exception {

        System.out.println("Controller 1");
        ArrayList<Appointment> appointments = this.appointmentService.getTrainerAppointments(userDetails.getUsername());
        System.out.println("Controller 2");
        ArrayList<AppointmentDTO> appointmentDTOS = new ArrayList<>();
        System.out.println("Controller 3");
        for (Appointment appointment: appointments) {
            System.out.println("Controller 4");
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            System.out.println("Controller 5");
            appointmentDTO.setId(appointment.getId());
            System.out.println("Controller 6");
            appointmentDTO.setHall(appointment.getHall().getMark());
            System.out.println("Controller 7");
            appointmentDTO.setDate(appointment.getDate());
            System.out.println("Controller 8");
            appointmentDTO.setTrainingName(appointment.getTraining().getName());
            System.out.println("Controller 9");
            appointmentDTO.setPrice(appointment.getPrice());
            System.out.println("Controller 10");
            appointmentDTO.setTrainerUsername(appointment.getTrainer().getUsername());
            System.out.println("Controller 11");
            appointmentDTO.setNumberOfAttendees(appointment.getNumberOfAttendees());
            System.out.println("Controller 12");
            appointmentDTO.setFitnessCenter(appointment.getFitnessCenter().getName());
            System.out.println("Controller 13");
            appointmentDTO.setTrainingType(appointment.getTraining().getType().getName());
            System.out.println("Controller 14");
            appointmentDTO.setMin(appointment.getTime().getMin());
            System.out.println("Controller 15");
            appointmentDTO.setHour(appointment.getTime().getHour());
            System.out.println("Controller 16");
            appointmentDTOS.add(appointmentDTO);
        }

        return new ResponseEntity<>(appointmentDTOS, HttpStatus.ACCEPTED);
    }



//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, value = "/user")
//    public ResponseEntity<ArrayList<AppointmentDTO>> getMemberAppointments(@AuthenticationPrincipal MyUserDetails userDetails){
//
//        List<Appointment> appointments = this.appointmentService.getMemberAppointments(userDetails.getUsername());
//
//    }


}
