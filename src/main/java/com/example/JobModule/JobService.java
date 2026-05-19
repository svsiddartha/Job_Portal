package com.example.JobModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public List<Job> searchJobs(String keyword) {

        return jobRepo.findByTitleContaining(keyword);
    }

    public Job addJob(Job job) {

        return jobRepo.save(job);
    }
    
    public List<Job> getAllJobs() {

        return jobRepo.findAll();
    }
    
}
