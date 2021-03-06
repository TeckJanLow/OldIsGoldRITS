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
import org.jboss.logging.Logger;

/**
 * Contains all methods involving the creation and manipulation of customer requests.
 * @author Teck Jan Low
 * @version 1.0
 */
public class RequestHandler {
    
    /**
     * Retrieves all request information from the database.
     * @return ResultSet containing all request information from the database
     * @throws SQLException an sqlException
     */
    public ArrayList<RequestTable> getRequest() throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT REQUEST.*, CUSTOMER.first_name cust_first, "
                + "CUSTOMER.last_name cust_last, CUSTOMER.phone, CUSTOMER.email,"
                + " CUSTOMER.preferred_mode, EMPLOYEE.first_name emp_first, "
                + "EMPLOYEE.last_name emp_last FROM REQUEST LEFT JOIN EMPLOYEE "
                + "ON REQUEST.emp_id = EMPLOYEE.emp_id LEFT JOIN CUSTOMER ON"
                + " REQUEST.cust_id = CUSTOMER.cust_id order by request_id desc";
        Statement st = conn.createStatement();
        Logger log  = Logger.getLogger(getClass().getSimpleName());
        log.info(query);
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
     * @throws SQLException an sqlException
     */
    public ArrayList<RequestTable> getRequest(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT REQUEST.*, CUSTOMER.first_name cust_first, "
                + "CUSTOMER.last_name cust_last, CUSTOMER.phone, CUSTOMER.email,"
                + " CUSTOMER.preferred_mode, EMPLOYEE.first_name emp_first, "
                + " EMPLOYEE.last_name emp_last FROM REQUEST LEFT JOIN EMPLOYEE "
                + " ON REQUEST.emp_id = EMPLOYEE.emp_id LEFT JOIN CUSTOMER ON"
                + " REQUEST.cust_id = CUSTOMER.cust_id WHERE " + condition ;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
       
        RequestParser rp = new RequestParser();
        
        ArrayList<RequestTable> requestList = rp.parse(rs);
        rs.close();
        conn.close();
        return requestList;
    }

    /**
     * Adds a new request into the database.
     * @param customerID The request customer ID
     * @param employeeID The employee ID associated with the request
     * @param description The description of the request
     * @param date The date the request was made
     * @param quantity The quantity requested
     * @param isComplete The fulfillment status of the request
     * @throws SQLException an sqlException
     */
    public void addNewRequest(int customerID, int employeeID, String description
            , String date, int quantity, boolean isComplete) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO REQUEST (cust_id, emp_id, description, "
                + "date, quantity, status) VALUES (" + customerID + ", " 
                + employeeID + ", \'" + description + "\', \'" + date + "\', " 
                + quantity + ", " + isComplete + ")";
        Statement st = conn.createStatement();
        Logger log = Logger.getLogger("Add New Request from Request Handler");
        log.info(query);
        st.execute(query);
        conn.close();
    }
    
    /**
     * Edits a request on the database.
     * @param requestID The ID of the request to be edited
     * @param description The new description of the request
     * @param quantity The new quantity requested
     * @param isComplete The new status of the request
     * @throws SQLException an sqlException
     */
    public void editRequest(int requestID, String description, int quantity, 
            boolean isComplete) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE REQUEST SET description = '" + description 
                + "', quantity = '" + quantity + "', status = " 
                + isComplete + " WHERE request_id = '" + requestID + "'";
        Statement st = conn.createStatement();
        Logger log  = Logger.getLogger(getClass().getSimpleName());
        log.info(query);
        st.executeUpdate(query);
        conn.close();
    }
    
    /**
     * Deletes a request from the database.
     * @param requestID The ID of the request to be deleted
     * @throws SQLException an sqlException
     */
    public void deleteRequest(int requestID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM REQUEST WHERE request_id = " 
                + requestID + "";
        Statement st = conn.createStatement();
        Logger.getLogger("Delete Request").info(query);
        st.execute(query);
        conn.close();
    }
    
}
