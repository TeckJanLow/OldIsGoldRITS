/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Composition of inventory and album information
 * @author Teck Jan Low
 * @version 1.0
 */
public class InventoryTable {
    
    /**
     * An inventory object
     */
    private final Inventory inventory;
    /**
     * An album object
     */
    private final Album album;
    
    /**
     * Constructor for the inventory table
     * @param inventory An inventory object
     * @param album An ablum object
     */
    public InventoryTable(Inventory inventory, Album album) {
        this.inventory = inventory;
        this.album = album;
    }

    /**
     * Getter for the inventory object
     * @return the inventory object
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Getter for the album object
     * @return the album object
     */
    public Album getAlbum() {
        return album;
    }
    
}