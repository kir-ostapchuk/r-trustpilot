# r-trustpilot

Simple service for counting reviews and rating by parsing Trustpilot

Starting and testing time:
1. Set profile to {dev} before start
2. Run the application
3. First call http://localhost:8080/reviews/gullwingmotor.com -> will be parsed
4. Second call http://localhost:8080/reviews/gullwingmotor.com -> will take from cache
5. http://localhost:8080/reviews/gASullwingasmotor.com -> will return 404 in a good manner

Tech:
- Spring Boot 3.0
- Spring WebFlux
- Spring Cache
- Caffeine
- Lombok
- Jsoup
- SpringDoc
