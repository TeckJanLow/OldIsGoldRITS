/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldisgoldrits.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import oldisgoldrits.model.Album;
import oldisgoldrits.model.Inventory;
import oldisgoldrits.model.InventoryTable;

/**
 *
 * @author Teck Jan Low
 */
public class InventoryParser {

    public ArrayList<InventoryTable> parse(ResultSet rs) throws SQLException {

        ArrayList<InventoryTable> inventoryList = new ArrayList();

        while (rs.next()) {
            int inventoryID = rs.getInt("sku");
            String quality = rs.getString("quality");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            int albumID = rs.getInt("album_id");
            double purchasePrice = rs.getDouble("purchase_price");
            String title = rs.getString("title");
            String artist = rs.getString("artist");
            String genre = rs.getString("genre");
            String comments = rs.getString("comment");

            Inventory inv = new Inventory(inventoryID, quality, quantity, price, purchasePrice, albumID);
            Album album = new Album();
            album.setArtist(artist);
            album.setTitle(title);
            album.setGenre(genre);
            album.setComments(comments);
            

            InventoryTable it = new InventoryTable(inv, album);
            inventoryList.add(it);
        }

        return inventoryList;

    }
    
    public ArrayList<Album> parseAlbum(ResultSet rs) throws SQLException {

        ArrayList<Album> albumList = new ArrayList();

        while (rs.next()) {

            int albumID = rs.getInt("album_id");
            String title = rs.getString("title");
            String artist = rs.getString("artist");

            Album album = new Album();
            album.setTitle(title);
            album.setArtist(artist);
            album.setAlbumID(albumID);
            
            albumList.add(album);
        }
        return albumList;
    }

}
