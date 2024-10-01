package pro.sky.StreamApiAndOptional.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.StreamApiAndOptional.exceptions.EmployeeAlreadyAddedException;
import pro.sky.StreamApiAndOptional.exceptions.EmployeeNotFoundException;
import pro.sky.StreamApiAndOptional.exceptions.InvalidCharactersException;
import pro.sky.StreamApiAndOptional.model.Employee;
import pro.sky.StreamApiAndOptional.model.Passport;
import pro.sky.StreamApiAndOptional.service.EmployeeService;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    public HashMap<Passport, Employee> employeeBook;

    public EmployeeServiceImpl() {
        this.employeeBook = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String passportNumber,
                                String firstName,
                                String lastName,
                                int salary,
                                int depart) {
        firstName = checkString(firstName);
        lastName = checkString(lastName);
        firstName = validateString(firstName);
        lastName = validateString(lastName);
        Passport newPassport = new Passport(passportNumber);
        Employee newEmployee = new Employee(firstName, lastName, salary, depart);
        if (employeeBook.containsKey(newPassport)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeBook.put(newPassport, newEmployee);
            return newEmployee;
        }
    }

    @Override
    public Employee removeEmployee(String passportNumber) {
        Passport removedByPassport = new Passport(passportNumber);
        Employee removedEmployee = employeeBook.get(removedByPassport);
        if (employeeBook.containsKey(removedByPassport)) {
            employeeBook.remove(removedByPassport);
            return removedEmployee;
        } else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee findEmployee(String passportNumber) {
        Passport foundEmployee = new Passport(passportNumber);
        if (!employeeBook.containsKey(foundEmployee)) {
            throw new EmployeeNotFoundException();
        } else {
            return employeeBook.get(foundEmployee);
        }
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employeeBook.values());
    }

    public String checkString(String string) {
        if (!StringUtils.isAlpha(string)) {
            throw new InvalidCharactersException();
        }
        return string;
    }

    public String validateString(String string) {
        StringUtils.toRootLowerCase(string);
        return StringUtils.capitalize(string);
    }
}
