package pro.sky.StreamApiAndOptional.service;

import pro.sky.StreamApiAndOptional.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee findMinSalaryEmployeeInDepart(int depart);

    Employee findMaxSalaryEmployeeInDepart(int depart);

    List<Employee> findEmployeesFromDepart(int depart);

    Map<Integer, List<Employee>> findEmployeesWithDepart();
}
