// Luong Phuc Quang - 20215125
package lab2;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;// maximum of 20 DVDs into one cart
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];// array to store a list of DigitalVideoDisc
	private int qtyOrdered;

	public Cart() {
		itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
		qtyOrdered = 0;
	}
	//method to add an item to the list.
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) { 
			itemsOrdered[qtyOrdered] = disc; 
			qtyOrdered++; 
			System.out.println("Đã thêm điã vào giỏ hàng.");
		} 
		else {
			System.out.println("Giỏ hàng đầy."); 
		}
	}
	// Overloaded method 1
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc dvd : dvdList) {
            addDigitalVideoDisc(dvd);
        }
    }

    // Overloaded method 2
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

	
	// method remove the item passed by argument from the list
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) { 
            if (itemsOrdered[i] == disc) { 
            	System.out.println("Đã xóa dvd " + disc.getTitle() + " khỏi giỏ hàng.");
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1]; 
                }
                qtyOrdered--; 
                itemsOrdered[qtyOrdered] = null; 
                return;
            }
        }
        System.out.println("Không tìm thấy đĩa trong giỏ hàng.");
	}
	
	// method loops through the values of the array and sums the costs 
	public float totalCost() {
        float total = 0; 
        for (int i = 0; i < qtyOrdered; i++) { 
            total += itemsOrdered[i].getCost(); 
        }
        return total; 
    }
	
	// method show List of DVDs in cart
	public void showCart ()
	{   
		System.out.println("  Giỏ hàng hiện có:");
		int i = 1;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc != null) {
				System.out.println(i++ + " " + disc.getTitle() + " " + disc.getCost());
			}
        }
	}
}
