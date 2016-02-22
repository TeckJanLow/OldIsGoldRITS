/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oldisgoldrits.model.Customer;
import oldisgoldrits.model.Employee;
import oldisgoldrits.model.Inventory;
import oldisgoldrits.model.RequestTable;
import oldisgoldrits.model.Request;

/**
 *
 * @author Teck Jan Low
 */
public class RequestParser {
    
    public ArrayList<RequestTable> parse (ResultSet rs) throws SQLException {
        
        ArrayList<RequestTable> requestList = new ArrayList();
        
        while (rs.next()) {
            int requestID = rs.getInt("request_id");
            int customerID = rs.getInt("cust_id");
            int employeeID = rs.getInt("emp_id");
            String description = rs.getString("description");
            String date = rs.getString("date");
            int quantity = rs.getInt("quantity");
            boolean isComplete = rs.getBoolean("status");
            String customerFirst = rs.getString("cust_first");
            String customerLast = rs.getString("cust_last");
            int phone = rs.getInt("phone");
            String email = rs.getString("email");
            String prefCommunication = rs.getString("preferred_mode");
            String employeeFirst = rs.getString("emp_first");
            String employeeLast = rs.getString("emp_last");
            
            Request rq = new Request(requestID, customerID, employeeID, description, date, quantity, isComplete);
            Customer cust = new Customer();
            cust.setFirstName(customerFirst);
            cust.setLastName(customerLast);
            cust.setPhone(phone);
            cust.setEmail(email);
            cust.setPrefCommunication(prefCommunication);
            Employee emp = new Employee();
            emp.setFirstName(employeeFirst);
            emp.setLastName(employeeLast);
            
            RequestTable rt = new RequestTable(rq, cust, emp);
            requestList.add(rt);
        }
        
        return requestList;
        
    }
    
    
        public ArrayList<Customer> parseCustomer (ResultSet rs) throws SQLException {
        
        ArrayList<Customer> requestList = new ArrayList();
        
        while (rs.next()) {
            
            int customerID = rs.getInt("cust_id");
      
            String customerFirst = rs.getString("first_name");
            String customerLast = rs.getString("last_name");
           
            
            Customer customer = new Customer();
            customer.setFirstName(customerFirst);
            customer.setLastName(customerLast);
            customer.setId(customerID);
            
            requestList.add(customer);
        }
        
        return requestList;
        
    }

}
