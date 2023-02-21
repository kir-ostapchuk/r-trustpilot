package by.ostapchuk.rtp.service;

import by.ostapchuk.rtp.dto.ReviewsDto;
import by.ostapchuk.rtp.exception.DomainNotFoundException;
import by.ostapchuk.rtp.parser.Parser;
import by.ostapchuk.rtp.property.CacheProperty;
import by.ostapchuk.rtp.trustpilot.TrustPilotClient;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewsService {

    private final Parser parser;
    private final TrustPilotClient client;
    private final CacheProperty cacheProperty;

    @Cacheable(value = "domains", key = "#domain")
    public Mono<ReviewsDto> findReviewsByDomain(final String domain) {
        return client.getPage(domain)
                .map(page -> retrieveReviewsFromPage(page, domain))
                .cache(cacheProperty.getExpiration());
    }

    private ReviewsDto retrieveReviewsFromPage(final String page, final String domain) {
        final Optional<Long> reviewsCount = parser.findReviewsCount(page);
        final Optional<Double> rating = parser.findRating(page);
        if (reviewsCount.isEmpty() || rating.isEmpty()) {
            throw new DomainNotFoundException(domain + " does not exist.");
        }
        return new ReviewsDto(reviewsCount.get(), rating.get());
    }
}
