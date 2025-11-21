package com.example.jobportal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String applicantName;   // Tên người nộp
    private String email;           // Email người nộp

    private String cvFileName;      // Tên file CV đã upload
    private int jobId;              // ID công việc ứng tuyển
}
