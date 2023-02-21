package by.ostapchuk.rtp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RtpApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtpApplication.class, args);
    }

}
