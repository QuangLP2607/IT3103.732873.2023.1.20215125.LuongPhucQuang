// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    // Constructors for Media class
    public Media(int id, String title, String category, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost; 
        // TODO Auto-generated constructor stub
    }
    
    public Media(String title) {
        super();
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    // Getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public float getCost() {
        return cost;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }

    // Override equals method to compare titles
    public boolean equals(Media o) {
        // override equals, returns true if titles are the same
        if (title.equals(o.title)) {
            return true;
        } else {
            return false;
        }
    }
    
    // Check if a given string is contained in the title
    public boolean isMatch(String tit) {
        // Method to check if the title contains the string 'tit'
        return getTitle().contains(tit);
    }
    
    // Check if the given ID matches
    public boolean isMatchID(int id) {
        // Method to check if IDs match
        return (getId() == id);
    }
    
    // Default constructor
    public Media() {
        
    }
    
    // Override equals method to compare objects
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Media media = (Media) obj;
        return title.equals(media.title);
    }
}
