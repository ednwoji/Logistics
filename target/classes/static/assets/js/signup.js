$(function() {
$(".btn").click(function() {
$(".form-signin").toggleClass("form-signin-left");
$(".form-signup").toggleClass("form-signup-left");
$(".frame").toggleClass("frame-long");
$(".signup-inactive").toggleClass("signup-active");
$(".signin-active").toggleClass("signin-inactive");
$(".forgot").toggleClass("forgot-left");
$(this).removeClass("idle").addClass("active");
});
});

//$(function() {
//$(".btn-signup").click(function() {
//$(".nav").toggleClass("nav-up");
//$(".form-signup-left").toggleClass("form-signup-down");
//$(".success").toggleClass("success-left");
//$(".frame").toggleClass("frame-short");
//});
//});

//$(function() {
//$(".btn-signin").click(function() {
//$(".btn-animate").toggleClass("btn-animate-grow");
//$(".welcome").toggleClass("welcome-left");
//$(".cover-photo").toggleClass("cover-photo-down");
//$(".frame").toggleClass("frame-short");
//$(".profile-photo").toggleClass("profile-photo-down");
//$(".btn-goback").toggleClass("btn-goback-up");
//$(".forgot").toggleClass("forgot-fade");
//});
//});



$(document).ready(function() {
  $("#btn-signup").click(function() {
    var email = $("#email").val();
    var phone = $("#mobile").val();
    var username = $("#username").val();
    var password = $("#password").val();
    var address = $("#address").val();


    $.ajax({
      type: "POST",
      url: "/users/saveuser",
      data: JSON.stringify({
              user_name: username,
              user_password: password,
              address: address,
              email: email,
              phone: phone

        }),
      contentType: "application/json",
      success: function(response) {
        console.log("Data saved successfully");
        console.log(response); // log the JSON response from the server
        $("#form-signup")[0].reset();

        $("#btn-signup").hide();
        $(".success-text").show();
         $// hide the button with ID "button"

      },
      error: function(xhr, status, error) {
        console.log("An error occurred while saving data: " + error);
      }
    });
  });
});






$(document).ready(function() {
  $("#btn-signin").click(function() {
    var email = $("#logemail").val();
    var password = $("#logpassword").val();


    $.ajax({
      type: "POST",
      url: "/users/verifyuser",
      data: JSON.stringify({
              email: email,
              user_password: password,

        }),
      contentType: "application/json",
      success: function(response) {
        console.log("User logged in successfully");
        window.location.href = "home";

      },
      error: function(xhr, status, error) {
        console.log("Wrong credentials " + error);

      }
    });
  });
});