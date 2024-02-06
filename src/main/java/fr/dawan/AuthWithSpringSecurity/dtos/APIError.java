package fr.dawan.AuthWithSpringSecurity.dtos;

import lombok.Value;
import org.springframework.http.HttpStatus;

@Value
public class APIError {
    HttpStatus code;
    String message;
}
