package com.example.job_tracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.job_tracker.Model.Application;
import com.example.job_tracker.Model.ApplicationStatus;
import com.example.job_tracker.exception.ResourceNotFoundException;
import com.example.job_tracker.repository.ApplicationRepository;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(Application application) {
        // Add any business validations, set defaults, etc.
        if (application.getDateApplied() == null) {
            application.setDateApplied(LocalDate.now());
        }
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public List<Application> searchByCompany(String companyName) {
        return applicationRepository.findByCompanyNameContaining(companyName);
    }

    public List<Application> getByStatus(ApplicationStatus status) {
        return applicationRepository.findByStatus(status);
    }

    public Application updateApplication(Long id, Application updated) {
        return applicationRepository.findById(id)
                .map(existing -> {
                    existing.setCompanyName(updated.getCompanyName());
                    existing.setPositionTitle(updated.getPositionTitle());
                    existing.setDateApplied(updated.getDateApplied());
                    existing.setStatus(updated.getStatus());
                    existing.setNotes(updated.getNotes());
                    return applicationRepository.save(existing);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Application not found"));
    }

    public void deleteApplicati