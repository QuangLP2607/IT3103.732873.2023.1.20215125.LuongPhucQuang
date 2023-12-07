// Luong Phuc Quang - 20215125
package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDiscs = 0;
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

    public String toString() 
	{
		String dvd;
		dvd = "[" + getTitle() + "]-[" + getCategory() + "]-[" + getDirector() + "]-["  +getLength() + "]: " + getCost() + "$";
		return dvd;
	}
    
    public boolean isMatch(String title)
	{  
    	return getTitle().equalsIgnoreCase(title);
	}

    public void play () {
    	System.out.println("Đang phát DVD: "+this.getTitle()); 
    	System.out.println("Độ dài DVD: " + this.getLength());
    }
}
