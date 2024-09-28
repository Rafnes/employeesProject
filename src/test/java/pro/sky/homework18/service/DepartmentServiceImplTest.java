package pro.sky.homework18.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework18.employee.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    Employee employee1;
    Employee employee2;
    Employee employee3;
    Employee employee4;

    @BeforeEach
    public void setUp() {
        employee1 = new Employee("Тимур", "Тестов", 1, 10000);
        employee2 = new Employee("Олег", "Олегов", 1, 20000);
        employee3 = new Employee("Анна", "Анютина", 2, 30000);
        employee4 = new Employee("Павел", "Павлов", 2, 40000);
    }

    @Test
    public void testDeptMaxSalaryEmployee() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        Employee employeeExpected1 = employee2;
        Employee employeeExpected2 = employee4;

        assertEquals(departmentService.getDeptMaxSalaryEmployee(1), employeeExpected1);
        assertEquals(departmentService.getDeptMaxSalaryEmployee(2), employeeExpected2);
        verify(employeeService, times(2)).getAllEmployees();
    }

    @Test
    public void testDeptMinSalaryEmployee() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        Employee employeeExpected1 = employee1;
        Employee employeeExpected2 = employee3;

        assertEquals(departmentService.getDeptMinSalaryEmployee(1), employeeExpected1);
        assertEquals(departmentService.getDeptMinSalaryEmployee(2), employeeExpected2);
        verify(employeeService, times(2)).getAllEmployees();
    }

    @Test
    public void testGetMaxAndMinSalaryThrowsIfDepartmentIsEmpty() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        assertThrows(Throwable.class, () -> departmentService.getDeptMaxSalaryEmployee(0));
        assertThrows(Throwable.class, () -> departmentService.getDeptMinSalaryEmployee(0));
    }

    @Test
    public void testGetSalariesSumByDept() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));
        String expected1 = "Сумма зарплат по департаменту 1: 30000";
        String expected2 = "Сумма зарплат по департаменту 2: 70000";

        assertEquals(expected1, departmentService.getSalariesSumByDept(1));
        assertEquals(expected2, departmentService.getSalariesSumByDept(2));
        verify(employeeService, times(2)).getAllEmployees();

    }

    @Test
    public void testGetEmployeesByDept() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));

        List<Employee> expected1 = List.of(employee1, employee2);
        List<Employee> expected2 = List.of(employee3, employee4);

        assertEquals(expected1, departmentService.getEmployeesByDept(1));
        assertEquals(expected2, departmentService.getEmployeesByDept(2));
        verify(employeeService, times(2)).getAllEmployees();
    }

    @Test
    public void testGetEmployeesByDeptReturnsEmptyListWhenDeptIsEmpty() {
        when(employeeService.getAllEmployees()).thenReturn(Arrays.asList(employee1, employee2, employee3, employee4));

        List expected = Collections.EMPTY_LIST;

        assertEquals(expected, departmentService.getEmployeesByDept(0));
        verify(employeeService, times(1)).getAllEmployees();
    }
}