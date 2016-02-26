/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author madan
 */
public class EmployeeAuthenticator {
    
    public static String login(String user, String pass)
    {
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT emp_id from EMPLOYEE WHERE email = '"+user+"' and ";
//        Statement st = conn.createStatement();
//        st.executeUpdate(query);
//        conn.close();
        
        return null;
    }
    
}
