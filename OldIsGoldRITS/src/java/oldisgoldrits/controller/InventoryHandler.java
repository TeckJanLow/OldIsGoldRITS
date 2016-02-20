/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Teck Jan Low
 */
public class InventoryHandler {

    /**
     * 
     * @param condition
     * @return
     * @throws SQLException 
     */
    public ResultSet getInventory(String condition) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "SELECT INVENTORY.*, ALBUM.title, ALBUM.artist, "
                + "ALBUM.genre, ALBUM.comments FROM INVENTORY LEFT JOIN ALBUM "
                + "ON INVENTORY.album_id = ALBUM.album_id";
        if (!condition.isEmpty()) {
            query += "WHERE " + condition;
        }
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        conn.close();
        return rs;
    }
    
    /**
     * 
     * @param quality
     * @param quantityOnHand
     * @param price
     * @throws SQLException 
     */
    public void addNewInventory(String quality, int quantityOnHand, long price) 
            throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO INVENTORY (quality, quantity, price) VALUES"
                + " (" + quality + ", " + quantityOnHand + ", " + price + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void editInventory(int inventoryID, String quality, String quantity, 
            long price) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE INVENTORY SET quality = '" + quality + "', "
                + "quantity = '" + quantity + "', price = '" + price + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void deleteInventory(int inventoryID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM INVENTORY WHERE sku = '" 
                + inventoryID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
}
