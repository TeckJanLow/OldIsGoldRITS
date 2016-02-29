/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Composition of request, customer and employee objects
 * @author Teck Jan Low
 * @version 1.0
 */
public class RequestTable {
    
    /**
     * A request object
     */
    private final Request request;
    /**
     * A customer object
     */
    private final Customer customer;
    /**
     * An employee object
     */
    private final Employee employee;
    
    /**
     * Constructor for the request table
     * @param request a request object
     * @param customer a customer object
     * @param employee an employee object
     */
    public RequestTable(Request request, Customer customer, Employee employee) {
        this.request = request;
        this.customer = customer;
        this.employee = employee;
    }

    /**
     * Getter for the request object
     * @return a request object
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Getter for the customer object
     * @return a customer object
     */
    public Customer getCustomer() {
        return customer;
    }
    
    /**
     * Getter for the employee object
     * @return the employee object
     */
    public Employee getEmployee() {
        return employee;
    }

}
