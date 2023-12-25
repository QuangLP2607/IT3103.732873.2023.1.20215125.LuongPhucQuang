package hust.soict.hedspi.aims.screen.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.StoreScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AddDVDScreenController {
    
    private Store store;
    private Cart cart;

    @FXML
    private TextField Category;

    @FXML
    private TextField Cost;

    @FXML
    private TextField Director;

    @FXML
    private TextField Length;

    @FXML
    private TextField Title;
    
    // Attributes

    public AddDVDScreenController(Cart cart, Store store) {
        super();
        this.store = store;
        this.cart = cart;
    }
    // Constructor

    @FXML
    void addDVD(ActionEvent event) {
        // Button press to add DVD to the store
        if (Title.getText().equals("")) {
            // Checks for validity
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a title for the DVD.");
            alert.showAndWait();
            return; // Stops execution and prompts error if the DVD lacks a title
        }
        
        float cost;
        try {
            cost = Float.parseFloat(Cost.getText());
        } catch (NumberFormatException e) {
            // Alerts if the cost is invalid
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid cost for the DVD.");
            alert.showAndWait();
            return; 
        }
        
        int length;
        try {
            length = Integer.parseInt(Length.getText());
        } catch (NumberFormatException e) {
            // Alerts if the length is invalid
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid length for the DVD.");
            alert.showAndWait();
            return; 
        }
        DigitalVideoDisc dvd = new DigitalVideoDisc(Title.getText(),
                Category.getText(), Director.getText(), length, cost);
        store.addMedia(dvd);
        // Adds the DVD to the store
        // Displays success message
        showSuccessAlert("DVD added successfully.");

        // Resets all fields after adding
        resetFields();
    }

    
    private void showSuccessAlert(String message) {
        // Method to display successful addition message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void resetFields() {
        // Method to reset fields
        Title.clear();
        Category.clear();
        Cost.clear();
        Director.clear();
        Length.clear();
    }
    
    @FXML
    void viewStore(ActionEvent event) {
        StoreScreen Screen = new StoreScreen(store, cart);
    }
}
