// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.media.*;
import java.util.ArrayList;
import java.util.List;

public class ToStringTest {
    public static void main(String[] args) {
    	//Create an ArrayList of Media
        List<Media> mediae = new ArrayList<Media>();
        
        CompactDisc cd = new CompactDisc("Michael Bay",8,"Michael Jackson");
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f );
        Book book = new Book("The Gutenberg Galaxy","Literary analysis", 5.6f);

        //add media (CD, DVD or Book) into the list.
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);
        //print out the information of the media
        for(Media m: mediae) {
            System.out.println(m.toString());       
        }   
    }
}

