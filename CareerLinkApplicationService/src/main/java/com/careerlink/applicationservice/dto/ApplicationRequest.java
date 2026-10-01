package com.careerlink.applicationservice.dto;

public class ApplicationRequest {
    private Long jobId;
    private String applicantEmail;

    public ApplicationRequest() {}

    public Long getJobId() { return jobId; }
    public void setJobId(Long jobId) { this.jobId = jobId; }
    public String getApplicantEmail() { return applicantEmail; }
    public void setApplicantEmail(String applicantEmail) { this.applicantEmail = applicantEmail; }
}
