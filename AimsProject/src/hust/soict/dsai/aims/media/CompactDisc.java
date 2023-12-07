// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.media; 
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

    // Getter for artist
    public String getArtist() {
        return artist;
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
    
    public void play(){
    	System.out.println("Dang phát CD:"+this.getTitle());
    	System.out.println("Độ dài CD: " + this.getLength());
    	for (Track track : tracks) {
    		track.play();
    	
    	}
    }
    
    public String toString() 
    {
    	String cd;
        cd =    getTitle()+ " - " + getCategory() + " - " + getDirector()+ " - "  +getArtist() + " - "  +getLength();
        return cd;
    }

}
