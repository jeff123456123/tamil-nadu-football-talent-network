package com.football.dto;

import jakarta.validation.constraints.*;

public class CoachDto {
    private Long id;
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    private String userEmail;
    private String userName;
    
    private Long clubId;
    private String clubName;
    
    @NotBlank(message = "Specialization is required")
    private String specialization;
    
    @NotNull(message = "Years of experience is required")
    @Min(value = 0, message = "Years of experience cannot be negative")
    private Integer yearsExperience;
    
    private Boolean active;
    
    private String createdAt;
    private String updatedAt;

    // Constructors
    public CoachDto() {}
    
    public CoachDto(Long id, Long userId, String specialization, Integer yearsExperience) {
        this.id = id;
        this.userId = userId;
        this.specialization = specialization;
        this.yearsExperience = yearsExperience;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
    
    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }
    
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public Integer getYearsExperience() { return yearsExperience; }
    public void setYearsExperience(Integer yearsExperience) { this.yearsExperience = yearsExperience; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
