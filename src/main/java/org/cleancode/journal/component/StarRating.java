package org.cleancode.journal.component;

import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import org.cleancode.journal.domain.grade.GradeRating;

import java.util.LinkedList;
import java.util.List;

/**
 * Bar of rating stars.
 */
public class StarRating extends HorizontalLayout {

    public final List<Star> stars = new LinkedList<>();

    public StarRating(GradeRating.Rating rating) {
        this(rating.getRating(), rating.getSize());
    }

    public StarRating(int rating, int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size must be a positive, but was " + size);
        }
        if (rating < 0) {
            throw new IllegalArgumentException("Rating must be a positive, but was " + rating);
        }
        if (rating > size) {
            throw new IllegalArgumentException("Size must be <= thant the number (" + size + "," + rating + ")");
        }
        setSizeUndefined();
        addStars(size, rating);
    }

    public List<Star> getStars() {
        return stars;
    }

    /**
     * Sets the width and the height of the star.
     * <p>
     * The size should be in a format understood by the browser, e.g. "100px" or
     * "2.5em".
     *
     * @param size the size to set, may be <code>null</code> to clear the value
     */
    public void setSize(String size) {
        stars.forEach(star -> star.setSize(size));
    }

    private void addStars(int number, int rating) {
        for (int i = 0; i < number; i++) {
            boolean isFilled = i < rating;
            if (isFilled) {
                addStar(StarColor.Filled);
            } else {
                addStar(StarColor.Empty);
            }
        }
    }

    public void addStar(StarColor color) {
        Star star = new Star(color);
        stars.add(star);
        add(star);
    }

    private enum StarColor {
        Filled("#F1CB14"), Empty("#ddd");
        private final String color;

        StarColor(String color) {
            this.color = color;
        }
    }

    public static class Star extends Icon {
        final StarColor starColor;

        public Star(StarColor starColor) {
            super(VaadinIcon.STAR);
            this.starColor = starColor;
            setColor(starColor.color);
        }

        public boolean isEmpty() {
            return starColor == StarColor.Empty;
        }

        public boolean isFilled() {
            return starColor == StarColor.Filled;
        }
    }
}
