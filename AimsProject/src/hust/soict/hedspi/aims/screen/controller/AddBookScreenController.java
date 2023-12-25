// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.screen.controller;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.screen.StoreScreen;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class AddBookScreenController {
    
    private Store store;
    private Cart cart;
    @FXML
    private TextField Category;

    @FXML
    private TextField Cost;

    @FXML
    private TextField Title;
    
    @FXML
    private TextField author1;
    
    private List<TextField> authorFields = new ArrayList<>();
    
    @FXML
    private VBox authorContainer;
    
    // Attributes
    
    public AddBookScreenController(Cart cart, Store store) {
        super();
        this.store = store;
        this.cart = cart;
    }
    // Constructor

    @FXML
    void addAuthor(ActionEvent event) {
        // Performs when adding multiple authors to a book, creates additional text fields for input
        TextField newAuthorField = new TextField();
        newAuthorField.setPrefWidth(250.0);
        authorContainer.getChildren().add(newAuthorField);
        authorFields.add(newAuthorField);
    }

    @FXML
    void addBook(ActionEvent event) {  
        // Button press to add a book to the store
        if (Title.getText().equals("")) {
            // Checks for validity
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a title for the book.");
            alert.showAndWait();
            return; // Stops execution and prompts error if the book lacks a title
        }
        
        float cost;
        try {
            cost = Float.parseFloat(Cost.getText());
        } catch (NumberFormatException e) {
            // Alerts if the cost is invalid
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a valid cost for the book.");
            alert.showAndWait();
            return; 
        }
        Book book = new Book(Title.getText(), Category.getText(), cost);
        book.addAuthor(author1.getText());
        for (TextField author : authorFields)
        {
            book.addAuthor(author.getText());
            // Iterates through the authors and adds them
        }
        store.addMedia(book);
        
        // Displays success message
        showSuccessAlert("Book added successfully.");

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
        author1.clear();
        authorContainer.getChildren().clear();
        authorFields.clear();
        
        TextField firstAuthorField = new TextField();
        firstAuthorField.setPrefWidth(250.0);
        authorContainer.getChildren().add(firstAuthorField);
        authorFields.add(firstAuthorField);
    }
    
    @FXML
    void viewStore(ActionEvent event) {
        StoreScreen Screen = new StoreScreen(store,cart);
        // Returns to the store
        
    }

}
