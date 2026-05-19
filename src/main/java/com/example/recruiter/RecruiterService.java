package com.example.recruiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepo recruiterRepo;

    public String registerRecruiter(
            Recruiter recruiter) {

        recruiterRepo.save(recruiter);

        return "Recruiter Registered Successfully";
    }

    public boolean login(
            String email,
            String password) {

        Recruiter r =
                recruiterRepo.findByEmail(email);

        if(r == null) {
            return false;
        }

        return r.getPassword().equals(password);
    }
}
