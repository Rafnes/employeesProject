package pro.sky.homework18.service;

import org.springframework.stereotype.Service;
import pro.sky.homework18.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    public final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getDeptMaxSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getDeptMinSalaryEmployee(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow();
    }

    public List<Employee> getEmployeesByDept(int departmentId) {
        return employeeService.getAllEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeService.getAllEmployees().stream()
                .collect(Collectors.groupingBy(e -> e.getDepartment()));
    }
}
