// Luong Phuc Quang - 20215125
package lab2;

public class Aims {

	public static void main(String[] args) {
    	//Create a new cart 
    	Cart anOrder = new Cart();
    	//Create new dvd objects and add them to the cart 
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc ("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
    	anOrder.addDigitalVideoDisc (dvd1);
    	DigitalVideoDisc dvd2 = new DigitalVideoDisc ("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f); 
    	anOrder.addDigitalVideoDisc (dvd2);
    	DigitalVideoDisc dvd3= new DigitalVideoDisc ("Aladin", "Animation", 18.99f); 
    	anOrder.addDigitalVideoDisc (dvd3);
    	//print total cost of the items in the cart 
    	System.out.println("Total Cost is: "); 
    	System.out.println(anOrder.totalCost());

	    System.out.println("\nTesting removeDigitalVideoDisc method");
	    //remove dvd3 
	    anOrder.removeDigitalVideoDisc(dvd3);
	    //show cart
anOrder.showCart();
    	
    	// create a list of DVDs
    	DigitalVideoDisc[] dvdList = new DigitalVideoDisc[3];
    	dvdList[0]=dvd3;
    	dvdList[1]=dvd1;
    	dvdList[2]=dvd3;
    	 	
//test Overloaded method addDigitalVideoDisc
    	//method add a list of DVDs 	
    	System.out.println("\nTest overloaded method add a list of DVDs:");
    	anOrder.showCart();							//show cart
    	anOrder.addDigitalVideoDisc(dvdList);		//add DVDs
    	anOrder.showCart();							//show cart
    	
    	//method add two DVDs
    	System.out.println("\nTest overloaded method add two DVD:");
    	anOrder.addDigitalVideoDisc(dvd1,dvd1);		//add DVDs
    	anOrder.showCart();							//show cart
    	
    	//Check the allocation of ID for DVD
    	System.out.println("\nCheck the allocation of ID for DVD:");
    	System.out.println("dvd 1 id: " + dvd1.getId());
	    System.out.println("dvd 2 id: " + dvd2.getId());
	}
}


