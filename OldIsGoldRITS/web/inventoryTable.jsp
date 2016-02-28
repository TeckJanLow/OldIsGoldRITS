<%-- 
    Document   : inventoryTable
    Created on : Feb 20, 2016, 7:34:42 PM
    Author     : madan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="page-wrap">

    <table>
        <thead>
            <tr>
                <th>SKU</th>
                <th>Artist</th>
                <th>Title</th>
                <th>Genre</th>
                <th>Quality</th>

                <th>Quantity</th>
                <th>Price</th>
                <th>Comments</th>

                <th>Manage</th>
            </tr>
        </thead>

        <c:forEach var="element" items="${inventoryList}">
            <tr>
                <td>${element.inventory.inventoryID}</td> 
                <td>${element.album.artist}</td>
                <td>${element.album.title}</td>
                <td>${element.album.genre}</td>
                <td>${element.inventory.quality}</td> 
                <td>${element.inventory.quantityOnHand}</td> 
                <td><fmt:formatNumber value="${element.inventory.price}" type="currency"/></td>
                <td>${element.album.comments}</td> 

                <c:set var="skuID" value="${element.inventory.inventoryID}"/>
                <c:set var="artist" value="${element.album.artist}"/>
                <c:set var="title" value="${element.album.title}"/>
                <c:set var="genre" value="${element.album.genre}"/>
                <c:set var="quality" value="${element.inventory.quality}"/>
                <c:set var="quantityEdit" value="${element.inventory.quantityOnHand}"/>
                <c:set var="price" value="${element.inventory.price}"/>
                <c:set var="commentsEdit" value="${fn:trim(element.album.comments)}"/>

                <td><a style="margin-left:15px" data-toggle="modal" data-target="#myInventoryModal" href="#" onclick="editInventory('${skuID}', '${quantityEdit}', '${price}', '${commentsEdit}');"><span class="glyphicon glyphicon-edit"></span></a>
                    <a style="margin-left:10px" data-toggle="modal" data-target="#confirmDeleteModal" id ="delete_${element.inventory.inventoryID}" href="#" onclick="deleteInventory('${skuID}', '${quantityEdit}' , '${quality}', '${title}');"><span class="glyphicon glyphicon-trash"></span></a>
                </td>

            </tr> 
        </c:forEach>
    </table>

</div>


<div class="modal fade" id="myInventoryModal" tabindex="-1" role="dialog" aria-labelledby="myInventoryModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit Inventory</h4>
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
                    </div>
                </div>
                <div id ="updateStatus"></div>
                <form class="form-horizontal">
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-1">
                            <input type="text" id="skuID" class="form-control"  disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-1">
                            <input type="number" min="1" class="form-control" id="quantity" placeholder="Quantity">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-1">
                            <input type="number" min="1" class="form-control" id="price" placeholder="Price">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-1">
                            <input type="text" class="form-control" id="comments" placeholder="Comments" >
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="closeButton" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button id="updateInventoryButton" type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="myDeleteModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Delete Request</h4>
            </div>
            <div class="modal-body">

                <div id ="warningStatus">
                    <div class="alert alert-danger fade in">
                        <strong>Warning!</strong> You are about to delete an Inventory item. This action is permanent. Deleted items cannot be retrieved!
                    </div>
                </div>
                <div id="deletedStatus"></div>
                <div class="row" id = "deleteProgressBarOverviewModal" hidden="true">
                    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
                        <div class="progress">
                            <div class="progress-bar progress-bar-danger progress-bar-striped active" role="progressbar"
                                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                                Deleting...
                            </div>
                        </div>
                    </div></div>
                <form class="form-horizontal">

                    <div class="form-group">
                        <div class="col-sm-10 col-sm-offset-1" id="deleteDetails">
                            <input type="hidden" id ="deleteIdentity"/> 
                        </div>
                    </div>
                    <div class="checkbox col-sm-offset-1">
                        <label>
                            <input type="checkbox" id="confirmDeleteCheck"> I want to delete this item.
                        </label>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button id="cancelDeleteButton" type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                <button id="confirmDeleteButton" type="button" class="btn btn-danger">Delete</button>
            </div>
        </div>
    </div>
</div>  

<script>

    function editInventory(identity, quantity, price, comments)
    {
        if (comments !== '')
        {
            $('#comments').val(comments);
        }
        $('#skuID').val(identity);
        $('#quantity').val(quantity);
        $('#price').val(price);
    }

    $.ready(function () {
        $('#progressBarOverviewModal').hide();
        $('#albumList').on('change', function () {
            console.log($('#albumList').val());
        });

    });

    $('#closeButton').click(function () {
        $('#progressBarOverviewModal').hide();
        $('.form-horizontal').show();
        $('#updateStatus').html('');
        $('#updateInventoryButton').hide();
        $('#search').trigger('click');
    });

    $('#updateInventoryButton').click(function () {
        $('#progressBarOverviewModal').show();
        console.log("save changes");
        sku = $('#skuID').val();
        quantity = $('#quantity').val();
        price = $('#price').val();
        comments = $('#comments').val();
        if (quantity === '')
        {
            quantity = 1;
        }
        console.log('quantity = ' + $('#quantity').val());

        $('.form-horizontal').hide();
        console.log('sku = ' + $('#skuID').val());
        console.log('quantity = ' + $('#quantity').val());
        console.log('price = ' + $('#price').val());
        console.log('comments = ' + $('#comments').val());
        $.ajax({
            type: "POST",
            url: "QueryInventory",
            data: {sku: sku, quantity: quantity, price: price, comments: comments, update: true},
            cache: false,
            datatype: "application/json",
            success: function (data, textStatus, request) {
                $('#progressBarOverviewModal').hide();
                $('#updateStatus').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Success!</strong> Inventory updated successfully</div>');

                $('#updateInventoryButton').hide();
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $('#progressBarOverviewModal').hide();
                console.log(xhr.status);
                console.log(thrownError);
                $('#updateInventoryButton').hide();
            }
        });
    });
    
    $('#cancelDeleteButton').click(function(){
         $('#deletedStatus').html('');
         $('#search').trigger('click');
    });
    
    function deleteInventory(identity, quantity, quality, title)
    {
        $('#deleteDetails').html(quantity + ' units of SKU ' + identity + ' "' + title + '" of quality "' + quality + '" will be deleted!');
        $('#deleteIdentity').val(identity);
        $('#cancelDeleteButton').text('Cancel');
    }
    
    $('#confirmDeleteButton').click(function(){
        
        if($('#confirmDeleteCheck').is(':checked'))
        {
            sku = $('#deleteIdentity').val() ;
            console.log('deleting ' + sku + ' now...');
                   
            $('#deleteProgressBarOverviewModal').show();
            $.ajax({
                type: "POST",
                url: "QueryInventory",
                data: {sku: sku, delete: true},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#deleteProgressBarOverviewModal').hide();
                    $('#deletedStatus').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Success!</strong> Inventory deleted successfully</div>');
                    $('#deleteDetails').html('');
                    $('#deleteDetails').hide();
                    $('#confirmDeleteButton').hide();
                    $('#cancelDeleteButton').text('Close');
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#deleteProgressBarOverviewModal').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                    $('#deletedStatus').html('<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> Failed to delete inventory</div>');
                    $('#cancelDeleteButton').text('Close');
                    $('#confirmDeleteButton').hide();
                }
                        
            });
        }
        else
        {
            alert('Please confirm by checking the \'I want to delete this item\' checkbox');
        }
        
    });

</script>