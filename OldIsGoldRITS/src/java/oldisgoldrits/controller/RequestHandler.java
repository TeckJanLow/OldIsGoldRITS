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

/**
 *
 * @author Teck Jan Low
 */
public class RequestHandler {
    
    /**
     * This method queries the database for information regarding requests and 
     * their associated customers and employees.
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
                + "REQUEST.cust_id = CUSTOMER.cust_id";
        if (!condition.isEmpty()) {
            query += "WHERE " + condition;
        }
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }

    /**
     * 
     * @param customerID
     * @param employeeID
     * @param description
     * @param date
     * @param quantity
     * @param isComplete
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
     * 
     * @param requestID
     * @param description
     * @param quantity
     * @param isComplete
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
