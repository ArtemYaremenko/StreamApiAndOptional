package pro.sky.StreamApiAndOptional.service;

import pro.sky.StreamApiAndOptional.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMinSalaryEmployeeInDepart(String depart);

    Employee findMaxSalaryEmployeeInDepart(String depart);

    List<Employee> findEmployeesFromDepart(String depart);

    Map<String, List<Employee>> findEmployeesWithDepart();
}
