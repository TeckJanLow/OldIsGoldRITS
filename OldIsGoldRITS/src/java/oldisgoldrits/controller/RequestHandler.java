/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oldisgoldrits.model.RequestTable;

/**
 * Contains all methods involving the creation and manipulation of customer requests.
 * @author Teck Jan Low
 * @version 1.0
 */
public class RequestHandler {
    
    /**
     * Retrieves all request information from the database.
     * @return ResultSet containing all request information from the database
     * @throws SQLException 
     */
    public ArrayList<RequestTable> getRequest() throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT REQUEST.*, CUSTOMER.first_name cust_first, "
                + "CUSTOMER.last_name cust_last, CUSTOMER.phone, CUSTOMER.email,"
                + " CUSTOMER.preferred_mode, EMPLOYEE.first_name emp_first, "
                + "EMPLOYEE.last_name emp_last FROM REQUEST LEFT JOIN EMPLOYEE "
                + "ON REQUEST.emp_id = EMPLOYEE.emp_id LEFT JOIN CUSTOMER ON"
                + "REQUEST.cust_id = CUSTOMER.cust_id";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        RequestParser rp = new RequestParser();
        ArrayList<RequestTable> requestList = rp.parse(rs);
        rs.close();
        conn.close();
        return requestList;
    }
    
    /**
     * Retrieve information regarding requests and their associated customers and employees with a condition.
     * @param condition optional condition to reduce the number of results.
     * @return returns a ResultSet containing the data from the query.
     * @throws SQLException 
     */
    public ResultSet getRequest(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT REQUEST.*, CUSTOMER.first_name cust_first, "
                + "CUSTOMER.last_name cust_last, CUSTOMER.phone, CUSTOMER.email,"
                + " CUSTOMER.preferred_mode, EMPLOYEE.first_name emp_first, "
                + "EMPLOYEE.last_name emp_last FROM REQUEST LEFT JOIN EMPLOYEE "
                + "ON REQUEST.emp_id = EMPLOYEE.emp_id LEFT JOIN CUSTOMER ON"
                + "REQUEST.cust_id = CUSTOMER.cust_id WHERE " + condition;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }

    /**
     * Adds a new request into the database.
     * @param customerID The request customer ID
     * @param employeeID The employee ID associated with the request
     * @param description The description of the request
     * @param date The date the request was made
     * @param quantity The quantity requested
     * @param isComplete The fulfillment status of the request
     * @throws SQLException 
     */
    public void addNewRequest(int customerID, int employeeID, String description
            , String date, int quantity, boolean isComplete) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO REQUEST (cust_id, emp_id, description, "
                + "date, quantity, status) VALUES (" + customerID + ", " 
                + employeeID + ", " + description + ", " + date + ", " 
                + quantity + ", " + isComplete + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    /**
     * Edits a request on the database.
     * @param requestID The ID of the request to be edited
     * @param description The new description of the request
     * @param quantity The new quantity requested
     * @param isComplete The new status of the request
     * @throws SQLException 
     */
    public void editRequest(int requestID, String description, int quantity, 
            boolean isComplete) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE REQUEST SET description = '" + description 
                + "', quantity = '" + quantity + "', status = '" 
                + isComplete + "' WHERE request_id = '" + requestID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    /**
     * Deletes a request from the database.
     * @param requestID The ID of the request to be deleted
     * @throws SQLException 
     */
    public void deleteRequest(int requestID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM REQUEST WHERE request_id = '" 
                + requestID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
}
