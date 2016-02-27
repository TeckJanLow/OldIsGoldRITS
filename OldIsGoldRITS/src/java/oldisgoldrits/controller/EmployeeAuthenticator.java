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
 *
 * @author madan
 */
public class EmployeeAuthenticator {
    private final String salt;

    public String getSalt() {
        return salt;
    }

    public EmployeeAuthenticator() {
        this.salt = saltShaker();
    }
    
    
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
                log.log(Level.INFO, "Executing query: {0}", query);
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
