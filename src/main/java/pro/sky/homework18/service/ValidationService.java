package pro.sky.homework18.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import pro.sky.homework18.exceptions.InvalidEmployeeNameException;

@Component
public class ValidationService {
    public void validateName(String... strings) {
        for (String s : strings) {
            if (!StringUtils.isAlpha(s)) {
                throw new InvalidEmployeeNameException();
            }
        }
    }
}
