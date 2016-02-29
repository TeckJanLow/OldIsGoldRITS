/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Login authenticator for the application
 * @author madan parameswaran
 */
public class EmployeeAuthenticator {
    private final String salt;

    /**
     * This method returns the salt used to encrypt the password
     * @return the encryption salt
     */
    private String getSalt() {
        return salt;
    }

    /**
     * This is the constructor of the employee authenticator class
     */
    public EmployeeAuthenticator() {
        this.salt = saltShaker();
    }
    
    /**
     * This method returns a valid employee id number as a String if authenticated correctly
     * @param user String denoting the username of the login
     * @param pass String for the password
     * @return logged in employee ID
     */
    public static String login(String user, String pass)
    {
        Logger log = Logger.getLogger("EmployeeAuthenticator");
        try {
            DatabaseConnector dbc = new DatabaseConnector();
            Integer result = -1;
            try (Connection conn = dbc.connect()) {
                String salt = new EmployeeAuthenticator().getSalt();
                
                String query = "SELECT emp_id from bongo_records.EMPLOYEE WHERE email = '"+user+"' and pass=aes_encrypt('"+pass+"','"+salt+"')";
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                {
                    result = rs.getInt("emp_id");
                }
                
            }
            return result.toString();
            
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * This method returns the salt used for the encryption
     * @return the encryption salt
     */
    
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
            prop.load(input);
        }
        catch(Exception ex)
        {
            Logger.getLogger(getClass().getSimpleName()).severe(ex.getMessage());
        }
        Logger log = Logger.getLogger("EmployeeAuthenticator");
        return prop.getProperty("partial_salt");
    }
    
}
