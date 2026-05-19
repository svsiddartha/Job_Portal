package com.example.recruiter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;

    private String companyName;

    @Column(unique = true)
    private String email;

    private String password;
    
    
    @Pattern(regexp = "[0-9]{10}",
		    message = "Phone number must contain 10 digits")

    private String phone;

	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Recruiter(String companyName, String email, String password, String phone) {
		super();
		this.companyName = companyName;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

    
}
