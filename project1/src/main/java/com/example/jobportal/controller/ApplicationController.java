package com.example.jobportal.controller;

import com.example.jobportal.entity.JobApplication;
import com.example.jobportal.repository.JobApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

    private final JobApplicationRepository applicationRepository;

    private final String uploadDir = "uploads/";

    @GetMapping("/job/{id}/apply")
    public String showApplyForm(@PathVariable int id, Model model) {
        model.addAttribute("jobId", id);
        return "apply-form";
    }

    @PostMapping("/job/{id}/apply")
    public String applyJob(@PathVariable int id,
                           @RequestParam String applicantName,
                           @RequestParam String email,
                           @RequestParam MultipartFile cvFile) throws IOException {

        String fileName = cvFile.getOriginalFilename();
        File uploadPath = Paths.get(uploadDir).toFile();
        if (!uploadPath.exists()) uploadPath.mkdirs();

        File dest = new File(uploadPath, fileName);
        cvFile.transferTo(dest);

        JobApplication application = new JobApplication();
        application.setApplicantName(applicantName);
        application.setEmail(email);
        application.setJobId(id);
        application.setCvFileName(fileName);

        applicationRepository.save(application);
        return "redirect:/";
    }

    @GetMapping("/job/{id}/applications")
    public String viewApplications(@PathVariable int id, Model model) {
        List<JobApplication> applications = applicationRepository.findByJobId(id);
        model.addAttribute("applications", applications);
        return "job-applications"; // template hiển thị danh sách CV
    }
}
