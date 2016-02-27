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
    
    public InventoryTable(Inventory inventory, Album album) {
        this.inventory = inventory;
        this.album = album;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Album getAlbum() {
        return album;
    }
    
}
