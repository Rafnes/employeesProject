package pro.sky.homework18.service;

import org.springframework.stereotype.Service;
import pro.sky.homework18.employee.Employee;

import java.util.List;

@Service
public interface DepartmentService {
    Employee getDeptMaxSalaryEmployee(int departmentId);

    Employee getDeptMinSalaryEmployee(int departmentId);

    List<Employee> getEmployeesByDept(int departmentId);

    List<Employee> getAllEmployees();
}
