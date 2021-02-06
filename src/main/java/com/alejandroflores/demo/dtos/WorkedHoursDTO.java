package com.alejandroflores.demo.dtos;

import java.time.LocalDate;

public class WorkedHoursDTO {

    private Long employee_id;
    private int worked_hours;
    private LocalDate worked_date;

    public WorkedHoursDTO(Long employee_id, int worked_hours, LocalDate worked_date) {
        this.employee_id = employee_id;
        this.worked_hours = worked_hours;
        this.worked_date = worked_date;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public int getWorked_hours() {
        return worked_hours;
    }

    public void setWorked_hours(int worked_hours) {
        this.worked_hours = worked_hours;
    }

    public LocalDate getWorked_date() {
        return worked_date;
    }

    public void setWorked_date(LocalDate worked_date) {
        this.worked_date = worked_date;
    }
}
