package com.football.dto;

import jakarta.validation.constraints.*;

public class TrialApplicationDto {
    private Long id;
    
    @NotNull(message = "Player ID is required")
    private Long playerId;
    private String playerEmail;
    
    @NotNull(message = "Trial ID is required")
    private Long trialId;
    private String trialLocation;
    
    @NotBlank(message = "Status is required")
    private String status;
    
    private String appliedDate;
    private String updatedAt;

    // Constructors
    public TrialApplicationDto() {}
    
    public TrialApplicationDto(Long id, Long playerId, Long trialId, String status) {
        this.id = id;
        this.playerId = playerId;
        this.trialId = trialId;
        this.status = status;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    
    public String getPlayerEmail() { return playerEmail; }
    public void setPlayerEmail(String playerEmail) { this.playerEmail = playerEmail; }
    
    public Long getTrialId() { return trialId; }
    public void setTrialId(Long trialId) { this.trialId = trialId; }
    
    public String getTrialLocation() { return trialLocation; }
    public void setTrialLocation(String trialLocation) { this.trialLocation = trialLocation; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    public String getAppliedDate() { return appliedDate; }
    public void setAppliedDate(String appliedDate) { this.appliedDate = appliedDate; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
