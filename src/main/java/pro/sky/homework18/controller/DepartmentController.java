package pro.sky.homework18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getMaxSalaryEmployeeInDept(@RequestParam("departmentId") int departmentId) {
        return departmentService.getDeptMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getMinSalaryEmployeeInDept(@RequestParam("departmentId") int departmentId) {
        return departmentService.getDeptMinSalaryEmployee(departmentId);
    }

    @GetMapping("/all-by-dept")
    public List<Employee> getAllEmployeesInDept(@RequestParam("departmentId") int departmentId) {
        return departmentService.getEmployeesByDept(departmentId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
