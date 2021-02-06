package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Employee;
import com.alejandroflores.demo.dtos.EmployeeDTO;
import com.alejandroflores.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;
    private final GenderService genderService;
    private final JobService jobService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, GenderService genderService, JobService jobService) {
        this.employeeRepository = employeeRepository;
        this.genderService = genderService;
        this.jobService = jobService;
    }

    @Override
    public Set<Employee> getEmployeesByJobID(Long id) {
        Set<Employee> employeeSet = new HashSet<>();
        employeeRepository.findAllByJobId(id).iterator().forEachRemaining(employeeSet::add);
        return employeeSet;
    }

    @Override
    public Employee insertEmployee(EmployeeDTO employeeDTO) {
        if (!genderService.isGender(employeeDTO.getGender_id()))
            return null;

        if (!jobService.isJob(employeeDTO.getJob_id()))
            return null;

        if (verifyEmployeeExist(employeeDTO.getName(), employeeDTO.getLast_name()).isPresent())
            return null;

        Employee employee = new Employee();
        employee.setBirthdate(employeeDTO.getBirthdate());
        employee.setName(employeeDTO.getName());
        employee.setLastName(employeeDTO.getLast_name());
        employee.setJob(jobService.getJobByID(employeeDTO.getJob_id()));
        employee.setGender(genderService.getGenderById(employeeDTO.getGender_id()));

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Optional<Employee> verifyEmployeeExist(String firstName, String lastName) {
        return employeeRepository.findEmployeeByNameAndLastName(firstName, lastName);
    }
}
