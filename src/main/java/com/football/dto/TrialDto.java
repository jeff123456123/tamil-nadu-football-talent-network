package com.football.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class TrialDto {
    private Long id;
    
    @NotNull(message = "Club ID is required")
    private Long clubId;
    private String clubName;
    
    @NotNull(message = "District ID is required")
    private Long districtId;
    private String districtName;
    
    @NotNull(message = "Player level ID is required")
    private Long playerLevelId;
    private String playerLevelName;
    
    @NotNull(message = "Trial date is required")
    @FutureOrPresent(message = "Trial date must be in present or future")
    private LocalDate trialDate;
    
    @NotBlank(message = "Location is required")
    private String location;
    
    private String description;
    
    @NotNull(message = "Capacity is required")
    @Min(value = 1, message = "Capacity must be at least 1")
    private Integer capacity;
    
    private Boolean active;
    
    private String createdAt;
    private String updatedAt;

    // Constructors
    public TrialDto() {}
    
    public TrialDto(Long id, Long clubId, LocalDate trialDate, String location) {
        this.id = id;
        this.clubId = clubId;
        this.trialDate = trialDate;
        this.location = location;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getClubId() { return clubId; }
    public void setClubId(Long clubId) { this.clubId = clubId; }
    
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    
    public Long getDistrictId() { return districtId; }
    public void setDistrictId(Long districtId) { this.districtId = districtId; }
    
    public String getDistrictName() { return districtName; }
    public void setDistrictName(String districtName) { this.districtName = districtName; }
    
    public Long getPlayerLevelId() { return playerLevelId; }
    public void setPlayerLevelId(Long playerLevelId) { this.playerLevelId = playerLevelId; }
    
    public String getPlayerLevelName() { return playerLevelName; }
    public void setPlayerLevelName(String playerLevelName) { this.playerLevelName = playerLevelName; }
    
    public LocalDate getTrialDate() { return trialDate; }
    public void setTrialDate(LocalDate trialDate) { this.trialDate = trialDate; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Integer getCapacity() { return capacity; }
    public void setCapacity(Integer capacity) { this.capacity = capacity; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
