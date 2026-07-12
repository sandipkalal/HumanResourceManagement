package com.sandip.hr.employeemanagement.service;

import com.sandip.hr.employeemanagement.dto.EmployeeRequestDTO;
import com.sandip.hr.employeemanagement.dto.EmployeeResponseDTO;
import com.sandip.hr.employeemanagement.exception.DuplicateEmailException;
import com.sandip.hr.employeemanagement.exception.EmployeeNotFoundException;
import com.sandip.hr.employeemanagement.model.Employee;
import com.sandip.hr.employeemanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(
            EmployeeRepository employeeRepository
    ) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO createEmployee(
            EmployeeRequestDTO requestDTO
    ) {

        if (employeeRepository.existsByEmail(
                requestDTO.getEmail()
        )) {
            throw new DuplicateEmailException(
                    "Employee already exists with email: "
                            + requestDTO.getEmail()
            );
        }

        Employee employee = mapToEmployee(requestDTO);

        Employee savedEmployee =
                employeeRepository.save(employee);

        return mapToResponseDTO(savedEmployee);
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with id: " + id
                        )
                );

        return mapToResponseDTO(employee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO requestDTO
    ) {

        Employee existingEmployee =
                employeeRepository.findById(id)
                        .orElseThrow(() ->
                                new EmployeeNotFoundException(
                                        "Employee not found with id: "
                                                + id
                                )
                        );

        boolean emailChanged =
                !existingEmployee.getEmail()
                        .equalsIgnoreCase(
                                requestDTO.getEmail()
                        );

        if (emailChanged
                && employeeRepository.existsByEmail(
                        requestDTO.getEmail()
                )) {

            throw new DuplicateEmailException(
                    "Employee already exists with email: "
                            + requestDTO.getEmail()
            );
        }

        existingEmployee.setFirstName(
                requestDTO.getFirstName()
        );

        existingEmployee.setLastName(
                requestDTO.getLastName()
        );

        existingEmployee.setEmail(
                requestDTO.getEmail()
        );

        existingEmployee.setDepartment(
                requestDTO.getDepartment()
        );

        existingEmployee.setSalary(
                requestDTO.getSalary()
        );

        existingEmployee.setDateOfJoining(
                requestDTO.getDateOfJoining()
        );

        Employee updatedEmployee =
                employeeRepository.update(existingEmployee);

        return mapToResponseDTO(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {

        boolean deleted =
                employeeRepository.deletedById(id);

        if (!deleted) {
            throw new EmployeeNotFoundException(
                    "Employee not found with id: " + id
            );
        }
    }

    private Employee mapToEmployee(
            EmployeeRequestDTO requestDTO
    ) {

        Employee employee = new Employee();

        employee.setFirstName(
                requestDTO.getFirstName()
        );

        employee.setLastName(
                requestDTO.getLastName()
        );

        employee.setEmail(
                requestDTO.getEmail()
        );

        employee.setDepartment(
                requestDTO.getDepartment()
        );

        employee.setSalary(
                requestDTO.getSalary()
        );

        employee.setDateOfJoining(
                requestDTO.getDateOfJoining()
        );

        return employee;
    }

    private EmployeeResponseDTO mapToResponseDTO(
            Employee employee
    ) {

        EmployeeResponseDTO responseDTO =
                new EmployeeResponseDTO();

        responseDTO.setId(
                employee.getId()
        );

        responseDTO.setFirstName(
                employee.getFirstName()
        );

        responseDTO.setLastName(
                employee.getLastName()
        );

        responseDTO.setEmail(
                employee.getEmail()
        );

        responseDTO.setDepartment(
                employee.getDepartment()
        );

        responseDTO.setSalary(
                employee.getSalary()
        );

        responseDTO.setDateOfJoining(
                employee.getDateOfJoining()
        );

        return responseDTO;
    }
}