//Luong Phuc Quang 20215125 
package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    // Maximum number of items in a cart
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private SimpleFloatProperty totalCostProperty = new SimpleFloatProperty(0);

    // Getters for itemsOrdered and totalCostProperty
    public SimpleFloatProperty getTotalCostProperty() {
        return totalCostProperty;
    }
    
    public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}
    
    // Method to add a single item to the cart
    public void addMedia(Media item) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        } else {
            itemsOrdered.add(item);
            totalCostProperty.set(item.getCost() + totalCostProperty.get());
            System.out.println("The item has been added");
        }
    }

    // Overloaded method to add multiple items to the cart
    public void addMedia(Media... item) {
        if (itemsOrdered.size() == MAX_NUMBERS_ORDERED) {
            throw new CartException("The cart is full. Cannot add more items.");
        } else {
            // Check if adding the items will exceed the maximum capacity of the cart
            if (itemsOrdered.size() + item.length > MAX_NUMBERS_ORDERED) {
                throw new CartException("There are not enough spots in the cart");
            } else {
                for (Media it : item) {
                    itemsOrdered.add(it);
                    totalCostProperty.set(it.getCost() + totalCostProperty.get());
                }
                System.out.println("The list of items has been added successfully");
            }
        }
    }

    // Method to add two specific items to the cart
    public void addMedia(Media media1, Media media2) {
        if (itemsOrdered.size() + 2 > MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full");
            return;
        } else {
            itemsOrdered.add(media1);
            itemsOrdered.add(media2);
            totalCostProperty.set(media1.getCost() + totalCostProperty.get());
            totalCostProperty.set(media2.getCost() + totalCostProperty.get());
            System.out.println("Both items have been added");
        }
    }

    // Method to remove a specified media from the cart
    public void removeMedia(Media media) {
        if (itemsOrdered.isEmpty()) {
            System.out.println("The cart is empty");
            return;
        } else {
            itemsOrdered.remove(media);
            System.out.println("The disc is removed successfully");
            totalCostProperty.set(totalCostProperty.get() - media.getCost());
        }
    }

    // Method to calculate the total cost of items in the cart
    public float totalCost() {
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    // Method to display the items in the cart
    public void showCart() {
        System.out.println("Items in the cart:");
        int i = 1;
        for (Media media : itemsOrdered) {
            if (media != null) {
                System.out.println(i++ + ". " + media.getTitle() + " " + media.getCost());
            }
        }
    }

    // Method to empty the cart
    public void emptyCart() {
        itemsOrdered.clear();
        totalCostProperty.set(0);
        System.out.println("The cart has been emptied.");
    }

    // Method to print the list of ordered items, their prices, and the total price
    public void print() {
        int i = 1;
        System.out.println("********************** CART **********************");
        for (Media media : itemsOrdered) {
            if (media != null) {
                System.out.println(i++ + ". DVD - " + media.toString());
            }
        }
        System.out.print("Total Cost: ");
        System.out.println(totalCost());
        System.out.println("*************************************************");
    }

    // Method to search for an item by its title
    public Media searchByTitle(String title) {
        int count = 1;
        Media result = null;
        for (Media media : itemsOrdered) {
            if (media != null) {
                if (media.isMatch(title)) {
                    System.out.println(count++ + ". DVD - " + media.toString());
                }
            }
        }
        if (count == 1) {
            System.out.println("No results found");
        }
        return result;
    }

    // Method to search for an item by its ID
    public void searchById(int id) {
        int count = 1;
        for (Media media : itemsOrdered) {
            if (media != null) {
                if (id == media.getId()) {
                    System.out.println(count++ + ". DVD - " + media.toString());
                    break;
                }
            }
        }
        if (count == 1) {
            System.out.println("No results found");
        }
    }

    // Method to sort items in the cart by title
    public void sortByTitle() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
    }

    // Method to sort items in the cart by cost
    public void sortByCost() {
        java.util.Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
    }

    // Custom exception class for cart-related exceptions
    public class CartException extends RuntimeException {
        public CartException(String message) {
            super(message);
        }
    }

	public Object getItemOrdered() {
		// TODO Auto-generated method stub
		return null;
	}
}
