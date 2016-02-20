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
import javax.sql.DataSource;

/**
 *
 * @author Teck Jan Low
 */
public class QueryHandler {

    
    
    public ResultSet queryRequest(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT REQUEST.*, CUSTOMER.first_name cust_first, "
                + "CUSTOMER.last_name cust_last, CUSTOMER.phone, CUSTOMER.email,"
                + " CUSTOMER.preferred_mode, EMPLOYEE.first_name emp_first, "
                + "EMPLOYEE.last_name emp_last FROM REQUEST LEFT JOIN EMPLOYEE "
                + "ON REQUEST.emp_id = EMPLOYEE.emp_id LEFT JOIN CUSTOMER ON"
                + "REQUEST.cust_id = CUSTOMER.cust_id";
        if (!condition.isEmpty()) {
            query += "WHERE " + condition + ";";
        } else {
            query += ";";
        }
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }
    
    public ResultSet queryInventory(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT INVENTORY.*, ALBUM.title, ALBUM.artist, "
                + "ALBUM.genre, ALBUM.comments FROM INVENTORY LEFT JOIN ALBUM "
                + "ON INVENTORY.album_id = ALBUM.album_id";
        if (!condition.isEmpty()) {
            query += "WHERE " + condition + ";";
        } else {
            query += ";";
        }
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }
    
    public void addNewRequest(int customerID, int employeeID, String description
            , String date, int quantity, boolean isComplete) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO REQUEST (cust_id, emp_id, description, "
                + "date, quantity, status) VALUES (" + customerID + ", " 
                + employeeID + ", " + description + ", " + date + ", " 
                + quantity + ", " + isComplete + ");";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void addNewInventory(String title, String artist, String genre, 
            String comments) throws SQLException{
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO INVENTORY (title, artist, genre, comments)"
                + "VALUES (" + title + ", " + artist + ", " + genre + ", " 
                + comments + ");";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    
}
