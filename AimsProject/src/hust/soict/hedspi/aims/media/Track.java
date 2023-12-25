// Lương Phúc Quang 20215125
package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track { 
    private String title;
    private int length;
    
    // Constructor for Track class
    public Track (String title, int length) {
        this.title = title;
        this.length = length;
    }
    
    // Getter for title 
    public String getTitle() { 
        return title;
    }
    // Getter for length 
    public int getLength() { 
        return length;
    }
    
    // Play method for Track
    public StringBuilder play() throws PlayerException  {
        // Method to play the track
        StringBuilder result = new StringBuilder();
        if (this.getLength() > 0) {
            result.append("Playing Track: ").append(getTitle()).append("\nTrack length: ").append(getLength());
            return result;
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
    }
    
    // Override equals method to compare tracks
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Track track = (Track) obj;
        return title.equals(track.title) && length == track.length;
    }
    
    // Override toString method to display track information
    public String toString() {
        String track;
        track = getTitle() + " - " +getLength() ;
        return track;
    }
}