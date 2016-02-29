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
    
    /**
     * No argument constructor for customer
     */
    public Customer() {
        
    }
    
    /**
     * Full constructor for customer
     * @param firstName The customer first name
     * @param lastName The customer last name
     * @param phone Phone number
     * @param email Email address
     * @param street Street of residence
     * @param city City of residence
     * @param state State of residence
     * @param zipcode Zip code
     * @param prefCommunication Preferred method of communication
     * @param isSubscribedMailingList Subscription status to mailing list
     */
    public Customer(String firstName, String lastName, int phone, String email, 
            String street, String city, String state, int zipcode, 
            String prefCommunication, boolean isSubscribedMailingList) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.prefCommunication = PrefCommunication.valueOf(prefCommunication);
        this.isSubscribedMailingList = isSubscribedMailingList;
    }

    /**
     * Getter for preferred method of communication
     * @return The preferred method of communication
     */
    public String getPrefCommunication() {
        String prefCommunication = this.prefCommunication.toString();
        return prefCommunication;
    }

    /**
     * Setter for the preferred method of communication 
     * @param prefCommunication The new preferred method of communication
     */
    public void setPrefCommunication(String prefCommunication) {
        this.prefCommunication = PrefCommunication.valueOf(prefCommunication);
    }

    /**
     * Getter for mailing list subscription 
     * @return mailing list subscription status
     */
    public boolean getIsSubscribedMailingList() {
        return isSubscribedMailingList;
    }
    
    /**
     * Setter for mailing list subscription 
     * @param isSubscribedMailingList New subscription status
     */
    public void setIsSubscribedMailingList(boolean isSubscribedMailingList) {
        this.isSubscribedMailingList = isSubscribedMailingList;
    }
    
}
