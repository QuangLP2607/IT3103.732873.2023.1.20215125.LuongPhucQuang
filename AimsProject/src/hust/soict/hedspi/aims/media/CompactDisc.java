// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.media; 
import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.List;
public class CompactDisc extends Disc {
    private String artist;
    private List<Track> tracks = new ArrayList<Track>();

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist) {
        super(id, title, category, cost, length, director);
        // Calls the constructor of the superclass Disc with corresponding parameters
        this.artist = artist;
    }
    
    public CompactDisc(String title) {
        super(title);
    }
    
    public CompactDisc(String title, String category, float cost) {
        super(title,category,cost);
    }
    
    public CompactDisc(String director, int length, String artist) {
        super(director, length);
        this.artist = artist;
    }
    public CompactDisc(String title, String category, String director, int length, float cost, String artist) {
    	super(title, category, cost);
        setDirector(director);
    	setLength(length);
    	setArtist(artist);
    }
    
    // Getter for artist
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
		this.artist = artist;
	}

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("This track already exists in the CD.");
        } else {
            tracks.add(track);
            System.out.println("Track added to the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed from the CD.");
        } else {
            System.out.println("This track does not exist in the CD.");
        }
    }

    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    
    public StringBuilder play() throws PlayerException {
	    StringBuilder result = new StringBuilder();
	    result.append("Total tracks: ").append(tracks.size()).append("\n");
	    result.append("Total runtime: ").append(getLength()).append("\n");

	    if (this.getLength() > 0) {
	        Iterator<Track> iter = tracks.iterator();
	        Track nextTrack;
	        while (iter.hasNext()) {
	            nextTrack = iter.next();
	            try {
	                result.append(nextTrack.play()).append("\n");
	            } catch (PlayerException e) {
	                System.err.println("Error playing track: " + e.getMessage());
	                throw e;
	            }
	        }
	        return result;
	    } else {
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}

    public String toString() 
    {
    	String cd;
        cd =    getTitle()+ " - " + getCategory() + " - " + getDirector()+ " - "  +getArtist() + " - "  +getLength();
        return cd;
    }
}