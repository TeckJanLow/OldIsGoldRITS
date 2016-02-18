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
public class Person {
    
    String firstName;
    String lastName;
    int phone;
    String email;
    Address address;
    
    public Person(String firstName, String lastName, int phone, String email, String street, String city, String state, int zipcode) {
        this.firstName = firstName;
    }
    
}
