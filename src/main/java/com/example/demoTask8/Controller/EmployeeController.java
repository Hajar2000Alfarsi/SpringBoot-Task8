package com.example.demoTask8.Controller;

import com.example.demoTask8.Entity.Employee;
import com.example.demoTask8.Repository.EmployeeRepository;
import com.example.demoTask8.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PutMapping("addEmployee")
    public Employee addEmployee(Employee employee) {
        return employeeService.addEmployee(employee);
    }



}
