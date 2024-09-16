package pro.sky.StreamApiAndOptional.service;

import pro.sky.StreamApiAndOptional.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    Employee addEmployee(String passportNumber,
                         String firstName,
                         String lastName,
                         int salary,
                         int depart);

    Employee removeEmployee(String passportNumber);

    Employee findEmployee(String passportNumber);

    Collection<Employee> findAll();
}
