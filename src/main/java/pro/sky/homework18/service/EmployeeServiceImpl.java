package pro.sky.homework18.service;

import org.springframework.stereotype.Service;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework18.exceptions.EmployeeNotFoundException;
import pro.sky.homework18.exceptions.EmployeeStorageIsFull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
            new Employee("Тимур", "Тленов"),
            new Employee("Лев", "Ручалов"),
            new Employee("Юлия", "Шунина"),
            new Employee("Кристина", "Неделина")
    ));
    private final int EMPLOYEES_STORAGE_CAPACITY = 10;

    @Override
    public Employee add(String firstName, String lastName) {
        if (employees.size() >= EMPLOYEES_STORAGE_CAPACITY) {
            throw new EmployeeStorageIsFull("Невозможно добавить сотрудника: достигнут лимит количества сотрудников");
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Невозможно добавить сотрудника: сотрудник с таким именем уже есть");
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
        }
        employees.remove(employee);
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник с таким именем не найден");
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
