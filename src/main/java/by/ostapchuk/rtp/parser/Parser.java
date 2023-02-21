package by.ostapchuk.rtp.parser;

import java.util.Optional;

/**
 *
 */
public interface Parser {

    /**
     * Finds reviews count in the provided page.
     *
     * @param page source.
     * @return amount of reviews.
     */
    Optional<Long> findReviewsCount(String page);

    /**
     * Finds rating in the provided page.
     *
     * @param page source.
     * @return rating value.
     */
    Optional<Double> findRating(String page);
}
