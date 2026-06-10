package com.example.demoTask8.Service;

import com.example.demoTask8.Entity.Employee;
import com.example.demoTask8.Repository.EmployeeRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {

        Employee newEmployee = new Employee();

        newEmployee.setEmployeeName(employee.getEmployeeName());
        newEmployee.setDDepartment(employee.getDDepartment());
        newEmployee.setIsActive(true);

        return employeeRepository.save(newEmployee);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllActiveEmployee();
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.getEmployeeByName(name);
    }



}
