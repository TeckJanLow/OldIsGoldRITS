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
public class Inventory {
    
    private int inventoryID;
    private enum Quality {
        mint, good, fair, poor
    }
    private Quality quality;
    private int quantityOnHand;
    private long price;
    private int albumID;
    
    public Inventory(Quality quality, int quantityOnHand, long price) {
        this.quality = quality;
        this.quantityOnHand = quantityOnHand;
        this.price = price;
    }

    public int getInventoryID() {
        return inventoryID;
    }

    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    public String getQuality() {
        String quality = this.quality.toString();
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = Quality.valueOf(quality);
    }

    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
    
    
}
