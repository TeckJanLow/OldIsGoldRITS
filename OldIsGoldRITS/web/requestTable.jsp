<%-- 
    Document   : requestTable
    Created on : Feb 20, 2016, 9:25:43 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>	
	/* 
	Max width before this PARTICULAR table gets nasty
	This query will take effect for any screen smaller than 760px
	and also iPads specifically.
	*/
	@media 
	only screen and (max-width: 960px),
	(min-device-width: 480px) and (max-device-width: 1024px)  {
	
		/* Force table to not be like tables anymore */
		table, thead, tbody, th, td, tr { 
			display: block; 
		}
		
		/* Hide table headers (but not display: none;, for accessibility) */
		thead tr { 
			position: absolute;
			top: -9999px;
			left: -9999px;
		}
		
		tr { border: 1px solid #ccc; }
		
		td { 
			/* Behave  like a "row" */
			border: none;
			border-bottom: 1px solid #eee; 
			position: relative;
			padding-left: 50%; 
		}
		
		td:before { 
			/* Now like a table header */
			position: absolute;
			/* Top/left values mimic padding */
			top: 6px;
			left: 6px;
			width: 45%; 
			padding-right: 10px; 
			white-space: nowrap;
		}
		
		/*
		Label the data
		*/
		td:nth-of-type(1):before { font-weight: bold; content: "Request ID"; }
		td:nth-of-type(2):before { font-weight: bold; content: "Description"; }
		td:nth-of-type(3):before { font-weight: bold; content: "Quantity"; }
		td:nth-of-type(4):before { font-weight: bold; content: "Date"; }
		td:nth-of-type(5):before { font-weight: bold; content: "Customer"; }
		td:nth-of-type(6):before { font-weight: bold; content: "Contact"; }
		td:nth-of-type(7):before { font-weight: bold; content: "Status"; }
		td:nth-of-type(8):before { font-weight: bold; content: "Manage"; }
		
	}
	
	/* Smartphones (portrait and landscape) ----------- */
	@media only screen
	and (min-device-width : 320px)
	and (max-device-width : 480px) {
		body { 
			padding: 0; 
			margin-left:0; 
			width: 400px 
		}
                table {
                    margin-left: -84px;
                    width: 385px;
                }
                .glyphicon.glyphicon-edit {
                    font-size: 45px;
               }
               .glyphicon.glyphicon-trash {
                    font-size: 45px;
               }
               
        }
	
	/* iPads (portrait and landscape) ----------- */
	@media only screen and (min-device-width: 768px) and (max-device-width: 1024px) {
		body { 
			width: 495px; 
		}
	}
	
	</style>
	<!--<![endif]-->

    <div id="page-wrap">

            <table>
                <thead>
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
                </thead>
                  
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
            <c:set var="quantity" value="${element.request.quantity}"/>
            <c:set var="isCompleted" value="${element.request.isComplete}"/>
            <td><a style="margin-left:15px" data-toggle="modal" data-target="#myModal" id ="${element.request.requestID}" href="#" onclick="openEdit('${id}','${description}','${quantity}','${isCompleted}');"><span class="glyphicon glyphicon-edit"></span></a>
            <a style="margin-left:10px" data-toggle="modal" data-target="#confirmDeleteModal" id ="delete_${element.request.requestID}" href="#" onclick="deleteRequest('${id}');"><span class="glyphicon glyphicon-trash"></span></a>
       
            </td>
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
                Updating...
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
      <input type="number" min="1" class="form-control" id="quantity" >
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
        function openEdit(identity, description, quantity, statusCheck)
        {
            $('#requestID').val(identity);
            $('#description').attr('placeholder', "Description");
            $('#description').val(description);
            $('#quantity').attr('placeholder', "Quantity");
            $('#quantity').val(quantity);
            
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
            $('#customerList').on('change',function(){console.log($('#customerList').val());});
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
                quantity = $('#quantity').val();
                if(quantity === '')
                {
                    quantity = 1;
                }
                console.log('quantity = '+$('#quantity').val());
                
                status = $("#statusCheck").is(':checked');
                $('.form-horizontal').hide();
                console.log(requestID);
            $.ajax({
            type: "POST",
            url: "QueryRequest",
            data: {requestID:requestID, description:description, quantity:quantity, status:status, update:true},
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

