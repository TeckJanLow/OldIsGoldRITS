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
import oldisgoldrits.model.Customer;
import org.jboss.logging.Logger;

/**
 * Contains all methods involving the creation and manipulation of customers.
 * @author Teck Jan Low
 * @version 1.0
 */
public class CustomerHandler {

   /**
     * Adds a new customer to the database.
     * @param firstName The customer's first name
     * @param lastName The customer's last name
     * @param phone The customer's phone number
     * @param email The customer's email address
     * @param street The customer's street address
     * @param city The customer's city of residence
     * @param state The customer's state of residence
     * @param zipcode The customer's zip code
     * @param prefCommunication The customer's preferred method of communication
     * @param isSubscribedMailingList Subscription status to the mailing list
     * @throws SQLException an sqlException
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
     * Edits customer information on the database.
     * @param customerID The ID of the customer to be edited
     * @param firstName The new customer first name
     * @param lastName The new customer last name
     * @param phone The new customer phone number
     * @param email The new customer email address
     * @param street The new customer street address
     * @param city The new customer city of residence
     * @param state The new customer state of residence
     * @param zipcode The new customer zip code
     * @param prefCommunication The new customer preferred method of communication
     * @param isSubscribedMailingList The new customer mailing list subscription status
     * @throws SQLException an sqlException
     */
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
    
    /**
     * Deletes a customer from the database.
     * @param customerID The ID of the customer to be deleted
     * @throws SQLException an sqlException
     */
    public void deleteCustomer(int customerID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM CUSTOMER WHERE cust_id = '" 
                + customerID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    /**
     * This method gets all the customers
     * @return ArrayList of customer object references
     * @throws SQLException an sqlException
     */
    public ArrayList<Customer> showAllCustomer() throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        try (Connection conn = dbc.connect()) {
            String query = "SELECT first_name, last_name, cust_id FROM CUSTOMER ORDER BY last_name ASC" ;
            
            Statement st = conn.createStatement();
            Logger log  = Logger.getLogger(getClass().getSimpleName());
            log.info(query);
            RequestParser rp = new RequestParser();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Customer> requestList = rp.parseCustomer(rs);
            rs.close();
            conn.close();
            return requestList;
        }
    }
    
}
