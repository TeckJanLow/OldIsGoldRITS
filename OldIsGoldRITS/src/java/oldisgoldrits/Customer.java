/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits;

/**
 *
 * @author Teck Jan Low
 */
public class Customer extends Person {
    
    private enum PrefCommunication {
        phone, email
    }
    private PrefCommunication prefCommunication;
    private boolean isSubscribedMailingList;
    
    public Customer(String firstName, String lastName, int phone, String email, String street, String city, String state, int zipcode, PrefCommunication prefCommunication, boolean isSubscribedMailingList) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.prefCommunication = prefCommunication;
        this.isSubscribedMailingList = isSubscribedMailingList;
    }
    
    

}
