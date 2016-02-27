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

    <body>

        <div class="wrapper">
            <div class="container">
                <h1>Welcome</h1>

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
                    console.log(xhr.status);
                    console.log(thrownError);
                    }
                });}
            });
            
            
            
        });
        
    </script>
</html>

