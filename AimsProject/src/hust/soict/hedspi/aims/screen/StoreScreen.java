// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.screen.view.AddBookScreen;
import hust.soict.hedspi.aims.screen.view.AddCDScreen;
import hust.soict.hedspi.aims.screen.view.AddDVDScreen;
import hust.soict.hedspi.aims.screen.view.CartScreen;
import javafx.collections.ObservableList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;
    // Attributes for store and cart

    public Store getStore() {
        return store;
    }

    public Cart getCart() {
        return cart;
    }
    // Getter methods

    JPanel createNorth() {
        // Creates the top panel of the UI
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        // Creates the menu bar with options
        ButtonListener btnListener = new ButtonListener();
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");

        // Add action listener to switch to the add book screen
        smUpdateStore.add(addBook);
        addBook.addActionListener(btnListener);

        JMenuItem addCD = new JMenuItem("Add CD");

        // Add action listener to switch to the add CD screen
        smUpdateStore.add(addCD);
        addCD.addActionListener(btnListener);

        JMenuItem addDVD = new JMenuItem("Add DVD");

        // Add action listener to switch to the add DVD screen
        smUpdateStore.add(addDVD);
        addDVD.addActionListener(btnListener);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        JMenuItem cart = new JMenuItem("View cart");

        // Add action listener to switch to the view cart screen
        menu.add(cart);
        cart.addActionListener(btnListener);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        // Creates the header section
        ButtonListener btnListener = new ButtonListener();
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);
        // Design the title

        JButton cart = new JButton("View cart");
        cart.addActionListener(btnListener);

        // Create the view cart button and add a listener
        cart.setPreferredSize(new Dimension(100, 50));
        cart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    JPanel createCenter() {
        // Creates the center section displaying the media items
        JPanel center = new JPanel();

        ObservableList<Media> mediaInStore = store.getItemsInStore();
        int size = mediaInStore.size();
        int rows = (int) Math.sqrt(size) + 1;
        center.setLayout(new GridLayout(rows, rows, 2, 2));

        for (int i = 0; i < size; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            cell.setStoreScreen(this);
            center.add(cell);
        }
        return center;
    }

    public StoreScreen(Store store, Cart cart) {
        // Constructor initializing StoreScreen
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    private class ButtonListener implements ActionListener {
        // ActionListener method
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View cart")) {
                // Switch to cart screen
                CartScreen aCart = new CartScreen(cart, store);
                dispose();
            }
            if (button.equals("Add Book")) {
                // Switch to add book screen
                AddBookScreen addBook = new AddBookScreen(cart, store);
            }
            if (button.equals("Add DVD")) {
                // Switch to add DVD screen
                AddDVDScreen addDVD = new AddDVDScreen(cart, store);
            }
            if (button.equals("Add CD")) {
                // Switch to add CD screen
                AddCDScreen addCD = new AddCDScreen(cart, store);
            }
        }
    }
}
