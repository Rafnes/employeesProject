package pro.sky.homework18.service;

import org.springframework.stereotype.Service;
import pro.sky.homework18.employee.Employee;

import java.util.List;
import java.util.Map;

@Service
public interface DepartmentService {
    Employee getDeptMaxSalaryEmployee(int departmentId);

    Employee getDeptMinSalaryEmployee(int departmentId);

    List<Employee> getEmployeesByDept(int departmentId);

    Map<Integer, List<Employee>> getAllEmployees();
}
