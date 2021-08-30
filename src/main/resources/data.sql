

--ADMINISTERATORI
--INSERT INTO admins (id,username,password,name,surname,phone,email,birth_date,role,active_status) VALUES (1,'admin','admin','admin','admin','0621614681','email@email.com',null,0,true)
--TRENERI
-- INSERT INTO trainers (id,username,password,name,surname,phone,email,birth_date,role,active_status,average_rating) VALUES (1,'trener1','sifra','Marko','Markovic','0621234567','markomarkovic@email.com',null,1,true,3.2)
-- INSERT INTO trainers (id,username,password,name,surname,phone,email,birth_date,role,active_status,average_rating) VALUES (2,'trener2','sifra','Pera','Peric','0621234567','peraperic@email.com',null,1,false, 4.0)
-- INSERT INTO trainers (id,username,password,name,surname,phone,email,birth_date,role,active_status,average_rating) VALUES (3,'trener3','sifra','Marko','Kral;jevic','0621234567','markokraljevic@email.com',null,1,false,5.0)

--KORISNICI FITNES CENTRA



--FITNESS CENTRI
INSERT INTO fitness_center (id,name, address,email,phone) VALUES (1,'Ime1','Ulica 1 Novi Sad','fitnesscentar1@mail.com','0627418529')
--INSERT INTO fitness_center (id,name, address,email,phone) VALUES (2,'Ime2','Ulica 2 Beograd','fitnesscentar2@mail.com','0631596575')

--SALE
--INSERT INTO hall (id,capacity,mark,fitness_center_id) VALUES (1,10,'H10',1)
--INSERT INTO hall (id,capacity,mark,fitness_center_id) VALUES (2,10,'B10',1)
--INSERT INTO hall (id,capacity,mark,fitness_center_id) VALUES (3,5,'H5',2)
--INSERT INTO hall (id,capacity,mark,fitness_center_id) VALUES (4,12,'H12',1)

-- --TRENING
-- INSERT INTO training (id, description,duration,name,type) VALUES (1,'Opis treninga 1',45,'Trening1','Individualni')
-- INSERT INTO training (id, description,duration,name,type) VALUES (2,'Opis treninga 2',80,'Trening2','Grupni')
-- INSERT INTO training (id, description,duration,name,type) VALUES (3,'Opis treninga 3',90,'Trening2','Grupni')
--
-- --ZAKAZANI TRENING
-- INSERT INTO appointment (id,date,num_of_attendees,time,training_day,trainings_id) VALUES (1,null,1,null,1,1)
-- INSERT INTO appointment (id,date,num_of_attendees,time,training_day,trainings_id) VALUES (2,null,10,null,4,2)
-- INSERT INTO appointment (id,date,num_of_attendees,time,training_day,trainings_id) VALUES (3,null,5,null,5,3)
--
-- --fintess center halls
-- INSERT INTO fitness_center_halls (fitness_center_id,halls_id) VALUES (1,1)
-- INSERT INTO fitness_center_halls (fitness_center_id,halls_id) VALUES (1,3)
-- INSERT INTO fitness_center_halls (fitness_center_id,halls_id) VALUES (1,4)
-- INSERT INTO fitness_center_halls (fitness_center_id,halls_id) VALUES (2,2)
--
-- --fintess center trainers
-- INSERT INTO fitness_center_trainers (fitness_center_id,trainers_id) VALUES (1,2)
-- INSERT INTO fitness_center_trainers (fitness_center_id,trainers_id) VALUES (1,3)
-- INSERT INTO fitness_center_trainers (fitness_center_id,trainers_id) VALUES (2,4)
--
-- INSERT INTO hall_training_list (hall_id,training_list_id) VALUES (1,1)
-- INSERT INTO hall_training_list (hall_id,training_list_id) VALUES (3,2)
-- INSERT INTO hall_training_list (hall_id,training_list_id) VALUES (2,3)