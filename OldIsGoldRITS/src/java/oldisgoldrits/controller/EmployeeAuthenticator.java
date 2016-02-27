/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author madan
 */
public class EmployeeAuthenticator {
    
    public static String login(String user, String pass)
    {
        try {
            DatabaseConnector dbc = new DatabaseConnector();
            Integer result;
            try (Connection conn = dbc.connect()) {
                String salt = new EmployeeAuthenticator().saltShaker();
                String query = "SELECT emp_id from EMPLOYEE WHERE email = '"+user+"' and pass=aes_encrypt('"+pass+"','"+salt+"')";
                Statement st = conn.createStatement();
                result = st.executeUpdate(query);
            }
            return result.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private String saltShaker()
    {
        Properties prop = new Properties();
        String filename = "config.properties";
        try{    
            InputStream input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                  return null;
            }
        }
        catch(Exception ex)
        {
            Logger.getLogger(getClass().getSimpleName()).severe(ex.getMessage());
        }
        
         return prop.getProperty("partial_salt");
    }
    
}
