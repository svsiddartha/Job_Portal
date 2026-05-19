package com.example.UserModule;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	public String register(User u) {
		userRepo.save(u);
		return u.getUname()+" Registration Sucessfull.";
	}
	
	
	public User login(
	        String uemail,
	        String upassword) {

	    User user =
	            userRepo.findByuemail(uemail);

	    if(user == null) {

	        return null;
	    }

	    if(user.getUpassword()
	            .equals(upassword)) {

	        return user;
	    }

	    return null;
	}
	
	public String updateUser(String uemail, User user) {

	    User u = userRepo.findByuemail(uemail);

	    if (u == null) {
	        throw new RuntimeException("User does not exist");
	    }

	    u.setUname(user.getUname());
	    u.setUphno(user.getUphno());
	    u.setUpassword(user.getUpassword());
	    u.setUemail(user.getUemail());

	    userRepo.save(u);

	    return "Dear " + u.getUname() + ", Your profile updated";
	}
	
	public String uploadResume(
	        String uemail,
	        MultipartFile file)
	        throws IllegalStateException, IOException {

	    User u = userRepo.findByuemail(uemail);

	    if (u == null) {
	        return "User Not Found";
	    }

	    if (file.isEmpty()) {
	        return "Please Select a File";
	    }

	    String uploadDir =
	            "C:\\Users\\Dell\\Desktop\\resumes\\";

	    File directory = new File(uploadDir);

	    if (!directory.exists()) {
	        directory.mkdirs();
	    }

	    String fileName = file.getOriginalFilename();

	    File saveFile = new File(uploadDir + fileName);

	    file.transferTo(saveFile);

	    u.setResume(saveFile.getAbsolutePath());

	    userRepo.save(u);

	    return "Resume Uploaded Successfully";
	}
	
	

}
