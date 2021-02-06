package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Job;

import java.util.Optional;

public interface JobService {
    Job getJobByID(Long id);

    Boolean isJob(Long id);
}
