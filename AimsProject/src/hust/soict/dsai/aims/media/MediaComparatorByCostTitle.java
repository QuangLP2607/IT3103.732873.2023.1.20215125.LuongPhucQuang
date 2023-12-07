// Luong Phuc Quang 20215125
package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    // Comparator to sort by cost then by title
    private Comparator<Media> compoundComparator = Comparator
            .comparingDouble(Media::getCost)
            .thenComparing(Media::getTitle);

    // Compare method using compoundComparator
    public int compare(Media media1, Media media2) {
        return compoundComparator.compare(media1, media2);
    }
}

