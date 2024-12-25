package com.example.job_tracker.repository;

import com.example.job_tracker.Model.Application;
import com.example.job_tracker.Model.ApplicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The @Repository annotation is optional here 
// because Spring Data automatically detects this interface as a repository
@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long> {

    // Optional: define custom query methods.
    // For example:
    List<Application> findByCompanyNameContaining(String companyName);

    List<Application> findByStatus(ApplicationStatus status);
}