package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		 Store aStore = new Store();	// Create a new store named aStore
		 // Create DVDs and add them to the store
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
		 aStore.addDVD(dvd1);
 
		 DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
		 aStore.addDVD(dvd2);
		    
		 DigitalVideoDisc dvd3 = new  DigitalVideoDisc("Aladin", "Animation", 18.99f );
		 aStore.addDVD(dvd3);
		 
		 // Remove DVD from the store
		 aStore.removeDVD(dvd3);
		 aStore.removeDVD(dvd3);	    
	}
}
