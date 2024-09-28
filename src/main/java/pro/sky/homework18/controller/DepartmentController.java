package pro.sky.homework18.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/salary/max")
    public Employee getMaxSalaryEmployeeInDept(@PathVariable("id") int departmentId) {
        return departmentService.getDeptMaxSalaryEmployee(departmentId);
    }

    @GetMapping("/{id}/salary/min")
    public Employee getMinSalaryEmployeeInDept(@PathVariable("id") int departmentId) {
        return departmentService.getDeptMinSalaryEmployee(departmentId);
    }

    @GetMapping("/{id}/salary/sum")
    public String getSalariesSumByDept(@PathVariable("id")int departmentId) {
        return departmentService.getSalariesSumByDept(departmentId);
    }

    @GetMapping("/{id}/employees")
    public List<Employee> getAllEmployeesInDept(@PathVariable("id") int departmentId) {
        return departmentService.getEmployeesByDept(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployees() {
        return departmentService.getAllEmployees();
    }
}
