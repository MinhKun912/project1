package com.example.jobportal.service;

import com.example.jobportal.entity.Job;

import java.util.List;

public interface JobService {
    List<Job> getAllJobs();
    Job getJobById(int id);
    Job saveJob(Job job);
    List<Job> searchJobs(String keyword);
}
