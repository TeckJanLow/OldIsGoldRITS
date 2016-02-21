<%-- 
    Document   : request
    Created on : Feb 19, 2016, 5:09:33 PM
    Author     : Dell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Request Manager</title>

        
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
        <link rel="stylesheet" href="css/table.css">
       
    </head>
    
    <body>
        <jsp:include page="header.jsp"></jsp:include>
        <div id="mainContent" style="display: none">
        <div id="requestForm" class = "row" style="margin-top:50px">
            <div class="col-md-12 col-md-offset-4">
                <form class="form-inline">
                    <div class="form-group">
                        
                        <div class="btn-group">
  <button id="btnStatus" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Select Status <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
    <li><a href="#">Pending</a></li>
    <li><a href="#">Completed</a></li>
     <li role="separator" class="divider"></li>
    <li><a href="#">Show All</a></li>
  </ul>
</div>
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
        <jsp:include page="requestTable.jsp"></jsp:include>

        
    
    </div>

    </body>
    <script>
       $(document).ready(function() {
           $('li.active').removeClass('active');
           $('#requestTab').addClass('active');
           $('#requestForm').hide();
           $('#page-wrap').hide();
           $('#progressBarOverview').hide();
           console.log('loaded request.jsp');
           $('#requestForm').fadeIn("slow");
           $('#mainContent').css('display','block');
           statusText = '';
           $('.dropdown-menu a').click(function(e){
           $('#btnStatus').html(this.innerHTML +' <span class="caret"></span>');
           statusText = this.innerHTML;
            });
            
        $('#search').click(function(){
            console.log('search clicked');
        $('#page-wrap').hide();   
        $('#progressBarOverview').show();
        status = '';
           if(statusText === 'Completed')
           {
               status = true;
           }
           else if (statusText==='Pending')
           {
               status = false;
           }
           else
           {
               status='';
           }
       
        console.log('status ='+status);
        
        title = $('#title').val();
        
        $.ajax({
            type: "POST",
            url: "QueryRequest",
            data: {status:status, title:title},
            cache: false,
            datatype: "application/json",
            success: function(data, textStatus, request){
                $('#progressBarOverview').hide();
                
                $('#page-wrap').html(data);
                        $('#page-wrap').fadeIn("slow", function () {
                        $(this).show();
                       
                    });},
                 error: function(xhr, ajaxOptions, thrownError) {
                $('#progressBarOverview').hide();
                console.log(xhr.status);
                console.log(thrownError);}
         
        });
         
    }); 
       }); 
        
       
     
 

   
  



        

    </script>
</html>
