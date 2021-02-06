package com.alejandroflores.demo.repositories;

import com.alejandroflores.demo.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Iterable<Employee> findAllByJobId(Long id);
    Optional<Employee> findEmployeeByNameAndLastName(String name, String lastName);
}
