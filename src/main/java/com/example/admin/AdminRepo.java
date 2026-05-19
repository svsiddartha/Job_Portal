package com.example.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	
	Admin findByEmail(String email);

}
