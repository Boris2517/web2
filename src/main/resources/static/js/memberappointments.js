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
        success: function (response) {  
            let i = 0;                            // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);
            for (let appointment of response) {
                i++;                   // prolazimo kroz listu svih zaposlenih
                let row = "<tr " + "id=" + appointment.id + ">";
                row += "<td>" + i + "</td>";                               
                row += "<td>" + appointment.trainingName + "</td>";
                row += "<td>" + appointment.trainingType + "</td>";
                row += "<td>" + appointment.fitnessCenter + "</td>";
                row += "<td>" + appointment.hall + "</td>";
                row += "<td>" + appointment.hour + ":" + appointment.min + "</td>";
                row += "<td>" + appointment.numberOfAttendees + "</td>";
                row += "<td>" + appointment.price + "</td>";
                // row += "<td>" + "<a href=\"#\" class=\"btn btn__aprove\"  >" + "Update" +"</a>" + "</td>";
                row += "<td>" + "<a class=\"btn-table\" href=\"#\" >" + "Apply" +"</a>" + "</td>";
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

$('#appointments_table').on('click','.btn-table', function(toggleThisTP){


    // $('#appointments_table').on('click','.btn-table', function(toggleThisTP) {
    //     var row = $(this).closest('tr');
    //     var id = row.attr('id');
    // });

    const appointmentId = $(this).closest('tr').attr('id');
    console.log(appointmentId);

    let AppointmentSignUpDTO = {
        appointmentId
    }

    $.ajax({
        type: "POST",                                                     
        url: "http://localhost:8081/api/member/appointment",                
        dataType: "json",                                               
        contentType: "application/json",                                 
        data: JSON.stringify(AppointmentSignUpDTO),                     
        success: function (response) {                                
            console.log(response); 
                                           
                                           
        },
        error: function () { 
            alert("Greška prilikom dodavanja clana!");
        }
    });
});



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