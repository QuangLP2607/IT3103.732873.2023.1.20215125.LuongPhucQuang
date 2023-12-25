// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.screen.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;

import java.util.function.Predicate;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import hust.soict.hedspi.aims.*;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.screen.MediaPlayerDialog;
import hust.soict.hedspi.aims.screen.StoreScreen;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CartScreenController {

    private Cart cart; // Cart object handling media items in the cart
    private Store store; // Store object handling store functionalities
    
    // UI Elements
    // Buttons for media playback and removal
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    
    @FXML
    private TableView<Media> tblMedia; // Table view to display media items
    
    // Table columns for media details
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    
    // Radio buttons and text field for filtering media
    @FXML
    private RadioButton radioBtnFilterId;
    @FXML
    private RadioButton radioBtnFilterTitle;
    @FXML
    private TextField tfFilter;
    
    private FilteredList<Media> filteredMediaList; // Filtered media list based on user input
    
    @FXML
    private Label totalCost; // Label displaying the total cost of items in the cart
    @FXML
    private Button placeOrder; // Button to place the order
    
    // Constructor for the CartScreenController
    public CartScreenController(Cart cart, Store store) {
        super();
        this.cart = cart;
        this.store = store;
        this.filteredMediaList = new FilteredList<>(cart.getItemsOrdered());
    }
    
    // Initialize method executed after loading the FXML file
    @FXML
    private void initialize() {
        // Initialize UI elements and their behavior
        
        // Set cell value factories for table columns
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost")); 
        
        // Set items for the table view
        tblMedia.setItems(this.cart.getItemsOrdered());
        
        // Hide play and remove buttons initially
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        
        // Add a listener to respond to changes in selected media
        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            });
        
        // Create toggle groups for radio buttons
        ToggleGroup toggleGroup = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(toggleGroup);
        radioBtnFilterTitle.setToggleGroup(toggleGroup);
        radioBtnFilterTitle.setSelected(true); // Set default filter by title
        
        // Add a listener to filter media based on user input
        tfFilter.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (toggleGroup.getSelectedToggle() == radioBtnFilterTitle) {
                showFilteredMedia(item -> item.isMatch(newValue.toLowerCase()));
            } else if (toggleGroup.getSelectedToggle() == radioBtnFilterId) {
                try {
                    int id = Integer.parseInt(newValue);
                    showFilteredMedia(item -> item.isMatchID(id));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid ID format");
                }
            }
        });
        
        // Bind the total cost label to the cart's total cost property for automatic updates
        totalCost.textProperty().bind(Bindings.createStringBinding(() ->
                String.format("%.2f$", cart.getTotalCostProperty().get()),
                cart.getTotalCostProperty()));
    }
    
    // Action handling placing an order
    @FXML
    void placeOrderPressed(ActionEvent event) {
        // Display an order placed confirmation message and empty the cart
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText(null);
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
        cart.emptyCart();
    }
    
    // Method to filter the media list based on a given predicate
    @FXML
    private void showFilteredMedia(Predicate<Media> filter) {
        FilteredList<Media> filteredList = new FilteredList<>(cart.getItemsOrdered(), filter);
        tblMedia.setItems(filteredList);
    }
    
    // Action handling the removal of a media item from the cart
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem(); 
        cart.removeMedia(media);
    }
    
    // Method to update the button bar based on the selected media
    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
    
    // Action handling media playback
    @FXML
    void playMedia(ActionEvent event) {
        MediaPlayerDialog playDialog = new MediaPlayerDialog((JFrame) null, true, tblMedia.getSelectionModel().getSelectedItem());
        playDialog.setVisible(true);    
    }
    
    // Action to view the store
    @FXML
    void viewStore(ActionEvent event) {
        StoreScreen screen = new StoreScreen(store, cart);
    }
}
