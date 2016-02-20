/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Teck Jan Low
 */
public class CustomerHandler {

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
    
    public void deleteCustomer(int customerID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM CUSTOMER WHERE cust_id = '" 
                + customerID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }

}
