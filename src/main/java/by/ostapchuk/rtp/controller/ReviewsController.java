package by.ostapchuk.rtp.controller;

import by.ostapchuk.rtp.dto.ReviewsDto;
import by.ostapchuk.rtp.service.ReviewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewsController {

    private final ReviewsService reviewsService;

    @GetMapping("/{domain}")
    public Mono<ReviewsDto> findReviewsByDomain(@PathVariable final String domain) {
        return reviewsService.findReviewsByDomain(domain);
    }
}
