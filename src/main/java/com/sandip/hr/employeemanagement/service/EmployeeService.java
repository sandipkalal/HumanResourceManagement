package com.sandip.hr.employeemanagement.service;

import com.sandip.hr.employeemanagement.dto.EmployeeRequestDTO;
import com.sandip.hr.employeemanagement.dto.EmployeeResponseDTO;

import java.util.List;

public interface EmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO empRequestDTO);
    EmployeeResponseDTO getEmployeeById(Long id );
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO empRequestDTO);
    void deleteEmployee(Long id);
}