/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Defines customer requests
 * @author Teck Jan Low
 * @version 1.0
 */
public class Request {

    /**
     * the request id
     */
    private int requestID;
    /**
     * the id of the customer that placed the request
     */
    private int customerID;
    /**
     * the id of the employee that logged the request
     */
    private int employeeID;
    /**
     * the description of the request
     */
    private String description;
    /**
     * the date the request was logged
     */
    private Date date;
    /**
     * the quantity of albums requested
     */
    private int quantity;
    /**
     * the status of the request
     */
    private boolean isComplete;
    /**
     * simple date format to standardize the date format
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * no argument constructor for request objects
     */
    public Request() {

    }

    /**
     * full constructor for request objects
     * @param requestID the request id
     * @param customerID the customer id
     * @param employeeID the employee id
     * @param description the request description
     * @param date the date of request
     * @param quantity the quantity of albums requested
     * @param isComplete the status of the request
     */
    public Request(int requestID, int customerID, int employeeID,
            String description, String date, int quantity, boolean isComplete) {
        this.requestID = requestID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.description = description;
        try {
            Date parsedDate = sdf.parse(date);
            this.date = parsedDate;
        } catch (ParseException pe) {
            // EXCEPTION HANDLER HERE
        }
        this.quantity = quantity;
        this.isComplete = isComplete;
    }

    /**
     * Getter for request id
     * @return the request id
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     * Setter for request ID
     * @param requestID the new request id
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     * Getter for the customer id 
     * @return the customer id
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     * Setter for the customer id
     * @param customerID the new customer id
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     * Getter for employee id
     * @return the employee id
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     * Setter for employee id
     * @param employeeID the new employee id
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * Getter for the request description 
     * @return the request description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for the request description
     * @param description the new request description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for the date 
     * @return the date of the request
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for the request date
     * @param date the new request date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for quantity
     * @return quantity ordered
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity ordered
     * @param quantity the new quantity ordered
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for the request status 
     * @return the request status
     */
    public boolean isIsComplete() {
        return isComplete;
    }

    /**
     * Setter for request status
     * @param isComplete the new request status
     */
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     * Getter for the date format
     * @return the date format
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     * Setter for the date format
     * @param sdf the new date format
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

}