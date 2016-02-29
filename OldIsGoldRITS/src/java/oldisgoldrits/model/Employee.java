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
    
    public Employee() {
        
    }
    
    public Employee(String firstName, String lastName, int phone, 
            String email, String street, String city, String state, 
            int zipcode, String job, double salary) {
        super(firstName, lastName, phone, email, street, city, state, zipcode);
        this.job = Job.valueOf(job);
        this.salary = salary;
    }

    public String getJob() {
        String job = this.job.toString();
        return job;
    }

    public void setJob(String job) {
        this.job = Job.valueOf(job);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    
}
