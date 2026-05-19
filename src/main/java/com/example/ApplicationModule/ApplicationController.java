package com.example.ApplicationModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.UserModule.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class ApplicationController {

    @Autowired
    private ApplicationService appServ;

    @PostMapping("/applyJob")
    public String applyJob(
            @RequestParam int jobId,
            HttpSession session) {

        User user =
                (User) session.getAttribute("user");

        if(user == null) {

            return "login";
        }

        appServ.applyJob(
                user.getUid(),
                jobId);

        return "applySuccess";
    }

    @GetMapping("/viewApplications")
    public String viewApplications(
            HttpSession session,
            Model model) {

        User user =
                (User) session.getAttribute("user");

        if(user == null) {

            return "login";
        }

        List<Application> apps =
                appServ.getApplications(
                        user.getUid());

        model.addAttribute(
                "apps",
                apps);

        return "applications";
    }
    
   
    
    @GetMapping("/viewApplicants")
    public String viewApplicants(Model model) {

        List<Application> applications =
                appServ.getAllApplications();

        model.addAttribute(
                "applications",
                applications);

        return "viewApplicants";
    }
}
