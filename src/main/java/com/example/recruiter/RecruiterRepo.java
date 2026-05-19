package com.example.recruiter;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecruiterRepo extends JpaRepository<Recruiter, Integer> {

		Recruiter findByEmail(String email);
}
