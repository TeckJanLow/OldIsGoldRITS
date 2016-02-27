<%-- 
    Document   : albumList
    Created on : Feb 27, 2016, 5:54:01 PM
    Author     : Teck Jan Low
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<select id="albumList" class="form-control">
<c:forEach var="element" items="${albumList}">
    <option value ="${element.id}">${element.title}, ${element.artist}</option>
</c:forEach>
</select>
