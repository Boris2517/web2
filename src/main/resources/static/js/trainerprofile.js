$(document).ready(function () {
    updateAppointments();
});

function updateAppointments(){

    $('#appointments_table').find('tbody').detach();
    $('#appointments_table').append($('<tbody>'));
    let i = 0;
    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                    
        url: "http://localhost:8081/api/appointment/trainer",              
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
                row += "<td>" + app.numberOfAttendees + "</td>";
                row += "<td>" + app.day + "-" +app.month + '-' + app.year + "</td>";
                row += "<td>" + app.hour + ':' + app.min + "</td>";
                row += "<td>" + app.price + "</td>";
                row += "</tr>";
                $('#appointments_table').append(row);
            }
        },
        error: function (response) {                           
            console.log("ERROR:\n", response);
        }
    });
}