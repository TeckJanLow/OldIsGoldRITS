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
public class Customer extends Person {
    
    private enum PrefCommunication {
        phone, email
    }
    private PrefCommunication prefCommunication;
    private boolean isSubscribedMailingList;
    
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
