package com.alejandroflores.demo.services;

import com.alejandroflores.demo.domain.Gender;
import com.alejandroflores.demo.domain.Job;
import com.alejandroflores.demo.repositories.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public Job getJobByID(Long id) {
        return jobRepository.findJobById(id);
    }

    @Override
    public Boolean isJob(Long id) {
        Optional<Job> isJob = jobRepository.findById(id);
        if (isJob.isPresent()) return true;
        return false;
    }
}
