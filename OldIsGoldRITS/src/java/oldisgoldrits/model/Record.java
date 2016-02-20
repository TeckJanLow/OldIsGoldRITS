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
public class Record {
    
    private int albumID;
    private final String title;
    private final String artist;
    private final String genre;
    private String comments;
    
    public Record(String title, String artist, String genre, String comments){
        
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


}
