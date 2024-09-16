package pro.sky.StreamApiAndOptional.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.StreamApiAndOptional.model.Employee;
import pro.sky.StreamApiAndOptional.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("passportnumber") String passportNumber,
                        @RequestParam("firstname") String firstName,
                        @RequestParam("lastname") String lastName,
                        @RequestParam("salary") int salary,
                        @RequestParam("depart") int depart) {
        return employeeService.addEmployee(passportNumber, firstName, lastName, salary, depart);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("passportnumber") String passportNumber) {
        return employeeService.removeEmployee(passportNumber);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam("passportnumber") String passportNumber) {
        return employeeService.findEmployee(passportNumber);
    }
}
