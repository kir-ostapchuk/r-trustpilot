package by.ostapchuk.rtp.dto;

/**
 * This DTO is used to provide information of happened error.
 *
 * @param message
 * @param status
 * @param statusCode
 */
public record ErrorDto(String message, String status, int statusCode) {
}
