package klg.backend.lukasz.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;


@RestControllerAdvice
public class ResponseExceptionHandler {
    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ErrorResponse> resourceNotFoundException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>(new ErrorResponse(ex),HttpStatus.BAD_REQUEST);
    }

}
