package pro.sky.StreamApiAndOptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamApiAndOptional.model.Employee;
import pro.sky.StreamApiAndOptional.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam("departmentId") String depart) {
        return departmentService.findMaxSalaryEmployeeInDepart(depart);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam("departmentId") String depart) {
        return departmentService.findMinSalaryEmployeeInDepart(depart);
    }

    @GetMapping("/all-department")
    public List<Employee> allEmployeesFromDepart(@RequestParam("departmentId") String depart) {
        return departmentService.findEmployeesFromDepart(depart);
    }

    @GetMapping("/all")
    public Map<String, List<Employee>> allEmployeesWithDepart() {
        return departmentService.findEmployeesWithDepart();
    }
}
