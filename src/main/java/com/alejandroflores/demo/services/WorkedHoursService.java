package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Employee;
import com.alejandroflores.demo.domain.WorkedHours;
import com.alejandroflores.demo.dtos.WorkedHoursDTO;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkedHoursService {
    Iterable<WorkedHours> getWorkedHoursByEmployeeId(Long id);
    WorkedHours insertWorkedHours(WorkedHoursDTO workedHoursDTO, Employee employee);
    Integer getTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate);
    Optional<WorkedHours> getWorkedHoursByEmployeeIdAndWorkedDate(Long id, LocalDate date);
}
