/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Defines the person object for inheritance
 * @author Teck Jan Low
 */
public class Person {
    
    /**
     * First name of person
     */
    String firstName;
    /**
     * Last name of person
     */
    String lastName;
    /**
     * Person's phone number
     */
    int phone;
    /**
     * Person's email address
     */
    String email;
    /**
     * Address of person
     */
    Address address;
    /**
     * Person's ID number
     */
    int id;
    
    /**
     * Blank constructor for person
     */
    public Person() {
        
    }
    
    /**
     * Full constructor for person objects
     * @param firstName First name
     * @param lastName Last name
     * @param phone Phone number
     * @param email Email address
     * @param street Street name
     * @param city City of residence
     * @param state State of residence
     * @param zipcode Zip code of residence
     */
    public Person(String firstName, String lastName, int phone, String email, 
            String street, String city, String state, int zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = new Address(street, city, state, zipcode);
    }

    /**
     * Getter for first name
     * @return First name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter for first name
     * @param firstName New first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter for last name
     * @return Last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter for last name
     * @param lastName New last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter for phone number
     * @return Phone number
     */
    public int getPhone() {
        return phone;
    }

    /** 
     * Setter for phone number
     * @param phone new phone number
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     * Getter for email address
     * @return Email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter for email address
     * @param email new Email address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for residential address
     * @return Residential address object
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Setter for residential address
     * @param address new residential address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Getter for ID
     * @return ID value
     */
    public int getId() {
        return id;
    }

    /**
     * Setter for ID
     * @param id new ID value
     */
    public void setId(int id) {
        this.id = id;
    }
    
}