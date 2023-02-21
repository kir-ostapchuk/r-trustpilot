package by.ostapchuk.rtp.exception;

/**
 * This exception should be thrown when no domain was found.
 */
public class DomainNotFoundException extends RuntimeException {
    public DomainNotFoundException(final String s) {
        super(s);
    }
}
