//Luong Phuc Quang - 20215125
package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc ("Jungle"); 
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc ("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle()); 
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle()); 
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		
		//Revert the name of jungleDVD
		changeTitle(jungleDVD, "Jungle");
    	
		//Test method can correctly swap
		swapCorrectly(jungleDVD,cinderellaDVD);
		
		System.out.println("\n__________ Correctly swap __________");
    	System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
    	System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

	}
	
	public static void swap (Object o1, Object o2) {

		Object tmp= o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle(); 
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
	
	//swap() method that can correctly swap the two objects
	public static void swapCorrectly(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2 ) {
	    String tmp = dvd1.getTitle();
	    dvd1.setTitle(dvd2.getTitle());
	    dvd2.setTitle(tmp);
	    }	
}
