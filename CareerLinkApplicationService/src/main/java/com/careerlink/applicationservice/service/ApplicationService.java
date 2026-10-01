package com.careerlink.applicationservice.service;

import com.careerlink.applicationservice.dto.ApplicationRequest;
import com.careerlink.applicationservice.model.JobApplication;
import com.careerlink.applicationservice.repository.JobApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    private final JobApplicationRepository applicationRepository;

    public ApplicationService(JobApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public JobApplication apply(ApplicationRequest request) {
        JobApplication application = new JobApplication();
        application.setJobId(request.getJobId());
        application.setApplicantEmail(request.getApplicantEmail());
        return applicationRepository.save(application);
    }

    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    public JobApplication getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Application not found with id: " + id));
    }

    public List<JobApplication> getApplicationsByEmail(String email) {
        return applicationRepository.findByApplicantEmail(email);
    }

    public List<JobApplication> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findByJobId(jobId);
    }

    public JobApplication updateStatus(Long id, String status) {
        JobApplication application = getApplicationById(id);
        application.setStatus(status);
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
}
