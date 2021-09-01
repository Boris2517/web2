package com.example.fitness.controller;

import com.example.fitness.entity.Appointment;
import com.example.fitness.entity.DTO.AppointmentDTO;
import com.example.fitness.entity.DTO.FitnessCenterNameDTO;
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
    public ResponseEntity<AppointmentDTO> createAppointment(@RequestBody AppointmentDTO appointmentDTO) throws Exception {

        Appointment appointment = this.appointmentService.createAppointment(appointmentDTO);
        if(appointment == null) throw new Exception("Appointment null in contorller");
        AppointmentDTO appointmentDTO1 = new AppointmentDTO();
        //appointmentDTO1.setDate(appointment.getDate());
        appointmentDTO1.setHall(appointment.getHall().getMark());
        appointmentDTO1.setPrice(appointment.getPrice());
        appointmentDTO1.setTrainerUsername(appointment.getTraining().getCreator().getUsername());
        appointmentDTO1.setNumberOfAttendees(appointment.getNumberOfAttendees());
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
            appointmentDTO.setFintessCenter(appointment.getFitnessCenter().getName());
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
