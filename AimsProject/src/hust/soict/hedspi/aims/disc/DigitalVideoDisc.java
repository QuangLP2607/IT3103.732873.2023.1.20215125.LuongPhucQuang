// Luong Phuc Quang - 20215125
package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
    private static int nbDigitalVideoDiscs = 0;

    // Constructors for DigitalVideoDisc class
    public DigitalVideoDisc(String title) {
        super(title);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, cost);
        setDirector(director);
        setId(++nbDigitalVideoDiscs);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        setDirector(director);
        setLength(length);
        setId(++nbDigitalVideoDiscs);
    }

    // Override toString method to display DVD information
    public String toString() {
        String dvd;
        dvd = "[" + getTitle() + "]-[" + getCategory() + "]-[" + getDirector() + "]-["  +getLength() + "]: " + getCost() + "$";
        return dvd;
    }

    // Check if the DVD title matches the given title
    public boolean isMatch(String title) {  
        return getTitle().equalsIgnoreCase(title);
    }

    // Implement the play method from the Playable interface
    public StringBuilder play() throws PlayerException {
        // Play method for the Playable interface
        StringBuilder result = new StringBuilder();
        if (this.getLength() > 0) {
            // If length > 0, no play error occurs
            result.append("Playing DVD: ").append(getTitle()).append("\nDVD length: ").append(getLength());
            return result;
        } else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
