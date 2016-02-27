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
import java.util.ArrayList;
import oldisgoldrits.model.InventoryTable;

/**
 * Contains all methods involving the creation and manipulation of Inventory
 * items.
 *
 * @author Teck Jan Low
 * @version 1.0
 */
public class InventoryHandler {

    /**
     * Retrieves a ResultSet of all inventory information.
     *
     * @return A ResultSet of all inventory data
     * @throws SQLException
     */
    public ArrayList<InventoryTable> getInventory() throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        ArrayList<InventoryTable> inventoryList;
        try (Connection conn = dbc.connect()) {
            String query = "SELECT INVENTORY.*, ALBUM.title, ALBUM.artist, "
                    + "ALBUM.genre, ALBUM.comment FROM INVENTORY LEFT JOIN ALBUM "
                    + "ON INVENTORY.album_id = ALBUM.album_id";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            InventoryParser inventoryParser = new InventoryParser();
            inventoryList = inventoryParser.parse(rs);
            rs.close();
            conn.close();
        }

        return inventoryList;
    }

    /**
     * Retrieves a ResultSet of inventory information from the database with
     * conditions.
     *
     * @param condition Specified conditions for data retrieval
     * @return A ResultSet containing retrieved data
     * @throws SQLException
     */
    public ArrayList<InventoryTable> getInventory(String condition) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        ArrayList<InventoryTable> inventoryList;
        try (Connection conn = dbc.connect()) {
            String query = "SELECT INVENTORY.*, ALBUM.title, ALBUM.artist, "
                    + "ALBUM.genre, ALBUM.comment FROM INVENTORY LEFT JOIN ALBUM "
                    + "ON INVENTORY.album_id = ALBUM.album_id WHERE " + condition;
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            InventoryParser inventoryParser = new InventoryParser();
            inventoryList = inventoryParser.parse(rs);
            rs.close();
            conn.close();
        }

        return inventoryList;
    }

    /**
     * Adds a new inventory item to the database.
     *
     * @param quality The quality of the item
     * @param quantity The quantity of items on hand
     * @param price The retail price of the item
     * @param purchasePrice The cost per unit of the item
     * @param albumID The ID of the album
     * @throws SQLException
     */
    public void addNewInventory(String quality, int quantity, double price,
            double purchasePrice, int albumID) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO INVENTORY (quality, quantity, price, "
                + "purchase_price, album_ID) VALUES (" + quality + ", " + quantity
                + ", " + price + ", " + purchasePrice + ", " + albumID + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }

    /**
     * Edits an inventory item on the database
     *
     * @param inventoryID The ID of the inventory item to be edited
     * @param quantity The new quantity of the item
     * @param price The new price of the item
     * @param purchasePrice The new purchase price of the item
     * @param comment A comment regarding the album
     * @throws SQLException
     */
    public void editInventory(int inventoryID, int quantity, double price, 
            double purchasePrice, String comment) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String queryOne = "UPDATE INVENTORY SET quantity = '" + quantity 
                + "', price = '" + price + "', purchase_price = '" 
                + purchasePrice + "' WHERE sku = '" + inventoryID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(queryOne);
        ResultSet rs = st.executeQuery("SELECT album_id FROM INVENTORY WHERE sku = " + inventoryID);
        String queryTwo = "UPDATE ALBUM SET comment = '" + comment + "' WHERE "
                + "ALBUM.album_id = " + rs.getInt("sku");
        st.executeUpdate(queryTwo);
        rs.close();
        conn.close();
    }

    /**
     * Deletes an inventory item from the database.
     *
     * @param inventoryID The ID of the inventory item to be deleted
     * @throws SQLException
     */
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
