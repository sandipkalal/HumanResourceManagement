package com.sandip.hr.employeemanagement.repository;

import com.sandip.hr.employeemanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    Employee update(Employee employee);
    boolean deletedBy (Long id);
    boolean existsById(Long id);
    boolean existsByEmail(String email);
}