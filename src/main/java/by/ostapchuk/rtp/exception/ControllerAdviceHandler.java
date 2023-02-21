package by.ostapchuk.rtp.exception;

import by.ostapchuk.rtp.dto.ErrorDto;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ControllerAdviceHandler {

    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(DomainNotFoundException.class)
    public Mono<ErrorDto> handleDomainNotFoundException(final DomainNotFoundException exception) {
        return Mono.just(new ErrorDto(exception.getMessage(), NOT_FOUND.name(), NOT_FOUND.value()));
    }
}
