package com.example.ApplicationModule;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepo extends JpaRepository<Application, Integer>{

	List<Application> findByUserUid(int uid);

}
