package com.football.dto;

import jakarta.validation.constraints.*;

public class PlayerLevelDto {
    private Long id;
    
    @NotBlank(message = "Level is required")
    private String level;

    // Constructors
    public PlayerLevelDto() {}
    
    public PlayerLevelDto(Long id, String level) {
        this.id = id;
        this.level = level;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }
}
