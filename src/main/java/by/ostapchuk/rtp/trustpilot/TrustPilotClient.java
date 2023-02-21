package by.ostapchuk.rtp.trustpilot;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Component
@RequiredArgsConstructor
public class TrustPilotClient {

    private final WebClient client;

    public Mono<String> getPage(final String domain) {
        return client.get().uri(domain).exchangeToMono(r -> r.bodyToMono(String.class))
                .retryWhen(Retry.backoff(2, Duration.ofMillis(25)).filter(TimeoutException.class::isInstance));
    }
}
