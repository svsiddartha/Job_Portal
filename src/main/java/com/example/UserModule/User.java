package com.example.UserModule;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String uname;
	@Pattern(
		    regexp = "[0-9]{10}",
		    message = "Phone number must contain 10 digits"
		)
	private String uphno;
	@Column(unique = true)
	private String uemail;
	private String upassword;
	private String skills;
	private String qualification;
	private String experience;
	private String resume;
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	/*public User(String uname, long uphno, String uemail, String upassword) {
		super();
		this.uname = uname;
		this.uphno = uphno;
		this.uemail = uemail;
		this.upassword = upassword;
	}*/
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUphno() {
		return uphno;
	}
	public void setUphno(String uphno) {
		this.uphno = uphno;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	
	
}
