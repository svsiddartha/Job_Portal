package com.example.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ApplicationModule.Application;
import com.example.ApplicationModule.ApplicationRepo;
import com.example.UserModule.User;
import com.example.UserModule.UserRepository;
import com.example.recruiter.Recruiter;
import com.example.recruiter.RecruiterRepo;

@Controller
public class AdminController {

    @Autowired
    private AdminService adminServ;
    
    
    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private ApplicationRepo appRepo;
    
    
    @Autowired
    private RecruiterRepo recruiterRepo;

    @GetMapping("/adminLoginPage")
    public String adminLoginPage() {

        return "adminLogin";
    }

    @PostMapping("/adminLogin")
    public String adminLogin(
            @RequestParam String email,
            @RequestParam String password) {

        boolean access =
                adminServ.login(email, password);

        if(access) {
            return "adminHome";
        }

        return "adminLogin";
    }
    
    @GetMapping("/viewUsers")
    public String viewUsers(Model model) {

        List<User> users =
                userRepo.findAll();

        model.addAttribute("users", users);

        return "viewUsers";
    }
    
    @GetMapping("/viewRecruiters")
    public String viewRecruiters(
            Model model) {

        List<Recruiter> recruiters =
                recruiterRepo.findAll();

        model.addAttribute(
                "recruiters",
                recruiters);

        return "viewRecruiters";
    }
    
    @GetMapping("/viewApplicationsAdmin")
    public String viewApplicationsAdmin(
            Model model) {

        List<Application> applications =
                appRepo.findAll();

        model.addAttribute(
                "applications",
                applications);

        return "viewApplicationsAdmin";
    }
    
    @GetMapping("/adminHome")
    public String adminHome() {

        return "adminHome";
    }
}
