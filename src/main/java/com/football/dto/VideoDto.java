package com.football.dto;
import org.hibernate.validator.constraints.URL;
import jakarta.validation.constraints.*;

public class VideoDto {
    private Long id;
    
    private Long playerId;
    private String playerEmail;
    
    private Long scoutId;
    private String scoutEmail;
    
    @NotBlank(message = "File URL is required")
    @URL(message = "File URL should be valid")
    private String fileUrl;
    
    
    @NotBlank(message = "Title is required")
    private String title;
    
    private String description;
    
    @NotNull(message = "Uploaded by user ID is required")
    private Long uploadedById;
    private String uploadedByEmail;
    
    private String createdAt;

    // Constructors
    public VideoDto() {}
    
    public VideoDto(Long id, String title, String fileUrl) {
        this.id = id;
        this.title = title;
        this.fileUrl = fileUrl;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Long getPlayerId() { return playerId; }
    public void setPlayerId(Long playerId) { this.playerId = playerId; }
    
    public String getPlayerEmail() { return playerEmail; }
    public void setPlayerEmail(String playerEmail) { this.playerEmail = playerEmail; }
    
    public Long getScoutId() { return scoutId; }
    public void setScoutId(Long scoutId) { this.scoutId = scoutId; }
    
    public String getScoutEmail() { return scoutEmail; }
    public void setScoutEmail(String scoutEmail) { this.scoutEmail = scoutEmail; }
    
    public String getFileUrl() { return fileUrl; }
    public void setFileUrl(String fileUrl) { this.fileUrl = fileUrl; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Long getUploadedById() { return uploadedById; }
    public void setUploadedById(Long uploadedById) { this.uploadedById = uploadedById; }
    
    public String getUploadedByEmail() { return uploadedByEmail; }
    public void setUploadedByEmail(String uploadedByEmail) { this.uploadedByEmail = uploadedByEmail; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
