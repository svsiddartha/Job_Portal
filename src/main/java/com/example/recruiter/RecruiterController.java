package com.example.recruiter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterServ;

    @GetMapping("/recruiterRegisterPage")
    public String recruiterRegisterPage() {

        return "recruiterRegister";
    }

    @PostMapping("/recruiterRegister")
    public String recruiterRegister(
            @Valid @ModelAttribute Recruiter recruiter,
            BindingResult result) {

        if(result.hasErrors()) {

            return "recruiterRegister";
        }

        recruiterServ.registerRecruiter(recruiter);

        return "recruiterLogin";
    }

    @GetMapping("/recruiterLoginPage")
    public String recruiterLoginPage() {

        return "recruiterLogin";
    }

    @PostMapping("/recruiterLogin")
    public String recruiterLogin(
            @RequestParam String email,
            @RequestParam String password) {

        boolean access =
                recruiterServ.login(email, password);

        if(access) {
            return "recruiterHome";
        }

        return "recruiterLogin";
    }
    
    
    @GetMapping("/recruiterHome")
    public String recruiterHome() {

        return "recruiterHome";
    }
    
  
}
