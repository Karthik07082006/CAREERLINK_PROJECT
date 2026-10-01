package com.careerlink.jobservice.repository;

import com.careerlink.jobservice.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByStatus(String status);
    List<Job> findByCompany(String company);
}
