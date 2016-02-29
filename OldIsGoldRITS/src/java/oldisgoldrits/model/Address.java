/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Contains address information for person objects
 * @author Teck Jan Low
 * @version 1.0
 */
public class Address {
    
    /**
     * Street name
     */
    private String street;
    /**
     * City of residence
     */
    private String city;
    /**
     * State of residence
     */
    private String state;
    /**
     * Zip code of residence
     */
    private int zipcode;
    
    /**
     * No argument constructor for address
     */
    public Address() {
        
    }
    
    /**
     * Full constructor for address
     * @param street The street name
     * @param city The city name
     * @param state The state name
     * @param zipcode The zip code
     */
    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    /**
     * Setter for address
     * @param street The new street name
     * @param city The new city name
     * @param state The new state name 
     * @param zipcode The new zip code
     */
    public void setAddress(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    /**
     * Creates a string containing the full customer address
     * @return The address string
     */
    @Override
    public String toString(){
        String output;
        output = this.street + " " + this.city + " " + this.state + " " + String.valueOf(this.zipcode);
        return output;
    }

}
