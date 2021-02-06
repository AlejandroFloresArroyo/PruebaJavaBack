package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Employee;
import com.alejandroflores.demo.domain.WorkedHours;
import com.alejandroflores.demo.dtos.WorkedHoursDTO;
import com.alejandroflores.demo.repositories.WorkedHoursRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.logging.SocketHandler;

@Service
public class WorkedHoursServiceImpl implements WorkedHoursService{

    private final WorkedHoursRepository workedHoursRepository;

    public WorkedHoursServiceImpl(WorkedHoursRepository workedHoursRepository) {
        this.workedHoursRepository = workedHoursRepository;
    }

    @Override
    public Iterable<WorkedHours> getWorkedHoursByEmployeeId(Long id) {
        return workedHoursRepository.findAllByEmployeeId(id);
    }

    @Override
    public WorkedHours insertWorkedHours(WorkedHoursDTO workedHoursDTO, Employee employee) {
        WorkedHours workedHours = new WorkedHours();
        workedHours.setWorkedHours(workedHoursDTO.getWorked_hours());
        workedHours.setWorkedDate(workedHoursDTO.getWorked_date());
        workedHours.setEmployee(employee);

        return workedHoursRepository.save(workedHours);
    }

    @Override
    public Integer getTotalWorkedHours(Long employeeId, LocalDate startDate, LocalDate endDate) {
        Iterable<WorkedHours> total = workedHoursRepository.findAllByEmployeeId(employeeId);

        int totalHours = 0;

        for (WorkedHours workedHours : total) {
            if (workedHours.getWorkedDate().compareTo(endDate)<0 && workedHours.getWorkedDate().compareTo(startDate)>0
                    || workedHours.getWorkedDate().equals(startDate) || workedHours.getWorkedDate().equals(endDate))
            totalHours = totalHours+workedHours.getWorkedHours();
        }
        return totalHours;
    }

    @Override
    public Optional<WorkedHours> getWorkedHoursByEmployeeIdAndWorkedDate(Long id, LocalDate date) {
        return workedHoursRepository.findByEmployeeIdAndWorkedDate(id, date);
    }

}
