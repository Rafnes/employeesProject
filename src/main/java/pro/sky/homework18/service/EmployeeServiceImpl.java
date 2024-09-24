package pro.sky.homework18.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework18.exceptions.EmployeeNotFoundException;
import pro.sky.homework18.exceptions.EmployeeStorageIsFull;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Map<String, Employee> employees = new HashMap<>();
    private final int EMPLOYEES_STORAGE_CAPACITY = 10;

    private final ValidationService validationService;

    public EmployeeServiceImpl(ValidationService validationService) {
        this.validationService = validationService;
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        if (employees.size() >= EMPLOYEES_STORAGE_CAPACITY) {
            throw new EmployeeStorageIsFull("Невозможно добавить сотрудника: достигнут лимит количества сотрудников");
        }

        validationService.validateName(firstName, lastName);
        StringUtils.capitalize(firstName);
        StringUtils.capitalize(lastName);
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeAlreadyAddedException("Невозможно добавить сотрудника: сотрудник с таким именем уже есть");
        }
        employees.put(employee.getFirstName() + " " + employee.getLastName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(firstName + " " + lastName)) {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
        employees.remove(firstName + " " + lastName);
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        StringUtils.capitalize(firstName);
        StringUtils.capitalize(lastName);
        Employee employee = new Employee(firstName, lastName, 0,0);
        if (employees.containsKey(firstName + " " + lastName)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>(employees.values());
        return list;
    }
}
