$(document).ready(function () {
    $('.sidebar ul li:first').addClass('active');
    $('.section:not(:first)').hide();
    $('.sidebar ul li a').click(function (event) {
        event.preventDefault();
        var content = $(this).attr('href');
        $(this).parent().addClass('active');
        $(this).parent().siblings().removeClass('active');
        $(content).show();
        $(content).siblings('.section').hide();
    });
    
    updateTrainers();
});


function btnclick(e) {
    
    const username = $(e).closest('tr').attr('id');
    let TrainerUsernameDTO = {
       username
    };

    $.ajax({
        type: "PUT",                                                     // HTTP metoda je POST
        url: "http://localhost:8081/api/admin/trainers",                 // URL na koji se šalju podaci
        dataType: "json",                                                // tip povratne vrednosti
        contentType: "application/json",                                 // tip podataka koje šaljemo
        data: JSON.stringify(TrainerUsernameDTO),                        // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                                   // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                       // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Radnik " + response.id + " je uspešno kreiran!");    // prikazujemo poruku uspeha korisniku
            updateTrainers();                               // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });

}

function updateTrainers(){

    $('#trainers_table').find('tbody').detach();
    $('#trainers_table').append($('<tbody>'));


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
                let row = "<tr " + "id=" + trainer.username + ">";                                   // kreiramo red za tabelu
                row += "<td>" + trainer.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trainer.surname + "</td>";
                row += "<td>" + trainer.username + "</td>";
                row += "<td>" + trainer.email + "</td>";
                row += "<td>" + trainer.phone + "</td>";
                
                
                if(trainer.active == false){
                    row += "<td class=\"status\" ><div class=\"status--inactive\">Inactive</div></td>";
                    row += "<td class=\"status\" ><a href=\"#\" onclick=\"btnclick(this)\" class=\"status--approve\">Approve</a></td>";
                } else {
                    row += "<td class=\"status\"><div class=\"status--active\">Active</div></td>";
                    row += "<td class=\"status\"></td>";
                }

                //  row += "<td>" + "<a class=\"btn btn__aprove\">" + "Approve" +"</a>" + "</td>";
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
}