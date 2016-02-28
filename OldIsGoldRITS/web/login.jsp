<%-- 
    Document   : login
    Created on : Feb 18, 2016, 7:58:11 PM
    Author     : teck
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html >
    <head>
        <meta charset="UTF-8">
        <title>Old is Gold Login</title>




        <link rel="stylesheet" href="css/style.css">


<script src="js/jquery-2.1.4.js"></script>
<script src="js/bootstrap.min.js"></script>

    </head>
    <style>
        	/* Smartphones (portrait) ----------- */
	@media only screen
	and (min-device-width : 320px)
	and (max-device-width : 480px) and (orientation: portrait) {
		.form input
                {
                    width:90%;
                    font-size: 56px;
                }
                .form input:focus
                {
                    margin-left: -15%;
                    width:130%;
                    font-size: 64px;
                }
                .container h1{
                    font-weight: 400;
                    font-size: 125px;
                }
                
                .form button
                {
                    width: 100%;
                    font-size: 60px;
                    margin-top: 40px
                }
                .wrapper
                {
                    height: 50%;
                    margin-top: -37%;
                }
             
               
        }
    </style>
    <body>
<div id ="loginStatus"></div>
        <div class="wrapper">
            <div class="container">
             
                <h1 id="appName">Old is Gold</h1>

                <form class="form">
                       
                    <input id="user" type="text" placeholder="Username">
                    <input id="pass" type="password" placeholder="Password">
                    <button id="login-button">Login</button>

                </form>
            </div>

            <ul class="bg-bubbles">
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
                <li></li>
            </ul>
        </div>
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

       




    </body>
    <script>
        $(document).ready(function(){
            
            $('#login-button').click(function(event){
                event.preventDefault();
                $('#loginStatus').html('');
                console.log('the login button was clicked!');
                user = $('#user').val();
                pass = $('#pass').val();
                if(user==='' || pass==='')
                {
                    alert('Username or password cannot be empty!');
                }    
                else{
                    console.log('User = '+user+' pass= '+pass);
                    $('form').fadeOut(500);
                    
                $.ajax({
                    type: "POST",
                    url: "LoginAuth",
                    data: {user:user, pass:pass},
                    cache: false,
                    datatype: "application/json",
                    success: function(response){
                        window.location = "index";
                       
                    },
                    error: function(xhr, ajaxOptions, thrownError) {
                    $('form').fadeIn(500); 
                    $('#pass').val('');
                    $('#loginStatus').html('<link rel="stylesheet" href="css/bootstrap.min.css"><div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> Username or password is incorrect</div>')
                    console.log(xhr.status);
                    console.log(thrownError);
                    }
                });}
            });
            
            
            
        });
        
    </script>
</html>

