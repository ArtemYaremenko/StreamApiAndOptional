package pro.sky.StreamApiAndOptional.model;

import java.util.Objects;

public class Employee {

    private final String firstName;
    private final String lastName;
    private String salary;
    private String depart;

    public Employee(String firstName, String lastName, String salary, String depart) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.depart = depart;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSalary() {
        return salary;
    }

    public String getDepart() {
        return depart;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() != obj.getClass()) {
            return false;
        }
        Employee newEmployee = (Employee) obj;
        return firstName.equals(newEmployee.firstName) && lastName.equals(newEmployee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary='" + salary + '\'' +
                ", depart='" + depart + '\'' +
                '}';
    }
}