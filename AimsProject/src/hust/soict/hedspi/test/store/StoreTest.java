//Luong Phuc Quang 20215125
package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		 Store aStore = new Store();	// Create a new store named aStore
		 // Create DVDs and add them to the store
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		 aStore.addMedia(dvd1);
 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
		 aStore.addMedia(dvd2);
		    
		 DigitalVideoDisc dvd3 = new  DigitalVideoDisc("Aladin", "Animation", 18.99f );
		 aStore.addMedia(dvd3);
		 
		 // Remove DVD from the store
		 aStore.removeMedia(dvd3);
		 aStore.removeMedia(dvd3);	    
	}
}
