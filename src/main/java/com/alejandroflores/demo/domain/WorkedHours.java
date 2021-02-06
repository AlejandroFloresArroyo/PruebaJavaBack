package com.alejandroflores.demo.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class WorkedHours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "WORKED_HOURS")
    private Integer workedHours;
    @Column(name = "WORKED_DATE")
    private LocalDate workedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public LocalDate getWorkedDate() {
        return workedDate;
    }

    public void setWorkedDate(LocalDate workedDate) {
        this.workedDate = workedDate;
    }

    @Override
    public String toString() {
        return "WorkedHours{" +
                "id=" + id +
                ", employee=" + employee +
                ", workedHours=" + workedHours +
                ", workedDate=" + workedDate +
                '}';
    }
}
