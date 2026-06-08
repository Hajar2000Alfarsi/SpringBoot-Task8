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
        employeeList.add(new Employee("E101","Ahmed","IT"));
        employeeList.add(new Employee("E102","Fatma","HR"));
        employeeList.add(new Employee("E103","Khawla","Operation"));
    }

}
