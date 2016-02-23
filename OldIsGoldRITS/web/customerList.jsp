<%-- 
    Document   : customerList
    Created on : Feb 23, 2016, 12:19:41 AM
    Author     : madan
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<select id="customerList" class="form-control">
<c:forEach var="element" items="${customerList}">
    <option value ="${element.id}">${element.lastName}, ${element.firstName}</option>
</c:forEach>
</select>
   
           