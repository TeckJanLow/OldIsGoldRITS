/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

import java.text.DecimalFormat;

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
    private double price;
    private double purchasePrice;
    private int albumID;
    
    public Inventory() {
        
    }
    
    public Inventory(int inventoryID, String quality, int quantityOnHand, double price, double purchasePrice) {
        this.inventoryID = inventoryID;
        this.quality = Quality.valueOf(quality);
        this.quantityOnHand = quantityOnHand;
        this.price = price;
        this.purchasePrice = purchasePrice;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    public int getAlbumID() {
        return albumID;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
    
    
}
