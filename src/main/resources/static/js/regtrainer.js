$(document).on("submit", "#regtrainer", function (event){
    event.preventDefault();

    let username = $("#trainerUsername").val();
    let password= $("#trainerPassword").val();
    let name = $("#trainerFirstName").val();
    let surname = $("#trainerLastName").val();
    let phone = $("#trainerPhone").val();
    let email = $("#trainerEmail").val();
    let birhtdate = $("#trainerDate").val();

    let TrainerDTO = {
        username,
        password,
        name,
        surname,
        phone,
        email,
        birhtdate
    }

    console.log(TrainerDTO);

    
    $.ajax({
        type: "POST",
        url: "http://localhost:8081/api/registration/trainer",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(TrainerDTO),
        success: function (response) {
            console.log(response);

            alert("Trainer je uspesno dodat!");
               
        },
        error: function () {
            alert("Greška prilikom dodavanja trenera!");
        }
    });
    
});