/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.model;

import java.sql.SQLException;
import oldisgoldrits.controller.QueryHandler;

/**
 *
 * @author Teck Jan Low
 */
public class CustomerHandler {

    public void createNewCustomer(String firstName, String lastName,
            int phone, String email, String street, String city, String state,
            int zipcode, String prefCommunication,
            boolean isSubscribedMailingList) {
        
        QueryHandler qh = new QueryHandler();
        try {
            qh.addNewCustomer(firstName, lastName, phone, email, street, city,
                    state, zipcode, prefCommunication, isSubscribedMailingList);
        } catch (SQLException sql) {
            // EXCEPTION HANDLING HERE
        }
        
    }

    public void editCustomer(int customerID, String firstName, String lastName,
            int phone, String email, String street, String city, String state,
            int zipcode, String prefCommunication,
            boolean isSubscribedMailingList) {

        QueryHandler qh = new QueryHandler();
        try {
            qh.editCustomer(customerID, firstName, lastName, phone, email, street, city,
                    state, zipcode, prefCommunication, isSubscribedMailingList);
        } catch (SQLException sql) {
            // EXCEPTION HANDLING HERE
        }
    }

}
