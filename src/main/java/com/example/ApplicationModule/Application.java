package com.example.ApplicationModule;

import com.example.JobModule.Job;
import com.example.UserModule.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Application {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int appId;

    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Job job;

	public Application() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Application(String status, User user, Job job) {
		super();
	
		this.status = status;
		this.user = user;
		this.job = job;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
    

}
