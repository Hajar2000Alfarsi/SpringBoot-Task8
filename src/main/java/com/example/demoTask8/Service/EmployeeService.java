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

    public Employee updateEmployee(Employee updateEmployee) throws Exception {
        Employee existingEmployee = employeeRepository.getEmployeeById(updateEmployee.getEmployeeId());

        if (existingEmployee != null) {
            if (!existingEmployee.getEmployeeName().equals(updateEmployee.getEmployeeName())) {
                existingEmployee.setEmployeeName(updateEmployee.getEmployeeName());
            }
            if (!existingEmployee.getDDepartment().equals(updateEmployee.getDDepartment())) {
                existingEmployee.setDDepartment(updateEmployee.getDDepartment());
            }
            return employeeRepository.save(existingEmployee);
        }
        throw new Exception ("Invalid Data");
    }

    public Boolean deleteEmployeeById(Integer id) {
        Employee employeeToDelete = employeeRepository.getEmployeeById(id);

        if (employeeToDelete !=  null) {
            employeeToDelete.setIsActive(false);
            employeeRepository.save(employeeToDelete);
            return true;
        } else {
            return false;
        }
    }

}
