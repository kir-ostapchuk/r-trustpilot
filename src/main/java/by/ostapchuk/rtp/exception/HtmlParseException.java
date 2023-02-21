package by.ostapchuk.rtp.exception;

/**
 * This exception should be thrown when {@link by.ostapchuk.rtp.parser.Parser} cannot parse data.
 */
public class HtmlParseException extends RuntimeException {
    public HtmlParseException(final String s) {
        super(s);
    }
}
