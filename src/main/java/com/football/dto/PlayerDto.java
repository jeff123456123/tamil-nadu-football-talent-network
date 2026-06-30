package com.football.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class PlayerDto {
    private Long id;
    
    @NotNull(message = "User ID is required")
    private Long userId;
    
    private String userEmail;
    
    private Long clubId;
    private String clubName;
    
    @NotNull(message = "District ID is required")
    private Long districtId;
    private String districtName;
    
    @NotNull(message = "Date of birth is required")
    @PastOrPresent(message = "Date of birth cannot be in future")
    private LocalDate dateOfBirth;
    
    @Positive(message = "Height must be positive")
    private Double height;
    
    @Positive(message = "Weight must be positive")
    private Double weight;
    
    @NotBlank(message = "Position is required")
    private String position;
    
    private String statistics;
    
    private Boolean active;
    
    private String createdAt;
    private String updatedAt;

    // Constructors
    public PlayerDto() {}
    
    public PlayerDto(Long id, Long userId, String userEmail, String position) {
        this.id = id;
        this.userId = userId;
        this.userEmail = userEmail;
        this.position = position;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    
    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
    
    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }
    
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    
    public Long getDistrictId() { return districtId; }
    public void setDistrictId(Long districtId) { this.districtId = districtId; }
    
    public String getDistrictName() { return districtName; }
    public void setDistrictName(String districtName) { this.districtName = districtName; }
    
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }
    
    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
    
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
    
    public String getStatistics() { return statistics; }
    public void setStatistics(String statistics) { this.statistics = statistics; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
