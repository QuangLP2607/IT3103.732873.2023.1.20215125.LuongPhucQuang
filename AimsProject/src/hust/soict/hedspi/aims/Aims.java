// Luong Phuc Quang - 20215125
package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

import java.util.Scanner;

public class Aims {
	private static String mediaTitle;
	public static Scanner scanner = new Scanner(System.in);
	public static Store aStore; 
	public static Cart aCart = new Cart();
	private static Media foundMedia;

	public static void main(String[] args)
   {   
		aStore = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f );
	    aStore.addMedia(dvd1);
	    DigitalVideoDisc dvd2 = new  DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f );
	    aStore.addMedia(dvd2);
	    DigitalVideoDisc dvd3 = new  DigitalVideoDisc("Aladin", "Animation", 18.99f );
	    aStore.addMedia(dvd3);
	    CompactDisc cd1 = new CompactDisc("Disco Elysium", "High Classic",12.3f);
        CompactDisc cd2 = new CompactDisc("Divine dive", "Blue", 16f);
        aStore.addMedia(cd1);
        aStore.addMedia(cd2);
        Book book1 = new Book("Introduction to Demons summoning", "Occult",12f);
        Book book2 = new Book("High and low", "shitpost", 120f);
        aStore.addMedia(book1);
        aStore.addMedia(book2);
        showMenu();
   }
   
   public static void showMenu() {
	   System.out.println("AIMS: ");
	   System.out.println("--------------------------------");
	   System.out.println("1. View store");
	   System.out.println("2. Update store");
	   System.out.println("3. See current cart");
	   System.out.println("0. Exit");
	   System.out.println("--------------------------------");
	   System.out.println("Please choose a number: 0-1-2-3");
	   
	   int choice = scanner.nextInt();
	   
       switch (choice){
       case 0: 
    	   return;
       case 1: storeMenu(); 	//View store
           	break;
       case 2: updateStore(); 	//Update store
           	break;
       case 3: cartMenu(); 		//See current cart
           	break;
       default:
            System.out.println("Choose again!");
            showMenu();
	   }
   }
   
   public static void storeMenu() {
	   aStore.showStore();

	   System.out.println("Options: ");
	   System.out.println("--------------------------------");
	   System.out.println("1. See a media’s details");
	   System.out.println("2. Add a media to cart");
	   System.out.println("3. Play a media");
	   System.out.println("4. See current cart");
	   System.out.println("0. Back");
	   System.out.println("--------------------------------");
	   System.out.println("Please choose a number: 0-1-2-3-4");
	   
	   int choice = scanner.nextInt();
	   
       switch (choice){
       case 0: showMenu(); 
       		break;
       case 1:  //See a media’s details
	        System.out.println("Enter media's title: ");
	        scanner.nextLine();
	        mediaTitle = scanner.nextLine();
	        foundMedia = aStore.searchByTitle(mediaTitle);
	        if (foundMedia != null) {
	        	mediaDetailsMenu();
	        }
	        storeMenu();
	        break;
       case 2:	//Add a media to cart
        	System.out.println("Enter media's title: ");
        	scanner.nextLine();
        	String mediaTitleAdd = scanner.nextLine();
        	foundMedia = aStore.searchByTitle(mediaTitleAdd);
        	if (foundMedia != null) {
        		aCart.addMedia(foundMedia);
        	    aStore.removeMedia(foundMedia);
        	    System.out.println("Media added to cart successfully");
        	} else {
        	    System.out.println("Media not found in the store");
        	}
        	    storeMenu();
        	    break;
       case 3:	//Play a media
            System.out.println("Enter media's title: ");
            scanner.nextLine();
            String mediaTitlePlay = scanner.nextLine();
            foundMedia = aStore.searchByTitle(mediaTitlePlay);
               
            if (foundMedia instanceof CompactDisc) {
            	CompactDisc cd = (CompactDisc) foundMedia;
            	try {
        	        cd.play();
        	    } catch (PlayerException e) {
        	        System.err.println("Error playing media: " + e.getMessage());
        	        e.printStackTrace(); 
        	    }
            } else if (foundMedia instanceof DigitalVideoDisc) {
            	DigitalVideoDisc dvd = (DigitalVideoDisc) foundMedia;
            	try {
        	    	dvd.play();
        	    } catch (PlayerException e) {
        	        System.err.println("Error playing media: " + e.getMessage());
        	        e.printStackTrace(); 
        	    }
            } else {
       	        System.out.println("Media can't be played");
       	    }
            storeMenu();
            break;
       case 4:	//See current cart
            cartMenu();
            break;
       default:
            System.out.println("Error, choose again!");
            storeMenu();
	   }
   }
   
   public static void mediaDetailsMenu() {
	   
	   int check = 0;
	   System.out.println("Options: ");
	   System.out.println("--------------------------------");
	   System.out.println("1. Add to cart");
	   System.out.println("2. Play");
	   System.out.println("0. Back");
	   System.out.println("--------------------------------");
	   System.out.println("Please choose a number: 0-1-2");
	   
	   int detailMenuChoice = scanner.nextInt();
	   switch (detailMenuChoice){
       case 0: storeMenu();	//Back
       		break;
       case 1:	//Add to cart
   	        aCart.addMedia(foundMedia);
   	        aStore.removeMedia(foundMedia);
   	        System.out.println("Media added to cart successfully");
   	        storeMenu();
           break;
       case 2:	//Play
           	if (check == 0){
        	   	System.out.println("Error, choose again!");
        	   	mediaDetailsMenu();
           	}
           	else {
           		if (foundMedia instanceof CompactDisc) {
           			CompactDisc cd = (CompactDisc) foundMedia;
           			try {
						cd.play();
					} catch (PlayerException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
           		} else if (foundMedia instanceof DigitalVideoDisc) {
           			DigitalVideoDisc dvd = (DigitalVideoDisc) foundMedia;
           			try {
            	    	dvd.play();
            	    } catch (PlayerException e) {
            	        System.err.println("Error playing media: " + e.getMessage());
            	        e.printStackTrace(); 
            	    }
           		}
           	}
           	break;
       	default:
       		System.out.println("Error, choose again!");
       		mediaDetailsMenu();
	   }
   }
   public static void updateStore(){
       Media item;
       
	   System.out.println("Options: ");
       System.out.println("--------------------------------");
       System.out.println("1. Add new media.");
       System.out.println("2. Remove media.");
       System.out.println("0. Back");
       System.out.println("---------------------------------");
       System.out.println("Please choose a number 0-1-2");
       int updateStoreChoice = scanner.nextInt();
       switch (updateStoreChoice){
       case 0: showMenu(); 	//Back
       		break;
       case 1:	// Add new media
            AddMedia();
            break;
       case 2:	// Remove media
            System.out.println("Removed media");
            scanner.nextLine();
            String removeFromStore = scanner.nextLine();
            item = aStore.searchByTitle(removeFromStore);
            if (item != null) {
            	System.out.println("Media removed successfully");
       	        aStore.removeMedia(item);
       	    } else {
       	        System.out.println("Can't remove");
       	    }
            updateStore();
            break;
       default:
            System.out.println("Error, choose again!");
            updateStore();
       }
   }
   
   public static void AddMedia(){
	   //Method cho việc thêm media trong store
       String Title;
       //In ra các lựa chọn
	   System.out.println("Options: ");
       System.out.println("--------------------------------");
       System.out.println("1. Add a book.");
       System.out.println("2. Add a DVD.");
       System.out.println("3. Add a CD.");
       System.out.println("0. Back");
       System.out.println("---------------------------------");
       System.out.println("Please choose a number 0-1-2-3");
       int updateStoreChoice = scanner.nextInt();
       scanner.nextLine();
       switch (updateStoreChoice){
           case 0: updateStore(); //Back
           	break;
           case 1:	//Add a book
        	   System.out.println("Title");
        	   Title = scanner.nextLine();
        	   Book book = new Book(Title);
        	   aStore.addMedia(book);
        	   updateStore();
               break;
           case 2:	//Add a DVD
        	   System.out.println("Title");
        	   Title = scanner.nextLine();
        	   DigitalVideoDisc dvd = new DigitalVideoDisc(Title);
        	   aStore.addMedia(dvd);
               updateStore();
               break;
           case 3:	//Add a CD
        	   System.out.println("Title");
        	   Title = scanner.nextLine();
        	   CompactDisc cd = new CompactDisc(Title);
        	   aStore.addMedia(cd);
        	   updateStore();
               break;   
           default:
               System.out.println("Error, choose again!");
               updateStore();
       }
   }
   
   
	public static void cartMenu() {
	   Media item;
	   aCart.showCart();
	   System.out.println("Options: ");
       System.out.println("--------------------------------");
       System.out.println("1. Filter media in cart");
       System.out.println("2. Sort media in cart");
       System.out.println("3. Remove media from cart");
       System.out.println("4. Play a media");
       System.out.println("5. Place order");
       System.out.println("0. Back");
       System.out.println("--------------------------------");
       System.out.println("Please choose a number: 0-1-2-3-4-5");
       int cartMenuChoice = scanner.nextInt();
       switch (cartMenuChoice){
      		case 0: storeMenu(); 	//Back
      			break;
           case 1:	//Filter media in cart
               filterMenu();
               break;
           case 2:	//Sort media in cart
               sortMenu();
               break;
           case 3:	//Remove media from cart
               System.out.println("Enter media's title: ");
               scanner.nextLine();
               String removeMediaTitle = scanner.nextLine();
               item = aCart.searchByTitle(removeMediaTitle);
               
               if (item != null) {
          	        System.out.println("Media removed successfully");
          	        aCart.removeMedia(item);
          	    } else {
          	        System.out.println("Can't removed");
          	    }
               	cartMenu();
             break;
           case 4:	//Play a media
               	System.out.println("Enter media's title");
               	scanner.nextLine();
               	String mediaTitlePlay = scanner.nextLine();
               	item =  aCart.searchByTitle(mediaTitlePlay);
               	if ( item instanceof CompactDisc) {
               		CompactDisc cd = (CompactDisc) item;
               		try {
               	        cd.play();
               	    } catch (PlayerException e) {
               	        System.err.println("Error playing media: " + e.getMessage());
               	        e.printStackTrace();
               	    }
               	}else if (item instanceof DigitalVideoDisc) {
               		DigitalVideoDisc dvd = (DigitalVideoDisc) item;
               		try {
            	    	dvd.play();
            	    } catch (PlayerException e) {
            	        System.err.println("Error playing media: " + e.getMessage());
            	        e.printStackTrace(); 
            	    }
               	}
               	else {
               		System.out.println("Media not found in the store");
               	}
               	cartMenu();
               	break;
           	case 5:	// Place order
           		System.out.println("An order is created");
           		cartMenu();
           		break;
           	default:
           		System.out.println("Error, choose again");
           		cartMenu();
       	}
   }
   
   public static void filterMenu(){
       System.out.println("Options: ");
       System.out.println("-------------------------------");
       System.out.println("1. By ID");
       System.out.println("2. By Title");
       System.out.println("0. Back");
       System.out.println("-------------------------------");
       System.out.println("Please choose a number: 0-1-2");
       int filterChoice = scanner.nextInt();
       switch (filterChoice){
       case 0: cartMenu(); //Back
       		break;
       case 1:	// By ID
            System.out.println("Enter media's ID: ");
            int filterID = scanner.nextInt();
            aCart.searchById(filterID);
            filterMenu();
            break;
       case 2:	//By Title
       		System.out.println("Enter media's title: ");
       		scanner.nextLine();
       		String filterTitle = scanner.nextLine();
       		aCart.searchByTitle(filterTitle);
       		filterMenu();
       		break;
       default:
       		System.out.println("Error, choose again");
       		filterMenu();
       }
   }

   public static void sortMenu(){
	   System.out.println("Options: ");
       System.out.println("-------------------------------");
       System.out.println("1. By Title");
       System.out.println("2. By Cost");
       System.out.println("0. Back");
       System.out.println("-------------------------------");
       System.out.println("Please choose a number: 0-1-2");
       int sortChoice = scanner.nextInt();
       switch (sortChoice){
       case 0: cartMenu(); //Back
       		break;
       case 1:	// Sort by Title
            aCart.sortByTitle();
            aCart.showCart();
            sortMenu();
            break;
       case 2:// Sort by Cost
            aCart.sortByCost();
            aCart.showCart();
            sortMenu();
            break;
       default:
            System.out.println("Error, choose again");
            sortMenu();
       }
   }
}



