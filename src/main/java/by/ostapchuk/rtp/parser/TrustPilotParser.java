package by.ostapchuk.rtp.parser;

import by.ostapchuk.rtp.exception.HtmlParseException;
import by.ostapchuk.rtp.util.NumberUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * A concrete implementation of Parser for Trustpilot website.
 * See this <a href="https://www.trustpilot.com/">Trustpilot</a>
 */
@Component
public class TrustPilotParser implements Parser {

    @Override
    public Optional<Long> findReviewsCount(final String page) {
        final String reviewsCountQuery = "span[role]";
        return firstFromPageByQuery(page, reviewsCountQuery)
                .map(Element::firstElementChild)
                .map(this::firstNode)
                .map(Node::toString)
                .map(NumberUtils::parseNumber);
    }

    @Override
    public Optional<Double> findRating(final String page) {
        final String ratingQuery = "p[data-rating-typography]";
        return firstFromPageByQuery(page, ratingQuery)
                .map(this::firstNode)
                .map(Node::toString)
                .map(Double::parseDouble);
    }

    private Optional<Element> firstFromPageByQuery(final String page, final String query) {
        return Optional.of(Jsoup.parse(page))
                .map(d -> d.select(query).first());
    }

    private Node firstNode(final Element element) {
        if (element.childNodeSize() == 0) {
            throw new HtmlParseException("Cannot retrieve node: size of children nodes is 0");
        }
        return element.childNode(0);
    }
}
