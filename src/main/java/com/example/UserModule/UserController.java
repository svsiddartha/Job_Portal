package com.example.UserModule;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

import jakarta.validation.Valid;

@Controller
public class UserController {
	
	
	@Autowired
	private UserService userServ;
	
	
	
	@GetMapping("/index")
	public String ind() {
		return "register";
	}
	
	@PostMapping("/register")
	public String userRegister(
	        @Valid @ModelAttribute User u,
	        BindingResult result) {

	    if(result.hasErrors()) {

	        return "register";
	    }

	    userServ.register(u);

	    return "login";
	}


	@PostMapping("/login")
	public String userLogin(
	        @RequestParam String uemail,
	        @RequestParam String upassword,
	        HttpSession session) {

	    User user =
	            userServ.login(uemail, upassword);

	    if(user != null) {

	        session.setAttribute("user", user);

	        return "userHome";
	    }

	    return "login";
	}
	

	
	@PostMapping("/userUpdate")
	public String userUpdate(
	        @ModelAttribute User u,
	        HttpSession session) {

	    User currentUser =
	            (User) session.getAttribute("user");

	    if(currentUser == null) {

	        return "login";
	    }

	    userServ.updateUser(
	            currentUser.getUemail(),
	            u);

	    return "updateSuccess";
	}
	
	
	@GetMapping("/registerPage")
	public String registerPage() {
		
		return "register";
		
		
	}
	@GetMapping("/loginPage")
	public String loginPage() {
		
		return "login";
		
		
	}
	@GetMapping("/UpdateUser")
	public String updateUser() {
		
		return "updateUser";
		
		
	}
	
	@PostMapping("/uploadResume")
	public String uploadResume(
	        @RequestParam("file") MultipartFile file,
	        HttpSession session)
	        throws IOException {

	    User user =
	            (User) session.getAttribute("user");

	    if(user == null) {

	        return "login";
	    }

	    userServ.uploadResume(
	            user.getUemail(),
	            file);

	    return "resumeSuccess";
	}
	
	@GetMapping("/resumeUpload")
	public String resumeUpload() {
		
		return "resumeUpload";
		
		
	}
	
	@GetMapping("/userHome")
	public String userHome() {

	    return "userHome";
	}
	

}
