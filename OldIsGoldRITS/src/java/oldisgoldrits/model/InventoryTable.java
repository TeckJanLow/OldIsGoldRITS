/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 *
 * @author Teck Jan Low
 */
public class InventoryTable {
    
    private Inventory inventory;
    private Album album;
    
    /**
     *
     * @param inventory
     * @param album
     */
    public InventoryTable(Inventory inventory, Album album) {
        this.inventory = inventory;
        this.album = album;
    }

    /**
     *
     * @return
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     *
     * @return
     */
    public Album getAlbum() {
        return album;
    }
    
}
