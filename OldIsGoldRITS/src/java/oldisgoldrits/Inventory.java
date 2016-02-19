/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits;

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
    
    @Override
    public String toString() {
        String output;
        output = String.format("%5s%5s%5s%10s%5s", this.inventoryID, this.quality, this.quantityOnHand, this.price, this.albumID);
        return output;
    }
    
}
