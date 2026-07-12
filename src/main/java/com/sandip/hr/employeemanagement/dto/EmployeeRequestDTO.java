package com.sandip.hr.employeemanagement.dto;

import com.sandip.hr.employeemanagement.enums.Department;
import jakarta.validation.constraints.*;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
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

