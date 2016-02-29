/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Defines additional characteristics of an employee
 * @author Teck Jan Low
 * @version 1.0
 */
public class Employee extends Person {

    /** 
     * Enum of job types available
     */
    private enum Job {
        Manager, Cashier
    }
    /**
     * The employee's job
     */
    private Job job;
    /**
     * The employee's monthly salary
     */
    private double salary;
    
    /**
     * no argument constructor for employee
     */
    public Employee() {
        
    }
    
    /**
     * Full constructor for employee
     * @param firstName employee first name
     * @param lastName employee last name 
     * @param phone employee phone number
     * @param email employee email address
     * @param street street of residence
     * @param city city of residence
     * @param state state of residence
     * @param zipcode zip code of residence
     * @param job job title
     * @param salary monthly salary
     */
    public Employee(String firstName, String lastName, int phone, 
            String email, String street, String city, String state, 
            int zipcode, String job, double salary) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.job = Job.valueOf(job);
        this.salary = salary;
    }

    /**
     * Getter for job title
     * @return job title
     */
    public String getJob() {
        String job = this.job.toString();
        return job;
    }

    /**
     * Setter for job title
     * @param job new job title
     */
    public void setJob(String job) {
        this.job = Job.valueOf(job);
    }

    /**
     * Getter for monthly salary
     * @return Monthly salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Setter for monthly salary
     * @param salary new monthly salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }
     
}