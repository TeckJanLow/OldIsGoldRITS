/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Defines the stock keeping units 
 * @author Teck Jan Low
 * @version 1.0
 */
public class Inventory {
    
    /**
     * Stock keeping unit of inventory entry
     */
    private int inventoryID;
    /**
     * quality enum of inventory
     */
    private enum Quality {
        mint, good, fair, poor
    }
    /**
     * Quality of inventory record
     */
    private Quality quality;
    /**
     * Quantity in stock
     */
    private int quantityOnHand;
    /**
     * Price of record
     */
    private double price;
    /**
     * Purchase price of record
     */
    private double purchasePrice;
    /**
     * Album ID of record
     */
    private int albumID;
    
    /**
     * no argument constructor for inventory 
     */
    public Inventory() {
        
    }
    
    /**
     * Full constructor for inventory
     * @param inventoryID Inventory stock keeping unit
     * @param quality quality of record
     * @param quantityOnHand quantity in stock
     * @param price price per unit
     * @param purchasePrice purchase cost of record
     * @param albumID album id of record
     */
    public Inventory(int inventoryID, String quality, int quantityOnHand, double price, double purchasePrice, int albumID) {
        this.inventoryID = inventoryID;
        this.quality = Quality.valueOf(quality);
        this.quantityOnHand = quantityOnHand;
        this.price = price;
        this.purchasePrice = purchasePrice;
        this.albumID = albumID;
    }

    /**
     * Getter for inventory id
     * @return inventory id
     */
    public int getInventoryID() {
        return inventoryID;
    }

    /**
     * Setter for inventory id
     * @param inventoryID new inventory id
     */
    public void setInventoryID(int inventoryID) {
        this.inventoryID = inventoryID;
    }

    /**
     * getter for inventory quality
     * @return inventory quality
     */
    public String getQuality() {
        String quality = this.quality.toString();
        return quality;
    }

    /**
     * Setter for inventory quality
     * @param quality new inventory quality
     */
    public void setQuality(String quality) {
        this.quality = Quality.valueOf(quality);
    }

    /**
     * Getter for stock levels
     * @return number if items on hand
     */
    public int getQuantityOnHand() {
        return quantityOnHand;
    }

    /**
     * Setter for quantity on hand
     * @param quantityOnHand the new quantity on hand
     */
    public void setQuantityOnHand(int quantityOnHand) {
        this.quantityOnHand = quantityOnHand;
    }

    /**
     * Getter for item price
     * @return the item price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Setter for item price
     * @param price the new price of the item
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Getter for the purchase price
     * @return purchase price per unit of the inventory item
     */
    public double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * Setter for purchase price
     * @param purchasePrice the new purchase price of the record
     */
    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    
    /**
     * Getter for album ID
     * @return the album ID
     */
    public int getAlbumID() {
        return albumID;
    }

    /**
     * Setter for Album ID
     * @param albumID the new album ID
     */
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }
    
}