package com.sandip.hr.employeemanagement.dto;

import java.time.LocalDate;

public class EmployeeResponseDTO {
    public long id;
    public String firstName;
    public String lastName;
    public String email;
    public Department department;
    public double salary;
    public LocalDate dateOfJoining;

    public EmployeeResponseDTO(long id, String firstName, String lastName, String email, Department department, double salary, LocalDate dateOfJoining) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }

    public EmployeeResponseDTO() {
    }
}