var json=[{"rolename":"some role","perc":45.5},{"rolename":"another role","perc":36.4},{"rolename":"role three","perc":9.1},{"rolename":"role four","perc":9.1}];
var answer=json.map(el=>Object.values(el));
console.log(answer);

var types;
let appointments;

$(document).ready(function () {
    getTrainingTypes();
    updateAppointments();
});

//Trening type change
$('#training-types').on('change', function() {
    $('#appoint-table').find('tbody').detach();
    $('#appoint-table').append($('<tbody>'));
    let i = 0;
    let state = this.value;
    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                    
        url: "http://localhost:8081/api/appointment/all",              
        dataType: "json",                                           
        success: function (response) {                           
            console.log("SUCCESS:\n", response);                   
            appointments = response;
            console.log(appointments);
            console.log(this.value);
            for (let app of response) {      
                i++;
                if(app.trainingType == state){
                    let row = "<tr " + "id=" + i + " >";
                row += "<td>" + i + "</td>";              
                row += "<td>" + app.trainingName + "</td>";
                row += "<td>" + app.trainingType + "</td>";
                row += "<td>" + app.fitnessCenter + "</td>";
                row += "<td>" + app.hour + ':' + app.min + "</td>";
                row += "<td>" + app.price + "</td>";
                row += "</tr>";
                $('#appoint-table').append(row);
                }
            }
        },
        error: function (response) {                           
            console.log("ERROR:\n", response);
        }
    });
});


//TrainigTypes
function getTrainingTypes(){

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     
        url: "http://localhost:8081/api/training/types",               
        dataType: "json",                                         
        success: function (response) {
            types = response;
            console.log(types);
            for(let trainingType of response){
                $('#training-types').append(`<option value="${trainingType.name}">${trainingType.name}</option>`);  
            }
            $("#training-types").prop("selectedIndex", -1);
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
}



function updateAppointments(){

    $('#appoint-table').find('tbody').detach();
    $('#appoint-table').append($('<tbody>'));
    let i = 0;
    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                    
        url: "http://localhost:8081/api/appointment/all",              
        dataType: "json",                                           
        success: function (response) {                           
            console.log("SUCCESS:\n", response);                   
            appointments = response;
            console.log(appointments);
            for (let app of response) {      
                i++;
                let row = "<tr " + "id=" + i + " >";
                row += "<td>" + i + "</td>";              
                row += "<td>" + app.trainingName + "</td>";
                row += "<td>" + app.trainingType + "</td>";
                row += "<td>" + app.fitnessCenter + "</td>";
                row += "<td>" + app.hour + ':' + app.min + "</td>";
                row += "<td>" + app.price + "</td>";
                row += "</tr>";
                $('#appoint-table').append(row);
            }
        },
        error: function (response) {                           
            console.log("ERROR:\n", response);
        }
    });
}


// $(document).ready(function () {
//    getLogedUser();
// });


// function getLogedUser(){

//     let usernameObj = document.getElementById("username");

//     $.ajax({
//         headers: {
//             'Content-Type': 'application/x-www-form-urlencoded'
//         },
//         type: "GET",                                                     // HTTP metoda
//         url: "http://localhost:8081/user/username",                 // URL koji se gađa
//         dataType: "json",                                           // tip povratne vrednosti
//         success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
//             console.log("SUCCESS:\n", response);
//             usernameObj.innerHTML += " " + response.username;                 // ispisujemo u konzoli povratnu vrednost radi provere
//             console.log(response.username);
//             instantiateButtons(response);
            
//         },
//         error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
//             console.log("ERROR:\n", response);
//             instantiateButtons(response);
//         }
//     });
// }

// function instantiateButtons(response){
//     let sidebar = document.getElementById("sidebar");
//     console.log(response.role);
//     let buttons;
//     if(response.role == "MEMBER"){
//         sidebar.innerHTML = "";
//         createButton("Logout", "/logout", sidebar);
//         createButton("Profile", "/memberprofile.html", sidebar);
//         createButton("Appointments", "/memberappointments.html", sidebar);
//     }else if(response.role == "TRAINER"){
//         sidebar.innerHTML = "";
//         createButton("Logout", "/logout", sidebar);
//         createButton("Profile", "/profile.html", sidebar);
//         createButton("Appointments", "/appointments.html", sidebar);
//         createButton("Create Appointment", "/createappointment.html", sidebar);
//         createButton("Create Training", "/createtraining.html", sidebar);
//     }else if(response.role == "ADMIN"){
//         sidebar.innerHTML = "";
//         createButton("Logout", "/logout", sidebar);
//         buttons += "<a href=\"#\">Profile</a>";
//         buttons += "<a href=\"appointments\">Appointments</a>";
//         buttons += "<a href=\"appointments\">Create new trainer</a>";
//         buttons += "<a href=\"appointments\">Approve trainers</a>";
//         buttons += "<a href=\"appointments\">Create Fintess Center</a>";
//         buttons += "<a href=\"appointments\">Create new appointment</a>";
//         buttons += "<a href=\"appointments\">Create new training</a>";
//     }else{
//         sidebar.innerHTML = "";
//         createButton("Login", "/login", sidebar);
//         createButton("Register as member", "/registrationUser.html", sidebar);
//         createButton("Register as trainer", "/registrationTrainer.html", sidebar);
//         createButton("Appointments", "/appointments", sidebar);
//     }

    
    
// }

// function createButton(linkText, href){
//     var a = document.createElement('a');
//     var linkText = document.createTextNode(linkText);
//     a.appendChild(linkText);
//     a.href = href;
//     a.className = "button";
//     sidebar.appendChild(a);
// }