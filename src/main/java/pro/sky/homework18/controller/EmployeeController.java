package pro.sky.homework18.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework18.employee.Employee;
import pro.sky.homework18.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam(required = false, value = "firstName") String firstName,
                        @RequestParam(required = false, value = "lastName") String lastName) {
        return employeeService.add(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(required = false, value = "firstName") String firstName,
                           @RequestParam(required = false, value = "lastName") String lastName) {
        return employeeService.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(required = false, value = "firstName") String firstName,
                         @RequestParam(required = false, value = "lastName") String lastName) {
        return employeeService.find(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
