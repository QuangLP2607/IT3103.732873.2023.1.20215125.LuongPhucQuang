// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.screen.view;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.screen.controller.AddCDScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCDScreen extends JFrame {

    private Store store;
    private Cart cart;

    public AddCDScreen(Cart cart, Store store) {
        super();
        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("AddingCD");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // Extend frame upon initialization
        this.setSize(new Dimension(1024, 768));
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Load the FXML file and execute
                    FXMLLoader loader = new FXMLLoader(getClass()
                            .getResource("/hust/soict/hedspi/aims/screen/view/AddCD.fxml"));
                    AddCDScreenController controller =
                            new AddCDScreenController(cart, store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
