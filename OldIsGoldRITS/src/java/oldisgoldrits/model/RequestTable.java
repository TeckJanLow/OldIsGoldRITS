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
public class RequestTable {
    
    private Request request;
    private Customer customer;
    private Employee employee;
    
    public RequestTable(Request request, Customer customer, Employee employee) {
        this.request = request;
        this.customer = customer;
        this.employee = employee;
    }

    public Request getRequest() {
        return request;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public Employee getEmployee() {
        return employee;
    }

}
