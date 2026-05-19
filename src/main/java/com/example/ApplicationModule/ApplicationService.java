package com.example.ApplicationModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JobModule.Job;
import com.example.JobModule.JobRepo;
import com.example.UserModule.User;
import com.example.UserModule.UserRepository;

@Service
public class ApplicationService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private ApplicationRepo appRepo;

    public String applyJob(int userId, int jobId) {

        User user = userRepo.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User Not Found"));

        Job job = jobRepo.findById(jobId)
                .orElseThrow(() ->
                        new RuntimeException("Job Not Found"));

        Application app = new Application();

        app.setUser(user);
        app.setJob(job);
        app.setStatus("Applied");

        appRepo.save(app);

        return "Applied Successfully";
    }

    public List<Application> getApplications(int uid) {

        return appRepo.findByUserUid(uid);
    }
    
    
    public List<Application> getAllApplications() {

        return appRepo.findAll();
    }
}
