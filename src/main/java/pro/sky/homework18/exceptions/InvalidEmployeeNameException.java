package pro.sky.homework18.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidEmployeeNameException extends RuntimeException {
    public InvalidEmployeeNameException() {
    }
    public InvalidEmployeeNameException(String message) {
        super(message);
    }
}
