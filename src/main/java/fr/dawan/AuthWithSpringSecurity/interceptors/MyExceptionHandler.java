package fr.dawan.AuthWithSpringSecurity.interceptors;

import fr.dawan.AuthWithSpringSecurity.dtos.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleServletException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");

        APIError error = new APIError(HttpStatus.UNAUTHORIZED, ex.getMessage());
        return handleExceptionInternal(ex, error, headers, error.getCode(), request);
    }
}
