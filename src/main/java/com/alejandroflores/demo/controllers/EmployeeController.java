package com.alejandroflores.demo.controllers;

import com.alejandroflores.demo.domain.Employee;
import com.alejandroflores.demo.domain.Job;
import com.alejandroflores.demo.domain.WorkedHours;
import com.alejandroflores.demo.dtos.EmployeeDTO;
import com.alejandroflores.demo.dtos.RequestByDateDTO;
import com.alejandroflores.demo.dtos.WorkedHoursDTO;
import com.alejandroflores.demo.services.EmployeeService;
import com.alejandroflores.demo.services.JobService;
import com.alejandroflores.demo.services.WorkedHoursService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;
    private final JobService jobService;
    private final WorkedHoursService workedHoursService;

    public EmployeeController(EmployeeService employeeService, JobService jobService, WorkedHoursService workedHoursService) {
        this.employeeService = employeeService;
        this.jobService = jobService;
        this.workedHoursService = workedHoursService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Map> getEmployeesByJob(@RequestBody com.fasterxml.jackson.databind.JsonNode payload) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

        if (jobService.isJob(payload.get("job_id").asLong())){
            map.put("employees", employeeService.getEmployeesByJobID(payload.get("job_id").asLong()));
            map.put("success", true);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
        map.put("employees", null);
        map.put("success", false);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Map> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();

        Period employeeAge = Period.between(employeeDTO.getBirthdate(), LocalDate.now());

        Employee employee = employeeService.insertEmployee(employeeDTO);

        if (employee == null || employeeAge.getYears()<18){
        map.put("id", null);
        map.put("success", false);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
        }
        else {
        map.put("id", employee.getId());
        map.put("success", true);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
        }
    }

    @PostMapping({"", "/hours"})
    public ResponseEntity<Map> createWorkedHours(@RequestBody WorkedHoursDTO workedHoursDTO){
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        Optional<Employee> employee = employeeService.getEmployeeById(workedHoursDTO.getEmployee_id());

        if (workedHoursDTO.getWorked_hours()>20 || workedHoursDTO.getWorked_date().compareTo(LocalDate.now()) > 0 || employee.isEmpty() || workedHoursService.getWorkedHoursByEmployeeIdAndWorkedDate(workedHoursDTO.getEmployee_id(), workedHoursDTO.getWorked_date()).isPresent() ) {
            map.put("id", null);
            map.put("success", false);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        }
        WorkedHours inserted = workedHoursService.insertWorkedHours(workedHoursDTO, employee.get());
        map.put("id", inserted.getId());
        map.put("success", true);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping({"", "/totalhours"})
    public ResponseEntity<Map> getTotalWorkedHours(@RequestBody RequestByDateDTO requestByDateDTO ) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        Optional<Employee> employee = employeeService.getEmployeeById(requestByDateDTO.getEmployee_id());

        if (requestByDateDTO.getStart_date().compareTo(requestByDateDTO.getEnd_date())>=0 || employee.isEmpty()){
            map.put("total_worked_hours", null);
            map.put("success", false);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        }

        int workedHours = workedHoursService.getTotalWorkedHours(requestByDateDTO.getEmployee_id(), requestByDateDTO.getStart_date(), requestByDateDTO.getEnd_date());

        map.put("total_worked_hours", workedHours);
        map.put("success", true);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

    @GetMapping({"", "/totalpay"})
    public ResponseEntity<Map> getTotalPay(@RequestBody RequestByDateDTO requestByDateDTO ) {
        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        Optional<Employee> employee = employeeService.getEmployeeById(requestByDateDTO.getEmployee_id());

        if (requestByDateDTO.getStart_date().compareTo(requestByDateDTO.getEnd_date())>=0 || employee.isEmpty()){
            map.put("payment", null);
            map.put("success", false);
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        }

        Job job = jobService.getJobByID(employee.get().getJob().getId());
        int workedHours = workedHoursService.getTotalWorkedHours(requestByDateDTO.getEmployee_id(), requestByDateDTO.getStart_date(), requestByDateDTO.getEnd_date());

        map.put("payment", workedHours * job.getSalary());
        map.put("success", true);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
