package com.example.demoTask8.Repository;

import com.example.demoTask8.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("Select e from Employee e where e.isActive=true")
    List<Employee> getAllActiveEmployee();

    @Query("Select e from Employee e where e.isActive=true AND e.employeeId=:id")
    Employee getEmployeeById(@Param("id") Integer id);

    @Query("Select e from Employee e where e.isActive=true AND e.employeeName=:nm")
    Employee getEmployeeByName(@Param("nm") String name);
}
