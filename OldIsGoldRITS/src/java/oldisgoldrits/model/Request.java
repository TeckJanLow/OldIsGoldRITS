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
 *
 * @author Teck Jan Low
 */
public class Request {

    /**
     *
     */
    private int requestID;
    /**
     *
     */
    private int customerID;
    /**
     *
     */
    private int employeeID;
    /**
     *
     */
    private String description;
    /**
     *
     */
    private Date date;
    /**
     *
     */
    private int quantity;
    /**
     *
     */
    private boolean isComplete;
    /**
     *
     */
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Request() {

    }

    /**
     *
     * @param requestID
     * @param customerID
     * @param employeeID
     * @param description
     * @param date
     * @param quantity
     * @param isComplete
     * @throws ParseException
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
     *
     * @return
     */
    public int getRequestID() {
        return requestID;
    }

    /**
     *
     * @param requestID
     */
    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    /**
     *
     * @return
     */
    public int getCustomerID() {
        return customerID;
    }

    /**
     *
     * @param customerID
     */
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    /**
     *
     * @return
     */
    public int getEmployeeID() {
        return employeeID;
    }

    /**
     *
     * @param employeeID
     */
    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public boolean isIsComplete() {
        return isComplete;
    }

    /**
     *
     * @param isComplete
     */
    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    /**
     *
     * @return
     */
    public SimpleDateFormat getSdf() {
        return sdf;
    }

    /**
     *
     * @param sdf
     */
    public void setSdf(SimpleDateFormat sdf) {
        this.sdf = sdf;
    }

}
