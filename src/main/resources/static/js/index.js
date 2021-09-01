$(document).ready(function () {
   getLogedUser();
});


function getLogedUser(){

    let usernameObj = document.getElementById("username");

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     // HTTP metoda
        url: "http://localhost:8081/user/username",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);
            usernameObj.innerHTML = response.username;                 // ispisujemo u konzoli povratnu vrednost radi provere
            console.log(response.username);
            instantiateButtons(response);
            
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
            instantiateButtons(response);
        }
    });
}

function instantiateButtons(response){
    let sidebar = document.getElementById("sidebar");
    console.log(response.role);
    let buttons;
    if(response.role == "MEMBER"){
        sidebar.innerHTML = "";
        createButton("Logout", "/logout", sidebar);
        createButton("Profile", "/profile.html", sidebar);
        createButton("Appointments", "/appointments.html", sidebar);
    }else if(response.role == "TRAINER"){
        sidebar.innerHTML = "";
        createButton("Logout", "/logout", sidebar);
        createButton("Profile", "/profile.html", sidebar);
        createButton("Appointments", "/appointments.html", sidebar);
        createButton("Create Appointment", "/createappointment.html", sidebar);
        createButton("Create Training", "/createtraining.html", sidebar);
    }else if(response.role == "ADMIN"){
        sidebar.innerHTML = "";
        createButton("Logout", "/logout", sidebar);
        buttons += "<a href=\"#\">Profile</a>";
        buttons += "<a href=\"appointments\">Appointments</a>";
        buttons += "<a href=\"appointments\">Create new trainer</a>";
        buttons += "<a href=\"appointments\">Approve trainers</a>";
        buttons += "<a href=\"appointments\">Create Fintess Center</a>";
        buttons += "<a href=\"appointments\">Create new appointment</a>";
        buttons += "<a href=\"appointments\">Create new training</a>";
    }else{
        buttons += "<a href=\"login\">Login</a>";
    }

    
    
}

function createButton(linkText, href){
    var a = document.createElement('a');
    var linkText = document.createTextNode(linkText);
    a.appendChild(linkText);
    a.href = href;
    a.className = "button";
    sidebar.appendChild(a);
}