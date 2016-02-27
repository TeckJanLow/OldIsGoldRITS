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


        </div>

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
                    console.log("data = " + data);
                    console.log("request = " + request);
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

            $('#customerList').on('change', function () {
                console.log($(this).val());
                $('#customerID').val($(this).val());
                console.log('customer id ' + $('customerID').val());
            });

            $('#addNewRequest').click(function () {

                $('#progressBarOverviewModalAdd').show();

                console.log('add new request button clicked!');
                $.ajax({
                    type: "POST",
                    url: "QueryPerson",
                    data: {},
                    cache: false,
                    datatype: "application/json",
                    success: function (data, textStatus, request) {
                        $('#progressBarOverviewModalAdd').hide();
                        $('#customerList').html(data);
                        $('#addForm').show();
                        console.log(data);

                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        $('#progressBarOverviewModalAdd').hide();
                        console.log(xhr.status);
                        console.log(thrownError);
                    }

                });

            });

            $('#confirmAddNewRequest').click(function () {
                $('#progressBarOverviewModalAdd').show();
                customerID = $('#customerID').val();
                description = $('#addDescription').val();
                if (description === '')
                {
                    alert('Please enter a description!');
                }
                quantity = $('#addQuantity').val();
                if (quantity === '')
                {
                    quantity = 1;
                }
                status = $('#addStatusCheck').is(':checked');
                requestDate = moment().format('YYYY-MM-DD');
                $.ajax({
                    type: "POST",
                    url: "QueryRequest",
                    data: {add: true, status: status, customerID: customerID, description: description, quantity: quantity, date: requestDate},
                    cache: false,
                    datatype: "application/json",
                    success: function (data, textStatus, request) {
                        $('#progressBarOverviewModalAdd').hide();

                    },
                    error: function (xhr, ajaxOptions, thrownError) {
                        $('#progressBarOverviewModalAdd').hide();
                        console.log(xhr.status);
                        console.log(thrownError);
                    }

                });
            });
        });
    </script>
</html>
