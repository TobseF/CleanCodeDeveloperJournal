package org.cleancode.journal.component;

import org.cleancode.journal.component.StarRating.Star;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StarRatingTest {

    @Test
    public void fourEmptyStars() {
        StarRating starRating = new StarRating(0, 4);
        assertEquals(4, starRating.getChildren().count());
        starRating.getStars().forEach(star -> assertTrue(star.isEmpty()));
    }

    @Test
    public void twoFilledStars() {
        StarRating starRating = new StarRating(2, 4);
        assertEquals(4, starRating.getChildren().count());
        List<Star> stars = starRating.getStars();

        assertTrue(stars.get(0).isFilled());
        assertTrue(stars.get(1).isFilled());
        assertTrue(stars.get(2).isEmpty());
        assertTrue(stars.get(3).isEmpty());
    }
}