package com.example.JobModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JobController {

    @Autowired
    private JobService jobServ;

    @GetMapping("/searchPage")
    public String searchPage() {

        return "searchJobs";
    }

    @GetMapping("/searchJobs")
    public String searchJobs(
            @RequestParam String keyword,
            Model model) {

        List<Job> jobs =
                jobServ.searchJobs(keyword);

        model.addAttribute("jobs", jobs);

        return "jobResults";
    }
    
    @GetMapping("/addJobPage")
    public String addJobPage() {

        return "addJob";
    }
    
    @GetMapping("/viewJobs")
    public String viewJobs(Model model) {

        List<Job> jobs = jobServ.getAllJobs();

        model.addAttribute("jobs", jobs);

        return "viewJobs";
    }
    
    @PostMapping("/addJob")
    public String addJob(
            @ModelAttribute Job job) {

        jobServ.addJob(job);

        return "addJobSuccess";
    }
}
