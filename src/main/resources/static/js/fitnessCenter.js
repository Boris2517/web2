$(document).ready(function () {
    updateCenters();
});


function deleteFitnessCenter(e){
    const id = $(e).closest('tr').attr('id');
    console.log(name);
    

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "DELETE",                                                     // HTTP metoda je POST
        url: "http://localhost:8081/api/admin/center/" + id,                 // URL na koji se šalju podaci
        dataType: "json",                                                // tip povratne vrednosti
                                                                  // tip podataka koje šaljemo
                               // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function () {                                   // ova f-ja se izvršava posle uspešnog zahteva
                                                               // ispisujemo u konzoli povratnu vrednost radi provere
            alert("Fitness center je uspesno izbrisan!");    // prikazujemo poruku uspeha korisniku
            updateCenters();                             // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom brisanja centra!");
        }
    });
}

function updateCenters(){

    $('#fitness_table').find('tbody').detach();
    $('#fitness_table').append($('<tbody>'));

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/api/admin",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere

            for (let fitness of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr " + "id=" + fitness.id + " >";                                   // kreiramo red za tabelu
                row += "<td>" + fitness.name + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + fitness.address + "</td>";
                row += "<td>" + fitness.email + "</td>";
                row += "<td>" + fitness.phone + "</td>";
                row += "<td>" + "<a href=\"#\" class=\"btn btn__aprove\"  >" + "Update" +"</a>" + "</td>";
                row += "<td>" + "<a href=\"#\" class=\"btn btn__aprove\"  onclick=\"deleteFitnessCenter(this)\" >" + "Delete" +"</a>" + "</td>";
                row += "</tr>";
                
                $('#halls').append($('<option>', {value:fitness.name, text:fitness.name}));
                $('#centers-selector').append($('<option>', {value:fitness.id, text:fitness.name}));
                $("#centers-selector").prop("selectedIndex", -1);
                $('#fitness_table').append(row);                      // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
}


$(document).on("submit", "#addCenterForm", function (event) {
    
    console.log("test");
    let name = $("#centerName").val();
    let address= $("#centerAddress").val();
    let phone = $("#centerPhone").val();
    let email = $("#centerEmail").val();

    let FitnessCenterDTO = {
        name,
        address,
        phone,
        email
    }
    
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8081/api/admin/center",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(FitnessCenterDTO),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Fitness Centar je uspesno dodat!");// prikazujemo poruku uspeha korisniku
               
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});


$('#select').append($('<option>', {value:1, text:'One'}));
