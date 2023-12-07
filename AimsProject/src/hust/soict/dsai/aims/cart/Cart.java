// Luong Phuc Quang - 20215125
package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict. dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;// maximum of 20 DVDs into one cart
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//method to add an item to the list.
	public void addMedia (Media item) 
	{ 
		if ( itemsOrdered.size() == MAX_NUMBERS_ORDERED) { 
			System.out.println("The cart is almost full");
			return;
        } else {
        itemsOrdered.add(item);
        System.out.println("The item has been added");
       }

	}
	// Overloaded method 1
    public void addMedia(Media[] MediaList) {
    	if (itemsOrdered.size() + MediaList.length > MAX_NUMBERS_ORDERED) {
    		System.out.println("There are not enough spots in the cart");
    	} else {
    		for (Media media : MediaList) {
    			itemsOrdered.add(media);
    		}
    		System.out.println("The list of items has been added successfully");
    	}
    }
    // Overloaded method 2
    public void addMedia (Media media1, Media media2 ) {   
        if ( itemsOrdered.size() + 2 >  MAX_NUMBERS_ORDERED)
        { 
        	System.out.println("The cart is almost full");
             return;
        } else {
        	itemsOrdered.add(media1);
            itemsOrdered.add(media2);
            System.out.println("Both items have been added");
        }
    }
	
	public void removeMedia(Media media) {
		if (itemsOrdered.isEmpty()){   
	        System.out.println("The cart is empty");
	        return;
	    } else {
	    	itemsOrdered.remove(media);
	    	System.out.println("The disc is removed successfully");
	    }
	}
	
	public float totalCost() {
		float total = 0;
		for (Media media: itemsOrdered) { 	
			total += media.getCost();
		}
		return total;
	}

	// method show List of DVDs in cart
	public void showCart ()
	{   
		System.out.println("  Giỏ hàng hiện có:");
		int i = 1;
		for (Media media : itemsOrdered) {
			if (media != null) {
				System.out.println(i++ + " " + media.getTitle() + " " + media.getCost());
			}
        }
	}
	// print the list of ordered items of a cart, the price of each item, and the total price
		public void print()
	    {   
	        int i = 1;
	        System.out.println("**********************CART**********************");
	        for (Media media : itemsOrdered) {
	        	if (media != null) {
	        		System.out.println(i++ + ".DVD - " + media.toString());
	        	}
	        }
	        System.out.print("Total Cost: ");
	        System.out.println(totalCost());
	        System.out.println("*************************************************");
	    }
		// Search method
		// 1) search by Title
		public Media searchByTitle(String Title)
		{ 
		    int count = 1;
		    Media result = null;
		    for (Media media : itemsOrdered) {
		    	if (media != null) {
		    		if (media.isMatch(Title))
		            {
		    			System.out.println(count++ + ".DVD -" + media.toString());
		            }       
		    	}
		    }
		    if (count == 1)
		    {   
		        System.out.println("No results found");
		    }
		    return result;
		}

		// 2) search by ID
		public void searchById(int Id)
		{   
			int count = 1;
			for (Media media : itemsOrdered) {
				if (media != null) {
					if (Id == media.getId())
					{
						System.out.println(count++ + ".DVD -" + media.toString());
						break;
					}
				}
			}
		    if (count == 1)
		    {   
		    	System.out.println("No results found");
		    }    
		}	
		public void sortByTitle() {
	        java.util.Collections.sort(itemsOrdered,Media.COMPARE_BY_TITLE_COST);
	    }
	    
	    public void sortByCost() {
	        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	    }

}
