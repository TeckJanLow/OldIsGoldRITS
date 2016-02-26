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
                    <th>SKU</th>
                    <th>Artist</th>
                    <th>Title</th>
                    <th>Genre</th>
                    <th>Quality</th>

                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Comments</th>
                </tr>

            <c:forEach var="element" items="${inventoryList}">
            <tr>
            <td>${element.inventory.inventoryID}</td> 
            <td>${element.album.artist}</td>
            <td>${element.album.title}</td>
            <td>${element.album.genre}</td>
            <td>${element.inventory.quality}</td> 
            <td>${element.inventory.quantityOnHand}</td> 
            <td>${element.inventory.price}</td>
            <td>${element.album.comments}</td> 
            
            </tr> 
            </c:forEach>
            </table>

        </div>
