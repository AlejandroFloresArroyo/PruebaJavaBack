package com.alejandroflores.demo.dtos;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long gender_id;
    private Long job_id;
    private String name;
    private String last_name;
    private LocalDate birthdate;

    public EmployeeDTO(Long gender_id, Long job_id, String name, String last_name, LocalDate birthdate) {
        this.gender_id = gender_id;
        this.job_id = job_id;
        this.name = name;
        this.last_name = last_name;
        this.birthdate = birthdate;
    }

    public Long getGender_id() {
        return gender_id;
    }

    public void setGender_id(Long gender_id) {
        this.gender_id = gender_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "gender_id=" + gender_id +
                ", job_id=" + job_id +
                ", name='" + name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", birthdate='" + birthdate + '\'' +
                '}';
    }
}
