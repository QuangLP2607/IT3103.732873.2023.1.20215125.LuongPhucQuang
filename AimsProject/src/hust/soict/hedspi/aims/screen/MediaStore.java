// Luong Phuc Quang 20215125 
package hust.soict.hedspi.aims.screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import hust.soict.hedspi.aims.media.*;

public class MediaStore extends JPanel {
    private StoreScreen storeScreen;
    private Media media;
    // Attributes
    
    // Setter for StoreScreen
    public void setStoreScreen(StoreScreen storeScreen) {
        this.storeScreen = storeScreen;
    }
    
    // Constructor for MediaStore JPanel
    public MediaStore(Media media) {
        ButtonListener btnListener = new ButtonListener();
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Displaying title and cost of the media item
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);
        
        // Building the GUI
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton btnAdd = new JButton("Add to cart");
        btnAdd.addActionListener(btnListener);
        container.add(btnAdd);
        
        // If media is playable, display a 'Play' button
        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(btnListener);
            container.add(btnPlay);
        }
        
        // Adding components to the panel
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    
    // ActionListener for buttons
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("Add to cart")) {
                storeScreen.getCart().addMedia(media);
                // If 'Add to cart' button is pressed, add the media to the cart
            }
            if (button.equals("Play")) {
                // If 'Play' button is pressed, open a new window to play the media
                MediaPlayerDialog playDialog = new MediaPlayerDialog((JFrame) SwingUtilities.getWindowAncestor(MediaStore.this), true, media);
                playDialog.setVisible(true);
            }
        }
    }
}
