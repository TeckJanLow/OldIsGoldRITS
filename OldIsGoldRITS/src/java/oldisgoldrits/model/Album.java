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
    
    /** 
     * No argument constructor for album
     */
    public Album() {
        
    }
    
    /**
     * Full constructor for album
     * @param title The album title
     * @param artist The album artist
     * @param genre The genre of music
     * @param comments Comments regarding the album
     */
    public Album(String title, String artist, String genre, String comments){
        
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.comments = comments;
    }

    /**
     * Getter for album ID
     * @return album ID
     */
    public int getAlbumID() {
        return albumID;
    }

    /**
     * Getter for the album title
     * @return The album title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter for the album artist
     * @return The album artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Getter for the album genre
     * @return The album genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Getter for the album comments
     * @return The album comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Setter for comments
     * @param comments the new comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Setter for album ID
     * @param albumID The new album ID
     */
    public void setAlbumID(int albumID) {
        this.albumID = albumID;
    }

    /**
     * Setter for the album title
     * @param title The album title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Setter for the album artist
     * @param artist The album artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Setter for the genre of the album
     * @param genre The album genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}