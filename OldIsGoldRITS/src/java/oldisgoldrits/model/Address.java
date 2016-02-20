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
public class Address {
    
    private String street;
    private String city;
    private String state;
    private int zipcode;
    
    public Address() {
        
    }
    
    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    public void setAddress(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
    
    @Override
    public String toString(){
        String output;
        output = this.street + " " + this.city + " " + this.state + " " + String.valueOf(this.zipcode);
        return output;
    }

}
