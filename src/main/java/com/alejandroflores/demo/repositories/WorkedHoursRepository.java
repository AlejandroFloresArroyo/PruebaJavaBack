package com.alejandroflores.demo.repositories;

import com.alejandroflores.demo.domain.WorkedHours;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface WorkedHoursRepository extends CrudRepository<WorkedHours, Long> {
    Iterable<WorkedHours> findAllByEmployeeId(Long id);
    Optional<WorkedHours> findByEmployeeIdAndWorkedDate(Long id, LocalDate date);
}
