// Luong Phuc Quang 20215125
package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    private Comparator<Media> titleComparator = Comparator.comparing(Media::getTitle);
    private Comparator<Media> costComparator = Comparator.comparingDouble(Media::getCost);

    private Comparator<Media> compoundComparator = titleComparator.thenComparing(costComparator);

    public int compare(Media media1, Media media2) {
        return compoundComparator.compare(media1, media2);
    }
}


