$(document).ready(function () {
    getAllAppointments();
});

function getAllAppointments(){
    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/api/appointment/all",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);
            for (let appointment of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr " + "id=" + appointment.id + ">";                                   // kreiramo red za tabelu
                row += "<td>" + appointment.fintessCenter + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + appointment.trainingName + "</td>";
                row += "<td>" + appointment.trainerUsername + "</td>";
                row += "<td>" + appointment.hall + "</td>";
                row += "<td>" + appointment.numberOfAttendees + "</td>";
                row += "<td>" + appointment.price + "</td>";
                // row += "<td>" + "<a href=\"#\" class=\"btn btn__aprove\"  >" + "Update" +"</a>" + "</td>";
                row += "<td>" + "<a href=\"#\" onclick=\"applyForTraining()\" >" + "Apply" +"</a>" + "</td>";
                row += "</tr>";

                $('#appointments_table').append(row); 
            }
            getMemberAppointments();
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
}

function applyForTraining(){


    const appointmentId = $(e).closest('tr').attr('id');

    let AppointmentSignUpDTO = {
        appointmentId
    }

    $.ajax({
        type: "POST",                                                     // HTTP metoda je POST
        url: "http://localhost:8081/api/member/appointment",                 // URL na koji se šalju podaci
        dataType: "json",                                                // tip povratne vrednosti
        contentType: "application/json",                                 // tip podataka koje šaljemo
        data: JSON.stringify(AppointmentSignUpDTO),                        // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                                   // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response); 
                                                 // ispisujemo u konzoli povratnu vrednost radi provere
                                           
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
}



function getMemberAppointments(){

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/api/member/app",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);
            // for (let appointment of response) {                        // prolazimo kroz listu svih zaposlenih
            //     let row = "<tr " + "id=" + appointment.id + ">";                                   // kreiramo red za tabelu
            //     row += "<td>" + appointment.fintessCenter + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
            //     row += "<td>" + appointment.trainingName + "</td>";
            //     row += "<td>" + appointment.trainerUsername + "</td>";
            //     row += "<td>" + appointment.hall + "</td>";
            //     row += "<td>" + appointment.numberOfAttendees + "</td>";
            //     row += "<td>" + appointment.price + "</td>";
            //     // row += "<td>" + "<a href=\"#\" class=\"btn btn__aprove\"  >" + "Update" +"</a>" + "</td>";
            //     row += "<td>" + "<a href=\"#\" onclick=\"applyForTraining()\" >" + "Apply" +"</a>" + "</td>";
            //     row += "</tr>";

            //     $('#appointments_table').append(row); 
            // }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });

}