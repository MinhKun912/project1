package com.example.jobportal.controller;

import com.example.jobportal.entity.Job;
import com.example.jobportal.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping("/")
    public String home(Model model, @RequestParam(required = false) String keyword) {
        if (keyword != null) {
            model.addAttribute("jobs", jobService.searchJobs(keyword));
        } else {
            model.addAttribute("jobs", jobService.getAllJobs());
        }
        return "index";
    }

    @GetMapping("/post")
    public String postJobForm() {
        return "post-job";
    }

    @PostMapping("/post")
    public String saveJob(@ModelAttribute Job job) {
        jobService.saveJob(job);
        return "redirect:/";
    }

    @GetMapping("/job/{id}")
    public String jobDetail(@PathVariable int id, Model model) {
        model.addAttribute("job", jobService.getJobById(id));
        return "job-detail";
    }
}
