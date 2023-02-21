package by.ostapchuk.rtp.dto;

/**
 * This DTO is used to provide information related to reviews.
 *
 * @param reviewsCount
 * @param rating
 */
public record ReviewsDto(Long reviewsCount, Double rating) {
}
