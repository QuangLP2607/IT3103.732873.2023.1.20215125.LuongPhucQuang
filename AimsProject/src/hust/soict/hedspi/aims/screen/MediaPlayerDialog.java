// Luong Phuc Quang 20215125 
package hust.soict.hedspi.aims.screen;

import java.awt.Font;

import javax.swing.*;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class MediaPlayerDialog extends JDialog {	
    private static final long serialVersionUID = 1L;

    // Constructor for the media player dialog
    public MediaPlayerDialog(JFrame parent, boolean modal, Media media) {
        super(parent, modal);
        // Using StringBuilder to capture the play result
        StringBuilder playResult = new StringBuilder();
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);
        
        // Checking the type of media: CD or DVD
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            try {
                // If the media is playable, cast it and attempt to play, then append the result to playResult
                playResult.append(cd.play().toString());
            } catch (PlayerException e) {
                // Handle PlayerException
                System.err.println(e.getMessage());
                playResult.append(e.getMessage());
                e.printStackTrace(); 
                // Set title as error if there's a playback error
                setTitle("Error: " + e.getClass().getSimpleName());
            }
        } else if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            try {
                // Attempt to play the DVD and append the result to playResult
                playResult.append(dvd.play().toString());
            } catch (PlayerException e) {
                // Handle PlayerException
                System.err.println(e.getMessage());
                playResult.append(e.getMessage());
                e.printStackTrace(); 
                // Set title as error if there's a playback error
                setTitle("Error: " + e.getClass().getSimpleName());
            }
        }
        
        JTextArea playResultArea = new JTextArea(playResult.toString());
        playResultArea.setEditable(false);
        playResultArea.setLineWrap(true);
        playResultArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(playResultArea);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(title);
        getContentPane().add(scrollPane);

        // Set default title if none is provided
        if (getTitle() == null) {
            setTitle("Media Player");
        }
        
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }	
}
