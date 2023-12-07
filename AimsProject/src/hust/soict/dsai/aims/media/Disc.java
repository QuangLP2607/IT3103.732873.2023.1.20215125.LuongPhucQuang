// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.media;

public class Disc extends Media {
    private String director;
    private int length;

    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost); // Calls the constructor of the superclass with corresponding parameters
        this.length = length;
        this.director = director;
    }

    // Getters for Disc attributes
    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    // Setters for Disc attributes
    public void setDirector(String director) {
        this.director = director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Constructors
    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String director, int length) {
        super();
        this.director = director;
        this.length = length;
    }

    public Disc() {
        super();
    }
}