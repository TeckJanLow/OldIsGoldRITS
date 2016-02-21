<%-- 
    Document   : requestTable
    Created on : Feb 20, 2016, 9:25:43 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div id="page-wrap">

            <table>
                <tr>
                    <th>Request ID</th>
                    <th>Description</th>
                    <th>Customer</th>
                    <th>Status</th>
                   
                </tr>

                  
            <c:forEach var="element" items="${requestList}">
            <tr>
            <td>${element.request.requestID}</td> 
            <td>${element.request.description}</td> 
            <td>${element.customer.firstName} ${element.customer.lastName}</td> 
            <td><c:choose><c:when test="${element.request.isComplete == 'true'}"><span style="color:#00b300">Complete</span>
                    </c:when>
                    <c:otherwise><span style="color:#e50000">
                        Pending
                        </span>
                    </c:otherwise>
                </c:choose>
            </td> 
            
            </tr> 
            </c:forEach>
            </table>

        </div>

