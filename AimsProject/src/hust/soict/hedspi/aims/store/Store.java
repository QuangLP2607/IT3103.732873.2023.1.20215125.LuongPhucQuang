// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.store;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Represents a store containing a collection of Media items
public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    // Retrieves the list of items in the store
    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }

    // Adds a media item to the store
    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("Item added to the store: " + media);
    }

    // Removes a media item from the store
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("Media removed from the store: " + media.getTitle());
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    // Displays the contents of the store
    public void showStore() {
        int i = 1;
        System.out.println("*********************** Store ***********************");
        for (Media item : itemsInStore) {
            System.out.println(i++ + ". item - " + item.toString());
        }
        System.out.println("***************************************************");
    }

    // Searches for a media item by its title
    public Media searchByTitle(String title) {
        int count = 0;
        Media result = null;
        for (Media media : itemsInStore) {
            if (media.isMatch(title)) {
                System.out.println("Item - " + media.toString());
                result = media;
                count++;
            }
        }
        if (count == 0) {
            System.out.println("No results found");
            return null;
        }
        return result;
    }

    // Custom exception for the Store class
    public class StoreException extends RuntimeException {
        public StoreException(String message) {
            super(message);
        }
    }
}
