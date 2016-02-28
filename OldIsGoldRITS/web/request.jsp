<%-- 
    Document   : request
    Created on : Feb 19, 2016, 5:09:33 PM
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
        <title>Request Manager</title>


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
                <div id="requestForm" class = "row" style="margin-top:50px">
                    <div class="col-md-12 col-md-offset-4">
                        <form class="form-inline">
                            <div class="form-group">

                                <div class="btn-group">
                                    <button id="btnStatus" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Select Status <span class="caret"></span>
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Pending</a></li>
                                        <li><a href="#">Completed</a></li>
                                        <li role="separator" class="divider"></li>
                                        <li><a href="#">Show All</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="albumTitle">Title</label>
                                <input type="text" class="form-control" id="title" placeholder="Description">
                            </div>

                            <a id="search" class="btn btn-default" >
                                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                                Search
                            </a>
                            <a id="addNewRequest" data-toggle="modal" data-target="#addNewRequestModal" class="btn btn-primary col-md-offset-2" >
                                <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                Add New Request
                            </a>
                        </form>
                    </div>
                </div>
                <div class="row" id = "progressBarOverview">
                    <div class="col-md-6 col-md-offset-3" style="margin-top: 50px">
                        <div class="progress">
                            <div class="progress-bar progress-bar-striped active" role="progressbar"
                                 aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width:100%">
                                Loading
                            </div>
                        </div>
                    </div></div>
                <jsp:include page="requestTable.jsp"></jsp:include>

                <div class="modal fade" id="addNewRequestModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="myModalLabel">Add New Request</h4>
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
                                            <input type="text" class="form-control" id="addDescription" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                            <input id="addQuantity" type="number" min="1" class="form-control" id="quantity" >
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-10 col-sm-offset-1">
                                        <jsp:include page="customerList.jsp"></jsp:include>
                                        </div></div>     
                                    <div class="checkbox col-sm-offset-1">
                                        <label>
                                            <input type="checkbox" id="addStatusCheck"> Completed
                                        </label>
                                    </div>


                                </form>
                            </div>
                            <div class="modal-footer">
                                <button id="closeAddButton" type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                <button id="confirmAddNewRequest" type="button" class="btn btn-primary">Add Request</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <input type="hidden" id="customerID"></input>
        </body>

        <script>

            $(document).ready(function () {

                $('li.active').removeClass('active');
                $('#requestTab').addClass('active');
                $('#requestForm').hide();
                $('#page-wrap').hide();
                $('#progressBarOverview').hide();
                console.log('loaded request.jsp');
                $('#requestForm').fadeIn("slow");
                $('#mainContent').css('display', 'block');
                statusText = '';

                $('.dropdown-menu a').click(function (e) {
                    $('#btnStatus').html(this.innerHTML + ' <span class="caret"></span>');
                    statusText = this.innerHTML;
                });

                $('#closeAddButton').click(function (event) {
                    $('#search').trigger('click');
                    $('#updateStatusAdd').html('');
                });

                $('#search').click(function () {
                    console.log('search clicked');
                    $('#page-wrap').hide();
                    $('#progressBarOverview').show();
                    status = '';
                    if (statusText === 'Completed')
                    {
                        status = true;
                    }
                    else if (statusText === 'Pending')
                    {
                        status = false;
                    }
                    else
                    {
                        status = '';
                    }

                    console.log('status =' + status);

                    title = $('#title').val();

                    $.ajax({
                        type: "POST",
                        url: "QueryRequest",
                        data: {status: status, title: title},
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
                $('#customerList').on('change', function () {
                    customerID = $(this).val();
                    $('#customerID').val(customerID);
                    console.log('customer id ' + customerID);
                });

                $('#addNewRequest').click(function () {

                    $('#progressBarOverviewModalAdd').show();
                    $('#addDescription').attr('placeholder', "Description");
                    $('#addQuantity').attr('placeholder', "Quantity");
                    $('#addQuantity').val(1);
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
                    console.log('Default customer id = ' + $('#option_0').val());


                    $('#progressBarOverviewModalAdd').show();
                    $('#addForm').hide();
                    customerID = $('#customerID').val();
                    if (typeof customerID === 'undefined' || customerID === '')
                    {

                        customerID = $('#option_0').val();
                    }
                    employeeID = "${empId}";
                    console.log('Employee ID = ' + employeeID + ' Customer ID = ' + customerID);
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
                        data: {add: true, status: status, customerID: customerID, employeeID: employeeID, description: description, quantity: quantity, date: requestDate},
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
            });












    </script>
</html>
