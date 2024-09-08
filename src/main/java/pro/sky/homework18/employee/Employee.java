package pro.sky.homework18.employee;

import org.apache.commons.lang3.StringUtils;
import pro.sky.homework18.exceptions.InvalidEmployeeNameException;

import static java.util.Objects.hash;

public class Employee {
    private String firstName;
    private String lastName;
    private int department;
    private int salary;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Employee(String firstName, String lastName, int department, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidEmployeeNameException();
        }
        StringUtils.capitalize(firstName);
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidEmployeeNameException();
        }
        StringUtils.capitalize(lastName);
        this.lastName = lastName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Employee employee = (Employee) obj;
        return this.firstName.equals(employee.firstName) && this.lastName.equals(employee.lastName) && this.department == employee.department && this.salary == employee.salary;
    }

    @Override
    public int hashCode() {
        return hash(firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return "Сотрудник{" +
                "Имя: '" + firstName + '\'' +
                ", Фамилия: " + lastName + '\'' +
                ", отдел: " + department +
                ", зарплата: " + salary +
                '}';
    }
}
