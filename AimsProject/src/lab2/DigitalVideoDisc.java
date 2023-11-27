// Luong Phuc Quang - 20215125
package lab2;

public class DigitalVideoDisc {
//methods
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0;
	private int id;
//Getter methods for each attribute
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	//Setter methods
	public void setTitle(String title) {
		this.title = title;
	}
	// constructor method for DigitalVideoDisc
    public DigitalVideoDisc(String title) {
        this.title = title;
        this.id = ++nbDigitalVideoDiscs; 
    }

    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = ++nbDigitalVideoDiscs;
    }
    
    public String toString() 
	{
		String dvd;
		dvd = "[" + getTitle() + "]-[" + getCategory() + "]-[" + getDirector() + "]-["  +getLength() + "]: " + getCost() + "$";
		return dvd;
	}
    
    public boolean isMatch(String title)
	{  
    	return this.title.equalsIgnoreCase(title);
	}
}


    
    


