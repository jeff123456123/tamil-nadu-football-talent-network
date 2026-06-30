package com.football.dto;

import jakarta.validation.constraints.*;

public class ScoutDto {
    private Long id;
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    private String userEmail;
    private String userName;
    
    @NotBlank(message = "Specialization is required")
    private String specialization;
    
    @NotNull(message = "Experience is required")
    @Min(value = 0, message = "Experience cannot be negative")
    private Integer experience;
    
    private Boolean active;
    
    private String createdAt;
    private String updatedAt;

    // Constructors
    public ScoutDto() {}
    
    public ScoutDto(Long id, Long userId, String specialization, Integer experience) {
        this.id = id;
        this.userId = userId;
        this.specialization = specialization;
        this.experience = experience;
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
    
    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    
    public Integer getExperience() { return experience; }
    public void setExperience(Integer experience) { this.experience = experience; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
