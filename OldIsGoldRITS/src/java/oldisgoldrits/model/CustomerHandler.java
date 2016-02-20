/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.model;

/**
 *
 * @author Teck Jan Low
 */
public class CustomerHandler {

    public void createNewCustomer(String firstName, String lastName,
            int phone, String email, String street, String city, String state,
            int zipcode, String prefCommunication,
            boolean isSubscribedMailingList) {
        Customer customer = new Customer(firstName, lastName, phone, email,
                street, city, state, zipcode, prefCommunication, 
                isSubscribedMailingList);
        // ADD CUSTOMER TO DATABASE
    }

    public void editCustomer() {
        
    }

}
