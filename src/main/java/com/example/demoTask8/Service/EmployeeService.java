package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    List<Employee> employeeList = new ArrayList<>();

    @PostConstruct
    public void addEmployee() {
        employeeList.add(new Employee(101,"Ahmed","IT"));
        employeeList.add(new Employee(102,"Fatma","HR"));
        employeeList.add(new Employee(103,"Khawla","Operation"));
    }

    public List<Employee> DisplayEmployee() {
        return employeeList;
    }

    public boolean validateData(Integer id) {
        for (Employee employee : employeeList) {
            if (employee.getEmployeeId().equals(id)){
                return false;
            }
        }
        return false;
    }

    public String addEmployeeAfterValidation(Employee employee) {
        if (!validateData(employee.getEmployeeId())) {
            employeeList.add(employee);
            return "Employee Added Successfully";
        }
        return "Employee ID already exists.";
    }
}
