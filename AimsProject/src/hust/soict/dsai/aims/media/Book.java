// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();
	        // TODO Auto-generated constructor stub

    public Book(String title) {
        super(title);
    }
    public Book(String title, String category, float cost) {
        super(title,category,cost);
    }

	public void addAuthor(String authorName) {   
    	if ( authors.contains(authorName)) { 
    		System.out.println("The author name is already presented");
    		return;
    	}else {
    		authors.add(authorName);
    		System.out.println("Author's name has been added successfully");
    	}
	}
	    
	public void removeAuthor(String authorName)
	{   
		if (authors.contains(authorName)) { 
			authors.remove(authorName);
	    	System.out.println("The author's name has been removed successfully");
	    	return;
	  	}else {
	  		System.out.println("This author's name is not presented, can't remove it");
	  	}
	}
	
	public String toString() 
    {
		String cd;
        cd = getTitle() + " - " + getCategory() + " - "  + getCost();
        return cd;
    }

	public Book() {
             
    }
}







