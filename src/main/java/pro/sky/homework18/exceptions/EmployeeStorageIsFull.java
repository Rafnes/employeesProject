package pro.sky.homework18.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeStorageIsFull extends RuntimeException {
    public EmployeeStorageIsFull() {
        super();
    }

    public EmployeeStorageIsFull(String message) {
        super(message);
    }
}
