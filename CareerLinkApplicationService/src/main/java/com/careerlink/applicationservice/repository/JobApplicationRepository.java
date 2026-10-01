package com.careerlink.applicationservice.repository;

import com.careerlink.applicationservice.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByApplicantEmail(String applicantEmail);
    List<JobApplication> findByJobId(Long jobId);
    List<JobApplication> findByStatus(String status);
}
