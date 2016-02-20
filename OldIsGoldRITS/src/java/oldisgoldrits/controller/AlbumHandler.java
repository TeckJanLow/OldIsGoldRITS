/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.controller;

import config.DatabaseConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Teck Jan Low
 */
public class AlbumHandler {

    /**
     * 
     * @param title
     * @param artist
     * @param genre
     * @param comments
     * @throws SQLException 
     */
    public void addNewAlbum(String title, String artist, String genre, 
            String comments) throws SQLException{
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "INSERT INTO ALBUM (title, artist, genre, comments)"
                + "VALUES (" + title + ", " + artist + ", " + genre + ", " 
                + comments + ")";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void editAlbum(int albumID, String comments) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "UPDATE ALBUM SET comments = '" + comments + "' "
                + "WHERE album_id = '" + albumID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
    public void deleteAlbum(int albumID) throws SQLException {
        
        DatabaseConnector dbc = new DatabaseConnector();
        Connection conn = dbc.connect();
        String query = "DELETE FROM ALBUM WHERE album_id = '" 
                + albumID + "'";
        Statement st = conn.createStatement();
        st.executeUpdate(query);
        conn.close();
    }
    
}
