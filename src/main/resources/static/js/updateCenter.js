$('#centers-selector').change(function(){

    let id = $('#centers-selector').val();
    console.log(id);

    $.ajax({
        type: "GET",                                               // HTTP metoda je POST
        url: "http://localhost:8081/api/admin/center/" + id,                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
                         
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Fitness Centar je uspesno dodat!");// prikazujemo poruku uspeha korisniku
               
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });

  });