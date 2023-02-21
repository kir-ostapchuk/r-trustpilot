package by.ostapchuk.rtp.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.text.NumberFormat;

/**
 * A helper class to deal with numbers parsing.
 */
@UtilityClass
public class NumberUtils {

    /**
     * Parses a number from string because of commas in the value.
     *
     * @param value number with commas.
     * @return actual value.
     */
    @SneakyThrows
    public Long parseNumber(final String value) {
        return (Long) NumberFormat.getNumberInstance(java.util.Locale.US).parse(value);
    }
}
