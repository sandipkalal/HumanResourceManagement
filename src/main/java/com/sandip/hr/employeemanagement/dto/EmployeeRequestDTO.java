package com.sandip.hr.employeemanagement.dto;

import jakarta.validation.constraints.*;
import com.sandip.hr.employeemanagement.
import java.time.LocalDate;

public class EmployeeRequestDTO {
    @NotBlank(message = "Required")
    @Size(min = 2, max = 50, message = "Length min 2 char max 50 char")
    public String firstName;
    @NotBlank(message = "Required")
    @Size(min = 2, max = 50, message = "Length min 2 char max 50 char")    public String lastName;
    @NotBlank(message = "Required")
    @Email(message = "Required valid email")
    public String email;
    @NotBlank(message = "Required")
    public Department department;
    @NotBlank(message = "Required")
    @Positive(message = "Should be positive value")
    public double salary;
    @FutureOrPresent(message ="should be current or future date")
    public LocalDate dateOfJoining;

    public EmployeeRequestDTO() {
    }

    public EmployeeRequestDTO(String firstName, String lastName, String email, Department department, double salary, LocalDate dateOfJoining) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.dateOfJoining = dateOfJoining;
    }
}

