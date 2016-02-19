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
import java.util.logging.Logger;

/**
 *
 * @author madan
 */
public class DatabaseConnector {
    
    public void connect()
    {
        Properties prop = new Properties();
    	InputStream input = null;
    	
    	try {
         
    		String filename = "/config.properties";
    		input = getClass().getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            System.out.println("Sorry, unable to find " + filename);
    		  //  return null;
    		}

    		//load a properties file from class path, inside static method
    		prop.load(input);
                Logger log = Logger.getLogger(getClass().getSimpleName());
                //get the property value and print it out
                log.info(prop.getProperty("database"));
    	        log.info(prop.getProperty("user"));
    	        log.info(prop.getProperty("pass"));
 
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
