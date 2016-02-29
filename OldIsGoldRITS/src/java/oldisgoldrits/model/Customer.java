/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Defines additional customer characteristics
 * @author Teck Jan Low
 * @version 1.0
 */
public class Customer extends Person {
    
    /**
     * Enum of preferred communication method
     */
    private enum PrefCommunication {
        phone, email
    }
    /**
     * The customer's preferred communication method
    */
    private PrefCommunication prefCommunication;
    /**
     * Customer's mailing list subscription
     */
    private boolean isSubscribedMailingList;
    
    public Customer() {
        
    }
    
    public Customer(String firstName, String lastName, int phone, String email, 
            String street, String city, String state, int zipcode, 
            String prefCommunication, boolean isSubscribedMailingList) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.prefCommunication = PrefCommunication.valueOf(prefCommunication);
        this.isSubscribedMailingList = isSubscribedMailingList;
    }

    public String getPrefCommunication() {
        String prefCommunication = this.prefCommunication.toString();
        return prefCommunication;
    }

    public void setPrefCommunication(String prefCommunication) {
        this.prefCommunication = PrefCommunication.valueOf(prefCommunication);
    }

    public boolean isIsSubscribedMailingList() {
        return isSubscribedMailingList;
    }

    public void setIsSubscribedMailingList(boolean isSubscribedMailingList) {
        this.isSubscribedMailingList = isSubscribedMailingList;
    }
    
    

}
