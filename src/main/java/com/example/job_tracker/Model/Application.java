package com.example.job_tracker.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String positionTitle;
    private LocalDate dateApplied;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    @Column(length = 2000)
    private String notes;

    // Constructors (no-args + all-args if desired), getters, and setters

    public Application() {
    }

    public Application(String companyName, String positionTitle, LocalDate dateApplied,
            ApplicationStatus status, String notes) {
        this.companyName = companyName;
        this.positionTitle = positionTitle;
        this.dateApplied = dateApplied;
        this.status = status;
        this.notes = notes;
    }

    // getters and setters for each field
    // --- Getters and Setters ---
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public ApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}