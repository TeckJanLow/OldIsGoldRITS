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
public class QueryHandler {
    
    /**
     * 
     * @param condition
     * @return
     * @throws SQLException 
     */
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
            query += "WHERE " + condition;
        }
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }
    
    /**
     * 
     * @param condition
     * @return
     * @throws SQLException 
     */
    public ResultSet queryInventory(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT INVENTORY.*, ALBUM.title, ALBUM.artist, "
                + "ALBUM.genre, ALBUM.comments FROM INVENTORY LEFT JOIN ALBUM "
                + "ON INVENTORY.album_id = ALBUM.album_id";
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
     * @param title
     * @param artist
     * @param genre
     * @param comments
     * @throws SQLException 
     */
    public void addNewRecord(String title, String artist, String genre, 
            String comments) throws SQLException{
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO ALBUM (title, artist, genre, comments)"
                + "VALUES (" + title + ", " + artist + ", " + genre + ", " 
                + comments + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    /**
     * 
     * @param firstName
     * @param lastName
     * @param phone
     * @param email
     * @param street
     * @param city
     * @param state
     * @param zipcode
     * @param prefCommunication
     * @param isSubscribedMailingList
     * @throws SQLException 
     */
    public void addNewCustomer(String firstName, String lastName, int phone, 
            String email, String street, String city, String state, int zipcode, 
            String prefCommunication, boolean isSubscribedMailingList) 
            throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO CUSTOMER (first_name, last_name, phone, "
                + "email, street, city, state, zip, preferred_mode, "
                + "is_subscribed) VALUES (" + firstName + ", " + lastName + ", " 
                + phone + ", " + email + ", " + street + ", " + city + ", " 
                + state + ", " + zipcode + ", " + prefCommunication + ", " 
                + isSubscribedMailingList + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    /**
     * 
     * @param quality
     * @param quantityOnHand
     * @param price
     * @throws SQLException 
     */
    public void addNewInventory(String quality, int quantityOnHand, long price) 
            throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO INVENTORY (quality, quantity, price) VALUES"
                + " (" + quality + ", " + quantityOnHand + ", " + price + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void editCustomer(int customerID, String firstName, String lastName,
            int phone, String email, String street, String city, String state,
            int zipcode, String prefCommunication,
            boolean isSubscribedMailingList) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE CUSTOMER SET first_name = '" + firstName + "', "
                + "last_name = '" + lastName + "', phone = '" + phone + "', "
                + "email = '" + email + "', street = '" + street + "', city = '" 
                + city + "', state = '" + state + "', zip = '" + zipcode + "', "
                + "preferred_mode = '" + prefCommunication + "', is_subscribed "
                + "= '" + isSubscribedMailingList + "' WHERE cust_id = '" 
                + customerID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void editRecord(int recordID, String comments) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE ALBUM SET comments = '" + comments + "' "
                + "WHERE album_id = '" + recordID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
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
    
    public void editInventory(int inventoryID, String quality, String quantity, 
            long price) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE INVENTORY SET quality = '" + quality + "', "
                + "quantity = '" + quantity + "', price = '" + price + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
}
