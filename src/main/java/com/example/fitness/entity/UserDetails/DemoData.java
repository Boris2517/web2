package com.example.fitness.entity.UserDetails;

import com.example.fitness.entity.*;
import com.example.fitness.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DemoData {


    private final TrainerRepository trainerRepository;
    private final AdminRepository adminRepository;
    private final TrainingRepository trainingRepository;
    private final FitnessCenterRepository fitnessCenterRepository;
    private final HallRepository hallRepository;
    private final AppointmentRepository appointmentRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public DemoData(TrainerRepository trainerRepository, AdminRepository adminRepository, TrainingRepository trainingRepository, FitnessCenterRepository fitnessCenterRepository, HallRepository hallRepository, AppointmentRepository appointmentRepository, MemberRepository memberRepository) {
        this.trainerRepository = trainerRepository;
        this.adminRepository = adminRepository;
        this.trainingRepository = trainingRepository;
        this.fitnessCenterRepository = fitnessCenterRepository;
        this.hallRepository = hallRepository;
        this.appointmentRepository = appointmentRepository;
        this.memberRepository = memberRepository;
    }

    @EventListener
    public void appReady(ApplicationReadyEvent event) throws ParseException {
        Admin admin = new Admin("admin", "admin","Boris","Knezevic","0621914681","boris.knezevic@mail.ru");

        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("21/08/1990");

        admin.setBirthdate(date);

        //Treneri
        Trainer trainer1 = new Trainer("trainer1", "sifra1", "Boris","Knezevic","0621914681","boris.knezevic@mail.ru");
        Trainer trainer2 = new Trainer("trainer2", "sifra1", "Danijela","Peric","06219181528","danijela@mail.com");
        Trainer trainer3 = new Trainer("trainer3", "sifra1", "Pera","Peric","06214323681","peraperic@mail.ru");
        Trainer trainer4 = new Trainer("trainer4", "sifra1", "Marko","Maric","065181528","markomaric@mail.com");
        Trainer trainer5 = new Trainer("trainer5", "sifra1", "Dejan","Dejanovic","06219714681","dejan132@mail.ru");
        Trainer trainer6 = new Trainer("trainer6", "sifra1", "Nebojsa","Mali","06319181528","nesa@cmail.com");

        //FitnessCenter
        FitnessCenter fitnessCenter1 = new FitnessCenter();
        fitnessCenter1.setName("Fitness One");
        fitnessCenter1.setEmail("fitness@gmail.com");
        fitnessCenter1.setAddress("Adressa 1");
        fitnessCenter1.setPhone("0621914685");
        fitnessCenter1.addTrainer(trainer1);
        fitnessCenter1.addTrainer(trainer2);
        //HAlls
        Hall hall1 = new Hall();
        hall1.setMark("H3");
        hall1.setCapacity(30);
        hall1.setFitnessCenter(fitnessCenter1);

        Hall hall2 = new Hall();
        hall2.setMark("H6");
        hall2.setCapacity(60);
        hall2.setFitnessCenter(fitnessCenter1);

        Hall hall3 = new Hall();
        hall3.setMark("H4");
        hall3.setCapacity(40);
        hall3.setFitnessCenter(fitnessCenter1);

        fitnessCenter1.addHall(hall1);
        fitnessCenter1.addHall(hall2);
        fitnessCenter1.addHall(hall3);

        //FitnessCenter2
        FitnessCenter fitnessCenter2 = new FitnessCenter();
        fitnessCenter2.setName("Fitness Strong");
        fitnessCenter2.setEmail("strongfitness@gmail.com");
        fitnessCenter2.setAddress("Adressa 2");
        fitnessCenter2.setPhone("0625588222");
        fitnessCenter2.addTrainer(trainer3);
        fitnessCenter2.addTrainer(trainer4);
        //HAlls
        Hall hall4 = new Hall();
        hall4.setMark("MK1");
        hall4.setCapacity(20);
        hall4.setFitnessCenter(fitnessCenter2);

        Hall hall5 = new Hall();
        hall5.setMark("SF1");
        hall5.setCapacity(30);
        hall5.setFitnessCenter(fitnessCenter2);

        Hall hall6 = new Hall();
        hall6.setMark("MK2");
        hall6.setCapacity(30);
        hall6.setFitnessCenter(fitnessCenter2);

        fitnessCenter2.addHall(hall4);
        fitnessCenter2.addHall(hall5);
        fitnessCenter2.addHall(hall6);

        //FitnessCenter3
        FitnessCenter fitnessCenter3 = new FitnessCenter();
        fitnessCenter3.setName("Fitness Detelinara");
        fitnessCenter3.setEmail("detelinarafitness@gmail.com");
        fitnessCenter3.setAddress("Adressa 3");
        fitnessCenter3.setPhone("06255553333");
        fitnessCenter3.addTrainer(trainer5);
        fitnessCenter3.addTrainer(trainer6);
        //HAlls
        Hall hall7 = new Hall();
        hall7.setMark("DT-1");
        hall7.setCapacity(20);
        hall7.setFitnessCenter(fitnessCenter3);


        Hall hall8 = new Hall();
        hall8.setMark("DT-2");
        hall8.setCapacity(10);
        hall8.setFitnessCenter(fitnessCenter3);

        Hall hall9 = new Hall();
        hall9.setMark("DT-3");
        hall9.setCapacity(45);
        hall9.setFitnessCenter(fitnessCenter3);

        fitnessCenter3.addHall(hall7);
        fitnessCenter3.addHall(hall8);
        fitnessCenter3.addHall(hall9);


        //Trainer1
        Training training1 = new Training();
        training1.setDescription("Kratki opis - aerobic - trainer1");
        training1.setDuration(60);
        training1.setName("Aerobic - Trainer1");
        training1.setCreator(trainer1);
        training1.setType(TrainingType.AEROBIC);

        Training training2 = new Training();
        training2.setDescription("Kratki opis - strength - trainer1");
        training2.setDuration(120);
        training2.setName("Strength - Trainer1");
        training2.setCreator(trainer1);
        training2.setType(TrainingType.STRENGTH);


        //Trainer2
        Training training3 = new Training();
        training3.setDescription("Kratki opis - aerobic - trainer2");
        training3.setDuration(45);
        training3.setName("Aerobic - Trainer2");
        training3.setCreator(trainer2);
        training3.setType(TrainingType.AEROBIC);

        Training training4 = new Training();
        training4.setDescription("Kratki opis - Balance and Stability - trainer2");
        training4.setDuration(80);
        training4.setName("Balance and Stability - Trainer2");
        training4.setCreator(trainer2);
        training4.setType(TrainingType.BALANCE_AND_STABILITY);
        //Trainer 3
        Training training5 = new Training();
        training5.setDescription("Kratki opis - Flexibility and Mobility - trainer3");
        training5.setDuration(45);
        training5.setName("Flexibility - Trainer3");
        training5.setCreator(trainer3);
        training5.setType(TrainingType.FLEXIBILITY_AND_MOBILITY);

        //Trainer 4
        Training training6 = new Training();
        training6.setDescription("Kratki opis - Strength - trainer4");
        training6.setDuration(90);
        training6.setName("Strength - Trainer4");
        training6.setCreator(trainer4);
        training6.setType(TrainingType.STRENGTH);

        //Trainer 5
        Training training7 = new Training();
        training7.setDescription("Kratki opis - Strength - trainer5");
        training7.setDuration(45);
        training7.setName("Strength - Trainer5");
        training7.setCreator(trainer4);
        training7.setType(TrainingType.STRENGTH);

        //Trainer 6
        Training training8 = new Training();
        training8.setDescription("Kratki opis - Coordination and Agility - trainer6");
        training8.setDuration(45);
        training8.setName("Coordination and Agility - Trainer6");
        training8.setCreator(trainer6);
        training8.setType(TrainingType.COORDINATION_AND_AGILITY);

        Date appDate1 = new SimpleDateFormat("dd/mm/yyyy").parse("12/09/2021");
        Appointment appointment1 = new Appointment();
        appointment1.setTraining(training1);
        appointment1.setNumberOfAttendees(20);
        appointment1.setPrice(102.00f);
        appointment1.setDate(appDate1);
        appointment1.setHall(hall1);
        appointment1.setFitnessCenter(fitnessCenter1);
        appointment1.setTrainer(training1.getCreator());

        Date appDate2 = new SimpleDateFormat("dd/mm/yyyy").parse("18/09/2021");
        Appointment appointment2 = new Appointment();
        appointment2.setTraining(training2);
        appointment2.setNumberOfAttendees(30);
        appointment2.setPrice(160.00f);
        appointment2.setDate(appDate2);
        appointment2.setHall(hall2);
        appointment2.setFitnessCenter(fitnessCenter1);
        appointment2.setTrainer(training2.getCreator());

        Date appDate3 = new SimpleDateFormat("dd/mm/yyyy").parse("20/09/2021");
        Appointment appointment3 = new Appointment();
        appointment3.setTraining(training1);
        appointment3.setNumberOfAttendees(45);
        appointment3.setPrice(102.00f);
        appointment3.setDate(appDate3);
        appointment3.setHall(hall3);
        appointment3.setFitnessCenter(fitnessCenter1);
        appointment3.setTrainer(training1.getCreator());


        fitnessCenter1.addAppointment(appointment1);
        fitnessCenter1.addAppointment(appointment2);
        fitnessCenter1.addAppointment(appointment3);

        //Members

        Member member1 = new Member();
        Date memDate1 = new SimpleDateFormat("dd/mm/yyyy").parse("20/02/1994");
        member1.setRole(Role.MEMBER);
        member1.setActive(true);
        member1.setName("Pera");
        member1.setSurname("Pericic");
        member1.setUsername("user1");
        member1.setPassword("pass");
        member1.setEmail("pericic@gmail.com");
        member1.setPhone("062191468155");
        member1.setBirthdate(memDate1);
        member1.setFutureTrainings(appointment1);
        member1.setFutureTrainings(appointment2);



        Member member2= new Member();
        Date memDate2 = new SimpleDateFormat("dd/mm/yyyy").parse("18/05/1993");
        member2.setRole(Role.MEMBER);
        member2.setActive(true);
        member2.setName("Milica");
        member2.setSurname("Peric");
        member2.setUsername("user2");
        member2.setPassword("pass");
        member2.setEmail("pericM@gmail.com");
        member2.setPhone("06215568155");
        member2.setBirthdate(memDate2);


        Member member3 = new Member();
        Date memDate3 = new SimpleDateFormat("dd/mm/yyyy").parse("02/12/1993");
        member3.setRole(Role.MEMBER);
        member3.setActive(true);
        member3.setName("Dusan");
        member3.setSurname("Rakic");
        member3.setUsername("user3");
        member3.setPassword("pass");
        member3.setEmail("dusanrakic@gmail.com");
        member3.setPhone("066888568155");
        member3.setBirthdate(memDate3);

        Member member4 = new Member();
        Date memDate4 = new SimpleDateFormat("dd/mm/yyyy").parse("05/11/1995");
        member4.setRole(Role.MEMBER);
        member4.setActive(true);
        member4.setName("Marko");
        member4.setSurname("Nikolic");
        member4.setUsername("user4");
        member4.setPassword("pass");
        member4.setEmail("markoNikolic@gmail.com");
        member4.setPhone("066888558155");
        member4.setBirthdate(memDate4);


        Member member5 = new Member();
        Date memDate5 = new SimpleDateFormat("dd/mm/yyyy").parse("08/08/1998");
        member5.setRole(Role.MEMBER);
        member5.setActive(true);
        member5.setName("Predrag");
        member5.setSurname("Lazic");
        member5.setUsername("user5");
        member5.setPassword("pass");
        member5.setEmail("predrag333@gmail.com");
        member5.setPhone("06245558155");
        member5.setBirthdate(memDate5);

        Member member6 = new Member();
        Date memDate6 = new SimpleDateFormat("dd/mm/yyyy").parse("12/08/1993");
        member6.setRole(Role.MEMBER);
        member6.setActive(true);
        member6.setName("Nebojsa");
        member6.setSurname("Stojakovic");
        member6.setUsername("user6");
        member6.setPassword("pass");
        member6.setEmail("nesa353@gmail.com");
        member6.setPhone("06245335205");
        member6.setBirthdate(memDate6);

        Member member7 = new Member();
        Date memDate7 = new SimpleDateFormat("dd/mm/yyyy").parse("12/08/1999");
        member7.setRole(Role.MEMBER);
        member7.setActive(true);
        member7.setName("Ranko");
        member7.setSurname("Stajic");
        member7.setUsername("user7");
        member7.setPassword("pass");
        member7.setEmail("ranko@gmail.com");
        member7.setPhone("06999335205");
        member7.setBirthdate(memDate7);

        Member member8 = new Member();
        Date memDate8 = new SimpleDateFormat("dd/mm/yyyy").parse("03/03/2000");
        member8.setRole(Role.MEMBER);
        member8.setActive(true);
        member8.setName("Sinisa");
        member8.setSurname("Lazic");
        member8.setUsername("user8");
        member8.setPassword("pass");
        member8.setEmail("singer@gmail.com");
        member8.setPhone("05559335205");
        member8.setBirthdate(memDate8);


        Member member9 = new Member();
        Date memDate9 = new SimpleDateFormat("dd/mm/yyyy").parse("03/08/1989");
        member9.setRole(Role.MEMBER);
        member9.setActive(true);
        member9.setName("Stefan");
        member9.setSurname("Nemanja");
        member9.setUsername("user9");
        member9.setPassword("pass");
        member9.setEmail("stefannemanja@gmail.com");
        member9.setPhone("06809335205");
        member9.setBirthdate(memDate9);


        Member member10 = new Member();
        Date memDate10 = new SimpleDateFormat("dd/mm/yyyy").parse("04/33/1991");
        member10.setRole(Role.MEMBER);
        member10.setActive(true);
        member10.setName("Jovana");
        member10.setSurname("Matic");
        member10.setUsername("user10");
        member10.setPassword("pass");
        member10.setEmail("Jovana@gmail.com");
        member10.setPhone("06809377205");
        member10.setBirthdate(memDate10);


        this.adminRepository.save(admin);
        this.trainerRepository.save(trainer1);
        this.trainerRepository.save(trainer2);
        this.trainerRepository.save(trainer3);
        this.trainerRepository.save(trainer4);
        this.trainerRepository.save(trainer5);
        this.trainerRepository.save(trainer6);


        this.fitnessCenterRepository.save(fitnessCenter1);
        this.fitnessCenterRepository.save(fitnessCenter2);
        this.fitnessCenterRepository.save(fitnessCenter3);

//        this.hallRepository.save(hall1);
//        this.hallRepository.save(hall2);
//        this.hallRepository.save(hall3);
//        this.hallRepository.save(hall4);
//        this.hallRepository.save(hall5);
//        this.hallRepository.save(hall6);
//        this.hallRepository.save(hall7);
//        this.hallRepository.save(hall8);
//        this.hallRepository.save(hall9);

        this.trainingRepository.save(training1);
        this.trainingRepository.save(training2);
        this.trainingRepository.save(training3);
        this.trainingRepository.save(training4);
        this.trainingRepository.save(training5);
        this.trainingRepository.save(training6);
        this.trainingRepository.save(training7);
        this.trainingRepository.save(training8);


        this.appointmentRepository.save(appointment1);
        this.appointmentRepository.save(appointment2);
        this.appointmentRepository.save(appointment3);

        this.memberRepository.save(member1);
        this.memberRepository.save(member2);
        this.memberRepository.save(member3);
        this.memberRepository.save(member4);
        this.memberRepository.save(member5);
        this.memberRepository.save(member6);
        this.memberRepository.save(member7);
        this.memberRepository.save(member8);
        this.memberRepository.save(member9);
        this.memberRepository.save(member10);


    }

}
