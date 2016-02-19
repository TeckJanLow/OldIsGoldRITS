/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author madan
 */
public class DatabaseConnector {
    
    public Connection connect() {
        Properties prop = new Properties();
        InputStream input = null;
        Connection conn = null;
        try {

            String filename = "config.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input == null) {
                System.out.println("Sorry, unable to find " + filename);
                //  return null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);
            Logger log = Logger.getLogger(getClass().getSimpleName());

            
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser(prop.getProperty("user"));
            dataSource.setPassword(prop.getProperty("pass"));
            dataSource.setDatabaseName(prop.getProperty("database"));
            dataSource.setPort(Integer.valueOf(prop.getProperty("port")));
            dataSource.setServerName(prop.getProperty("url"));
            
            
            conn = dataSource.getConnection();
            if(conn != null)
            {
                log.info("connection successful");
            }
            log.info(conn.getMetaData().getDatabaseProductName());
            return conn;

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return conn;
    }
}
