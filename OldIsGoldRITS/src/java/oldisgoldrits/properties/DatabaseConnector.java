/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.properties;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 *
 * @author madan
 */
public class DatabaseConnector {
    
    public Connection connect()
    {
        Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
        
    		String filename = "config.properties";
    		

    		//load a properties file from class path, inside static method
    		prop.load(input);
 
                //get the property value and print it out
                System.out.println(prop.getProperty("database"));
    	        System.out.println(prop.getProperty("dbuser"));
    	        System.out.println(prop.getProperty("dbpassword"));
 
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    }
}
