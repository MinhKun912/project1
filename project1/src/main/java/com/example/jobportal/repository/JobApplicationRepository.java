package com.example.jobportal.repository;

import com.example.jobportal.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    // Lấy tất cả ứng viên ứng tuyển cho một công việc cụ thể
    List<JobApplication> findByJobId(int jobId);
}
