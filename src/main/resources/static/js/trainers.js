console.log("test");

/*
// Prikaz svih zaposlenih
$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/api/admin/trainers",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let trainer of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trainer.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trainer.surname + "</td>";
                row += "<td>" + trainer.username + "</td>";
                row += "<td>" + trainer.email + "</td>";
                row += "<td>" + trainer.phone + "</td>";
                row += "<td>" + trainer.active + "</td>";
                row += "</tr>"; 
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                // let btn = "<button class='btnSeeMore' data-id=" + employee.id + ">See More</button>";
                // row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                // btn = "<button class='btnDelete' data-id=" + employee.id + ">Delete</button>";
                // row += "<td>" + btn + "</td>";
                // row += "</tr>";                                     // završavamo kreiranje reda

                $('#trainers_table').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});
*/
$(document).on("submit", "#addTrainerForm", function (event){
    event.preventDefault();
    
    /*
    this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.birthdate = birthdate;
    */
    let username = $("#trainerUsername").val();
    let password= $("#trainerPassword").val();
    let name = $("#trainerPhone").val();
    let surname = $("#trainerEmail").val();
    let phone = $("#trainerPhone").val();
    let email = $("#trainerEmail").val();
    let birhtdate = $("#birthdate").val();

    let TrainerDTO = {
        username,
        password,
        name,
        surname,
        phone,
        email,
        birhtdate
    }


    
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8081/api/admin/trainers",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(TrainerDTO),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Trainer je uspesno dodat!");// prikazujemo poruku uspeha korisniku
               
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja trenera!");
        }
    });
    
});