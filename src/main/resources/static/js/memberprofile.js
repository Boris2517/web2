$(document).ready(function () {
    getUserInfo();
});


function getUserInfo(){

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/user/profile",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);
            document.getElementById("name").innerHTML = response.name;
            document.getElementById("surname").innerHTML = response.surname;
            document.getElementById("username").innerHTML = response.username;
            document.getElementById("password").innerHTML = response.password;
            document.getElementById("email").innerHTML = response.email;
            document.getElementById("phone").innerHTML = response.phone;
            document.getElementById("birthday").innerHTML = response.birthdate;

            document.getElementById("name_input").value = response.name;
            document.getElementById("surname_input").value = response.surname;
            document.getElementById("email_input").value = response.email;
            document.getElementById("phone_input").value = response.phone;
            document.getElementById("date_input").value = response.birthdate.slice(0,10);
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });

}

$( "#update_form" ).submit(function( event ) {
    
    event.preventDefault();

    let name = document.getElementById("name_input").value;
    let surname = document.getElementById("surname_input").value;
    let email = document.getElementById("email_input").value;
    let phone = document.getElementById("phone_input").value;
    let birthdate = document.getElementById("date_input").value;

    let UserDTO = {
        name,
        surname,
        email,
        phone,
        birthdate
    };

    $.ajax({
        type: "PUT",                                                     // HTTP metoda je POST
        url: "http://localhost:8081/api/member",                 // URL na koji se šalju podaci
        dataType: "json",                                                // tip povratne vrednosti
        contentType: "application/json",                                 // tip podataka koje šaljemo
        data: JSON.stringify(UserDTO),                        // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                                   // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                       // ispisujemo u konzoli povratnu vrednost radi provere
            updateUserInfo(response);
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška prilikom dodavanja zaposlenog!");
        }
    });
});

function updateUserInfo(response){
  
    document.getElementById("name").innerHTML = response.name;
    document.getElementById("surname").innerHTML = response.surname;
    document.getElementById("username").innerHTML = response.username;
    document.getElementById("password").innerHTML = response.password;
    document.getElementById("email").innerHTML = response.email;
    document.getElementById("phone").innerHTML = response.phone;
    document.getElementById("birthday").innerHTML = response.birthdate;
}