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
public class Employee extends Person {

    private enum Job {
        Manager, Cashier
    }
    private Job job;
    private long salary;
    
    public Employee(String firstName, String lastName, int phone, String email, String street, String city, String state, int zipcode, Job job, long salary) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.job = job;
        this.salary = salary;
    }
    
}
