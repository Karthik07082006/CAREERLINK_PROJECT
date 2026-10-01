package com.careerlink.jobservice.controller;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.careerlink.jobservice.model.Job;
import com.careerlink.jobservice.service.JobService;

@SpringBootTest
@AutoConfigureMockMvc
class JobControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @TestConfiguration
    static class TestJobServiceConfig {
        @Bean
        @Primary
        JobService jobService() {
            return new JobService(null) {
                @Override
                public List<Job> getAllJobs() {
                    Job job = new Job();
                    job.setTitle("Java Developer");
                    job.setCompany("CareerLink");
                    job.setLocation("Remote");
                    job.setDescription("Build APIs");
                    job.setStatus("OPEN");
                    return List.of(job);
                }
            };
        }
    }

    @Test
    void getAllJobs_shouldAcceptSingularApiAlias() throws Exception {
        mockMvc.perform(get("/api/job")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
