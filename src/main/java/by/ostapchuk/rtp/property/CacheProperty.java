package by.ostapchuk.rtp.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "cache")
public class CacheProperty {

    @DurationUnit(ChronoUnit.HOURS)
    private Duration expiration;
}
