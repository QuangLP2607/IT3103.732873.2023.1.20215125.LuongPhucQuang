// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Media;
public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    
    public Store() {
    	itemsInStore = new ArrayList<>();
    }
    
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("item added to the store: " + media);
    }
    
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("DVD removed from the store: " + media.getTitle());
        } else {
            System.out.println("DVD not found in the store.");
        }
    }
    
    public void showStore()
    {   
        int i = 1;
        System.out.println("***********************Store***********************");
        for (Media item : itemsInStore) {
             System.out.println(i++ + ".item - " + item.toString());
        }
        System.out.println("***************************************************");
    }
	
	public Media searchByTitle(String Title) { 
        int count = 0;
        Media result = null;
        for (Media media : itemsInStore) {
            if (media.isMatch(Title)) {
                System.out.println("Item -" + media.toString());
                result = media;
                count ++;
            }   
       }
        if (count == 0){  
            System.out.println("No results found");
            return null;
        }
        return result;
    }
}