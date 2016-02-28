<%-- 
    Document   : inventory
    Created on : Feb 19, 2016, 5:09:23 PM
    Author     : Dell
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <link rel="icon" href="../../favicon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Manager</title>


        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/starter-template.css" rel="stylesheet">
        <link rel="stylesheet" href="css/table.css">

    </head>

    <style>

        /* Smartphones (portrait and landscape) ----------- */
        @media only screen
        and (min-device-width : 320px)
        and (max-device-width : 480px) {
            body { 
                padding: 0; 
                margin-left:0; 
                width: 400px 
            }

            #btnStatus{
                margin-top: 15px
            }
            .form-control
            {
                width:90%
            }
            .form-group
            {
                margin-left:12px
            }
            #search
            {
                margin-left: 12px
            }
            #addNewRequest
            {
                margin-left: 12px
            }
        }
    </style>

    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div id="mainContent" style="display: none">
                <div id="inventoryForm" class = "row" style="margin-top:50px">
                    <div class="col-md-12 col-md-offset-4">
                        <form class="form-inline">
                            <div class="form-group">
                                <label class="sr-only" for="inventoryID">SKU</label>
                                <input type="text" class="form-control" id="sku" placeholder="SKU">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="albumTitle">Title</label>
                                <input type="text" class="form-control" id="title" placeholder="Title">
                            </div>

                            <a id="search" class="btn btn-default" >
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                Search
                            </a>
                            <a id="addNewInventory" data-toggle="modal" data-target="#addNewInventoryModal" class="btn btn-primary col-md-offset-2" >
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                Add New Inventory
                            </a>
                        </form>
                    </div>
                </div>
            <jsp:include page="inventoryTable.jsp"></jsp:include>
                <div class="row" id = "progressBarOverview">
                    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped active" role="progressbar"
                                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                                Loading
                            </div>
                        </div>
                    </div></div>

                <div class="modal fade" id="addNewInventoryModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Add New Inventory</h4>
                            </div>
                            <div class="modal-body">
                                <div class="row" id = "progressBarOverviewModalAdd" hidden="true">
                                    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped active" role="progressbar"
                                                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                                                Please Wait...
                                            </div>
                                        </div>
                                    </div></div>
                                <div id ="updateStatusAdd"></div>
                                <form id="addForm" class="form-horizontal" hidden="true">

                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <select id="addQuality" class="form-control">
                                                <option value ="mint" selected="selected">Mint</option>
                                                <option value ="good">Good</option>
                                                <option value ="fair">Fair</option>
                                                <option value ="poor">Poor</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <input id="addQuantity" type="number" min="1" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <input id="addPrice" type="number" min="1" class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                        <jsp:include page="albumList.jsp"></jsp:include>
                                    </div></div>     
                            </form>
                        </div>
                        <div class="modal-footer">
                            <button id="closeAddButton" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button id="confirmAddNewInventory" type="button" class="btn btn-primary">Add Inventory</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <input type="hidden" id="albumID"></input>

    </body>
    <script>
        $(document).ready(function () {
            $('li.active').removeClass('active');
            $('#inventoryTab').addClass('active');
            $('#inventoryForm').hide();
            $('#page-wrap').hide();
            $('#progressBarOverview').hide();
            console.log('loaded inventory.jsp');
            $('#inventoryForm').fadeIn("slow");
            $('#mainContent').css('display', 'block');

            $('#addQuality').on('change', function () {
                qualityText = $(this).val();
                console.log('quality selected is ' + qualityText);
            });

        });

        $('#albumList').on('change', function () {
            albumID = $(this).val();
            $('#albumID').val(albumID);
            console.log('album id selected is ' + albumID);
        });

        $('#search').click(function () {
            $('#progressBarOverview').show();

            console.log("search button clicked!");
            sku = $('#sku').val();
            title = $('#title').val();

            $.ajax({
                type: "POST",
                url: "QueryInventory",
                data: {sku: sku, title: title},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#progressBarOverview').hide();
                    $('#page-wrap').html(data);
                    $('#page-wrap').fadeIn("slow", function () {
                        $(this).show();

                    });
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#progressBarOverview').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                }

            });
        });

        $('#addNewInventory').click(function () {

            $('#progressBarOverviewModalAdd').show();
            $('#addQuantity').attr('placeholder', "Quantity");
            $('#addQuantity').val(1);
            $('#addPrice').attr('placeholder', "Price");

            console.log('add new inventory button clicked!');

            $.ajax({
                type: "POST",
                url: "QueryAlbum",
                data: {},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#progressBarOverviewModalAdd').hide();
                    $('#albumList').html(data);
                    $('#addForm').show();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#progressBarOverviewModalAdd').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                }

            });

        });

        $('#confirmAddNewInventory').click(function () {
            console.log('Default album id = ' + $('#option_0').val());

            $('#progressBarOverviewModalAdd').show();
            $('#addForm').hide();
            albumID = $('#albumID').val();
            if (typeof albumID === 'undefined' || albumID === '')
            {
                albumID = $('#option_0').val();
            }
            console.log('album ID = ' + albumID);
            quality = $('#addQuality').val();
            quantity = $('#addQuantity').val();
            if (quantity === '')
            {
                quantity = 1;
            }
            price = $('#addPrice').val();
            if (price === '')
            {
                price = 0;
            }

            $.ajax({
                type: "POST",
                url: "QueryInventory",
                data: {add: true, quality: quality, quantity: quantity, price: price, albumID: albumID},
                cache: false,
                datatype: "application/json",
                success: function (data, textStatus, request) {
                    $('#progressBarOverviewModalAdd').hide();
                    $('#updateStatusAdd').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Success!</strong> New Request added </div>');

                    $('#addForm').show();
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    $('#progressBarOverviewModalAdd').hide();
                    console.log(xhr.status);
                    console.log(thrownError);
                    $('#addForm').show();

                }

            });
        });



    </script>
</html>
