<%-- 
    Document   : inventoryTable
    Created on : Feb 20, 2016, 7:34:42 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <div id="page-wrap">

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
                    <td><c:out value="${requestScope.title}"/></td>

                    <td>January 13, 1979</td>
                    <td>Gotham City</td>
                    <td>3.1</td>
                    <td>RBX-12</td>
                </tr>
                  <tr>
            <td>${title}</td> 
            <td>${title}</td> 
            <td>${title}</td>
            <td>${title}</td> 
            <td>${title}</td> 
            <td>${title}</td>
            <td>${title}</td> 
            <td>${title}</td>
            </tr> 
            <c:forEach var="element" items="${listData}">
            <tr>
            <td>${title}</td> 
            <td>${title}</td> 
            <td>${title}</td>
            <td>${title}</td> 
            <td>${title}</td> 
            <td>${title}</td>
            <td>${title}</td> 
            <td>${title}</td>
            </tr> 
            </c:forEach>
            </table>

        </div>
