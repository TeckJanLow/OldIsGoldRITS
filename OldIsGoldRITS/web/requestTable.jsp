<%-- 
    Document   : requestTable
    Created on : Feb 20, 2016, 9:25:43 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <div id="page-wrap">

            <table>
                <tr>
                    <th>Request ID</th>
                    <th>Description</th>
                    <th>Quantity</th>
                    <th>Date</th>
                    <th>Customer</th>
                    <th>Contact</th>
                    <th>Status</th>
                    <th>Manage</th>
                   
                </tr>

                  
            <c:forEach var="element" items="${requestList}">
            <tr>
            <td>${element.request.requestID}</td> 
            <td>${element.request.description}</td> 
            <td>${element.request.quantity}</td> 
            <td><fmt:formatDate value="${element.request.date}" pattern="MMM DD, YYYY"></fmt:formatDate></td>
            <td>${element.customer.firstName} ${element.customer.lastName}</td> 
            <td>
                <c:choose>
                    <c:when test="${element.customer.prefCommunication eq 'email'}">
                        ${element.customer.email}
                    </c:when>
                    <c:otherwise>
                        ${element.customer.phone}
                    </c:otherwise>
                </c:choose>
            </td>
            <td><c:choose><c:when test="${element.request.isComplete == 'true'}"><span style="color:#00b300">Complete</span>
                    </c:when>
                    <c:otherwise><span style="color:#e50000">
                        Pending
                        </span>
                    </c:otherwise>
                </c:choose>
            </td>
            <c:set var="id" value="${element.request.requestID}"/>
            <c:set var="description" value="${element.request.description}"/>
            <c:set var="firstName" value="${element.customer.firstName}"/>
            <c:set var="lastName" value="${element.customer.lastName}"/>
            <c:set var="isCompleted" value="${element.request.isComplete}"/>
            <td><a data-toggle="modal" data-target="#myModal" id ="${element.request.requestID}" href="#" onclick="openEdit('${id}','${description}','${firstName}','${lastName}', '${isCompleted}');"><span class="glyphicon glyphicon-edit"></span></a></td>
            </tr> 
            </c:forEach>
            </table>

        </div>
    
   <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Edit Request</h4>
      </div>
      <div class="modal-body">
          <div class="row" id = "progressBarOverviewModal" hidden="true">
    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
        <div class="progress">
            <div class="progress-bar progress-bar-striped active" role="progressbar"
                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                Loading
            </div>
        </div>
    </div></div>
          <div id ="updateStatus"></div>
        <form class="form-horizontal">
  <div class="form-group">
    
    <div class="col-sm-10 col-sm-offset-1">
      <input type="text" id="requestID" class="form-control"  disabled>
    </div>
  </div>
  <div class="form-group">
       <div class="col-sm-10 col-sm-offset-1">
      <input type="text" class="form-control" id="description" >
    </div>
  </div>
  <div class="form-group">
       <div class="col-sm-10 col-sm-offset-1">
      <input type="text" class="form-control" id="firstName" >
    </div>
  </div>
   <div class="form-group">
       <div class="col-sm-10 col-sm-offset-1">
      <input type="text" class="form-control" id="lastName" >
    </div>
  </div> 
   <div class="checkbox col-sm-offset-1">
    <label>
      <input type="checkbox" id="statusCheck"> Completed
    </label>
  </div>
  
  
</form>
      </div>
      <div class="modal-footer">
        <button id="closeButton" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button id="updateButton" type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
      </div>
</div>
    <script>
        function openEdit(identity, description, firstName, lastName, statusCheck)
        {
            $('#requestID').val(identity);
            $('#description').attr('placeholder', "Description");
            $('#description').val(description);
            $('#firstName').attr('placeholder', "Customer First Name");
            $('#firstName').val(firstName);
            $('#lastName').attr('placeholder', "Customer Last Name");
            $('#lastName').val(lastName); 
            if(statusCheck === 'true')
            {
                $('#statusCheck').prop("checked", true);
            }
            else
            {
                $('#statusCheck').prop("checked", false);
            }
        }
        
        $.ready(function(){
            $('#progressBarOverviewModal').hide();
        });
        
        $('#closeButton').click(function(){
            $('#progressBarOverviewModal').hide();
            $('.form-horizontal').show();
             $('#updateStatus').html('');
             $('#updateButton').hide();
             $('#search').trigger('click');
        });
           
            $('#updateButton').click(function(){
                $('#progressBarOverviewModal').show();
                console.log("save changes");
                requestID = $('#requestID').val();
                description = $('#description').val();
                firstName = $('#firstName').val();
                lastName = $('#lastName').val();
                status = $("#statusCheck").is(':checked');
                $('.form-horizontal').hide();
                console.log(requestID);
            $.ajax({
            type: "POST",
            url: "QueryRequest",
            data: {requestID:requestID, description:description, firstName:firstName, lastName:lastName, status:status, update:true},
            cache: false,
            datatype: "application/json",
            success: function(data, textStatus, request){
                $('#progressBarOverviewModal').hide();
                $('#updateStatus').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Success!</strong> Record updated successfully</div>');
                
                $('#updateButton').hide();
                    },
                 error: function(xhr, ajaxOptions, thrownError) {
                $('#progressBarOverviewModal').hide();
                console.log(xhr.status);
                console.log(thrownError);
            $('#updateButton').hide();}
         
        });
            
            
        });
        
    </script>

