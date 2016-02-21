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
          
            <td><a data-toggle="modal" data-target="#myModal" id ="${element.request.requestID}" href="#" onclick="openEdit('${id}','${description}','${firstName}','${lastName}');"><span class="glyphicon glyphicon-edit"></span></a></td>
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
        <form class="form-horizontal">
  <div class="form-group">
    
    <div class="col-sm-10 col-sm-offset-1">
      <input type="text" id="requestID" class="form-control"  disabled>
    </div>
  </div>
  <div class="form-group">
       <div class="col-sm-10 col-sm-offset-1">
      <input type="description" class="form-control" id="description" >
    </div>
  </div>
  
  
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
    <script>
        function openEdit(identity, description, firstName, lastName)
        {
            $('#requestID').attr("placeholder", identity);
            $('#description').attr('placeholder', "Description");
            $('#description').val(description);
        }
    </script>

