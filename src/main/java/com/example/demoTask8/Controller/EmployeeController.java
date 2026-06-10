package com.example.demoTask8.Controller;

import com.example.demoTask8.Entity.Employee;
import com.example.demoTask8.Repository.EmployeeRepository;
import com.example.demoTask8.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("add")
    public Employee AddEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @GetMapping("getAll")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("byId")
    public Employee getEmployeeById(@RequestParam Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("byName")
    public Employee getEmployeeByName(@RequestParam String name) {
        return employeeService.getEmployeeByName(name);
    }

    @PutMapping("Update")
    public Employee updateEmployee(@RequestBody Employee employee) throws Exception{
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("Delete")
    public Boolean deleteEmployee(@RequestParam Integer id) {
        return employeeService.deleteEmployeeById(id);
    }
}
