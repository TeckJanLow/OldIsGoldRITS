<%-- 
    Document   : inventory
    Created on : Feb 19, 2016, 5:09:23 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Manager</title>

        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
        <link rel="stylesheet" href="css/table.css">
       
    </head>
    
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div id="mainContent" style="display: none">
        <div id="inventoryForm" class = "row" style="margin-top:50px">
            <div class="col-md-12 col-md-offset-4">
                <form class="form-inline">
                    <div class="form-group">
                        <label class="sr-only" for="inventoryID">SKU</label>
                        <input type="text" class="form-control" id="sku" placeholder="SKU">
                    </div>
                    <div class="form-group">
                        <label class="sr-only" for="albumTitle">Title</label>
                        <input type="text" class="form-control" id="title" placeholder="Title">
                    </div>

                    <a id="search" class="btn btn-default" >
                        <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        Search
                    </a>
                </form>
            </div>
        </div>
        
    <div class="row" id = "progressBarOverview">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar"
                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>
        
        <div id="page-wrap" style="display: none">

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Job Title</th>
                    <th>Favorite Color</th>
                    <th>Wars or Trek?</th>

                    <th>Date of Birth</th>
                    <th>Dream Vacation City</th>
                    <th>GPA</th>
                    <th>Arbitrary Data</th>
                </tr>
                <tr>
                    <td>James</td>
                    <td>Matman</td>
                    <td>Chief Sandwich Eater</td>
                    <td>Lettuce Green</td>
                    <td>Trek</td>

                    <td>January 13, 1979</td>
                    <td>Gotham City</td>
                    <td>3.1</td>
                    <td>RBX-12</td>
                </tr>
                <tr>
                    <td>The</td>
                    <td>Tick</td>
                    <td>Crimefighter Sorta</td>
                    <td>Blue</td>
                    <td>Wars</td>

                    <td>July 19, 1968</td>
                    <td>Athens</td>
                    <td>N/A</td>
                    <td>Edlund, Ben (July 1996).</td>
                </tr>
                <tr>
                    <td>Jokey</td>
                    <td>Smurf</td>
                    <td>Giving Exploding Presents</td>
                    <td>Smurflow</td>
                    <td>Smurf</td>

                    <td>Smurfuary Smurfteenth, 1945</td>
                    <td>New Smurf City</td>
                    <td>4.Smurf</td>
                    <td>One</td>
                </tr>
                <tr>
                    <td>Cindy</td>
                    <td>Beyler</td>
                    <td>Sales Representative</td>
                    <td>Red</td>
                    <td>Wars</td>

                    <td>July 5, 1956</td>
                    <td>Paris</td>
                    <td>3.4</td>
                    <td>3451</td>
                </tr>
                <tr>
                    <td>Captain</td>
                    <td>Cool</td>
                    <td>Tree Crusher</td>
                    <td>Blue</td>
                    <td>Wars</td>

                    <td>December 13, 1982</td>
                    <td>Las Vegas</td>
                    <td>1.9</td>
                    <td>Under the couch</td>
                </tr>
            </table>

        </div>
    </div>

    </body>
    <script>
       $(document).ready(function() {
           $('#inventoryForm').hide();
           $('#progressBarOverview').hide();
           console.log('loaded inventory.jsp');
           $('#inventoryForm').fadeIn("slow");
           $('#mainContent').css('display','block');
       }); 
        
        $('#search').click(function(){
        $('#progressBarOverview').show();
       
        console.log("search button clicked!");
        sku = $('#sku').val();
        title = $('#title').val();
        
        $.ajax({
            type: "POST",
            url: "QueryInventory",
            data: {inventoryID:sku, title:title},
            cache: false,
            datatype: "application/json",
            success: function(data, textStatus, request){
                $('#progressBarOverview').hide();
                
                        $('#page-wrap').fadeIn("slow", function () {
                        $(this).show();
                    });},
                 error: function(xhr, ajaxOptions, thrownError) {
                $('#progressBarOverview').hide();
                console.log(xhr.status);
                console.log(thrownError);}
         
        });
         
    }); 
     
 

        

    </script>
</html>
