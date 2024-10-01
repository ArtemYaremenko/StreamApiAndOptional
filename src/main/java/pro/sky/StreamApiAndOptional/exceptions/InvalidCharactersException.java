package pro.sky.StreamApiAndOptional.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCharactersException extends RuntimeException {

    public InvalidCharactersException() {
        super("Invalid characters in the first or the last name!");
    }
}
