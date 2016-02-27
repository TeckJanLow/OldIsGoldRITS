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
import java.util.logging.Logger;
import oldisgoldrits.model.Album;

/**
 * Contains all methods involving the creation and manipulation of albums.
 *
 * @author Teck Jan Low
 * @version 1.0
 */
public class AlbumHandler {

    /**
     * Adds a new album to the database.
     *
     * @param title Title of the album
     * @param artist The artist of the album
     * @param genre The genre of the album
     * @param comments Comments regarding the album.
     * @throws SQLException
     */
    public void addNewAlbum(String title, String artist, String genre,
            String comments) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO ALBUM (title, artist, genre, comments)"
                + "VALUES (" + title + ", " + artist + ", " + genre + ", "
                + comments + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }

    /**
     * Edits album information on the database.
     *
     * @param albumID The ID of the album to be edited.
     * @param title The new title of the album
     * @param artist The new artist of the album
     * @param genre The new genre of the album
     * @param comments The new comments regarding the album
     * @throws SQLException
     */
    public void editAlbum(int albumID, String title, String artist,
            String genre, String comments) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE ALBUM SET title = '" + title + "', artist = '"
                + artist + "', genre = '" + genre + "', comments = '"
                + comments + "' WHERE album_id = '" + albumID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }

    /**
     * Deletes an album from the database.
     *
     * @param albumID The ID of the album to be deleted.
     * @throws SQLException
     */
    public void deleteAlbum(int albumID) throws SQLException {

        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM ALBUM WHERE album_id = '"
                + albumID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public ArrayList<Album> showAllAlbum() throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        try (Connection conn = dbc.connect()) {
            String query = "SELECT title, artist FROM ALBUM ORDER BY title ASC" ;
            
            Statement st = conn.createStatement();
            Logger log  = Logger.getLogger(getClass().getSimpleName());
            log.info(query);
            InventoryParser ip = new InventoryParser();
            ResultSet rs = st.executeQuery(query);
            ArrayList<Album> albumList = ip.parseAlbum(rs);
            rs.close();
            conn.close();
            return albumList;
        }
    }

}
