package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Employee;
import com.alejandroflores.demo.dtos.EmployeeDTO;

import java.util.Optional;
import java.util.Set;

public interface EmployeeService {
    Set<Employee> getEmployeesByJobID(Long id);
    Employee insertEmployee(EmployeeDTO employeeDTO);
    Optional<Employee> getEmployeeById(Long id);
    Optional<Employee> verifyEmployeeExist(String firstName, String lastName);
}
