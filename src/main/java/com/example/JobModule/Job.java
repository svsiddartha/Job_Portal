package com.example.JobModule;

import com.example.recruiter.Recruiter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Job {
	


		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private int jobId;
	
		    private String title;
		    private String company;
		    private String location;
		    private double salary;
		    
		    
		    @ManyToOne
		    @JoinColumn(name = "recruiter_id")
		    private Recruiter recruiter;
		    
			public Recruiter getRecruiter() {
				return recruiter;
			}
			public void setRecruiter(Recruiter recruiter) {
				this.recruiter = recruiter;
			}
			public Job(String title, String company, String location, double salary) {
				super();
				this.title = title;
				this.company = company;
				this.location = location;
				this.salary = salary;
			}
			public Job() {
				super();
				// TODO Auto-generated constructor stub
			}
			public int getJobId() {
				return jobId;
			}
			public void setJobId(int jobId) {
				this.jobId = jobId;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getCompany() {
				return company;
			}
			public void setCompany(String company) {
				this.company = company;
			}
			public String getLocation() {
				return location;
			}
			public void setLocation(String location) {
				this.location = location;
			}
			public double getSalary() {
				return salary;
			}
			public void setSalary(double salary) {
				this.salary = salary;
			}
			
		    

}
