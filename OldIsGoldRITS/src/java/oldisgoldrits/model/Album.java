/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package oldisgoldrits.model;

/**
 * Stores album information
 * @author Teck Jan Low
 * @version 1.0
 */
public class Album {
    
    /**
     * The album ID
     */
    private int albumID;
    /**
     * The album title
     */
    private String title;
    /**
     * The artist of the album
     */
    private String artist;
    /**
     * The genre of music
     */
    private String genre;
    /**
     * Comments regarding album
     */
    private String comments;
    
    public Album() {
        
    }
    
    public Album(String title, String artist, String genre, String comments){
        
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.comments = comments;
    }

    public int getAlbumID() {
        return albumID;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public String getComments() {
        return comments;
    }
    
    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    

}
