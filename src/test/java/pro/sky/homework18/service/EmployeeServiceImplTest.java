package pro.sky.homework18.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework18.exceptions.EmployeeNotFoundException;
import pro.sky.homework18.exceptions.EmployeeStorageIsFull;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {
    private final ValidationService validationService = new ValidationService();
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl(validationService);

    @BeforeEach
    void setUp() {
    }

    @Test
    void addShouldAddEmployeeWhenNameIsValid() {
        Employee employee = employeeService.add("Тимур", "Тестов", 1, 10000);
        assertNotNull(employee);
    }

    @Test
    void addShouldThrowEmployeeAlreadyAddedException() {
        employeeService.add("Тимур", "Тестов", 1, 10000);
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add("Тимур", "Тестов", 1, 10000));
    }


    @Test
    void addShouldThrowEmployeeStorageIsFullException() {
        char c = 'a';
        for (int i = 0; i < employeeService.getEmployeesStorageCapacity(); i++) {
            employeeService.add("Тимур" + c, "Тестов", 1, 10000);
            c++;
        }
        assertThrows(EmployeeStorageIsFull.class, () -> employeeService.add("", "", 1, 10000));
    }

    @Test
    void removeShouldRemoveEmployeeWhenEmployeeExists() {
        employeeService.add("Тимур", "Тестов", 1, 10000);
        Employee employeeToRemove = employeeService.remove("Тимур", "Тестов");
        assertNull(employeeToRemove);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Тимур", "Тестов"));
    }

    @Test
    void findShouldReturnEmployeeWhenEmployeeExists() {
        employeeService.add("Тимур", "Тестов", 1, 10000);
        Employee employeeToBeFound = employeeService.find("Тимур", "Тестов");
        assertNotNull(employeeToBeFound);
        assertEquals("Тимур", employeeToBeFound.getFirstName());
        assertEquals("Тестов", employeeToBeFound.getLastName());
    }

    @Test
    void findShouldThrowEmployeeNotFoundException() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.find("Тимур", "Тестов"));
    }
}