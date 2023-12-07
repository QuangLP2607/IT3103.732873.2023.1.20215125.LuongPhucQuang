// Lương Phúc Quang 20215125
package hust.soict.dsai.aims.media; 
public class Track { 
	private String title;
	private int length;
	
	public Track (String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	// Getter cho title 
	public String getTitle() { 
		return title;
	}
	// Getter cho length 
	public int getLength() { 
		return length;
	}
	
	public void play() {
		System.out.println("Đang phát track: " + this.getTitle()); 
		System.out.println("Độ dài track: " + this.getLength());
	}
	
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
	
	public String toString() 
	{
		String track;
		track = getTitle() + " - " +getLength() ;
		return track;
	}

}

