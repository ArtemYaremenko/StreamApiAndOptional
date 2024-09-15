package pro.sky.StreamApiAndOptional.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.StreamApiAndOptional.exceptions.EmployeeNotFoundException;
import pro.sky.StreamApiAndOptional.model.Employee;
import pro.sky.StreamApiAndOptional.service.DepartmentService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee findMinSalaryEmployeeInDepart(String depart) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepart().equals(depart))
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMaxSalaryEmployeeInDepart(String depart) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepart().equals(depart))
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findEmployeesFromDepart(String depart) {
        return employeeService.findAll()
                .stream()
                .filter(e -> e.getDepart().equals(depart))
                .toList();
    }

    @Override
    public Map<String, List<Employee>> findEmployeesWithDepart() {
        return employeeService.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepart));
    }
}
