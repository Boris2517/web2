$(document).ready(function () {
    getTrainingTypes();
    getHalls();
});

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

function getHalls(){

    $.ajax({
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        type: "GET",                                                     
        url: "http://localhost:8081/api/hall/trainer",               
        dataType: "json",                                         
        success: function (response) {
            types = response;
            console.log(types);
            for(let hall of response){
                $('#halls').append(`<option value="${hall.mark}">${hall.mark}</option>`);  
            }
            $("#halls").prop("selectedIndex", -1);
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
}