package com.alejandroflores.demo.repositories;

import com.alejandroflores.demo.domain.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {
    Job findJobById(Long aLong);
}
