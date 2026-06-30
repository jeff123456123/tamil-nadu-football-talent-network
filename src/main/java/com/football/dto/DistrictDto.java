package com.football.dto;

import jakarta.validation.constraints.*;

public class DistrictDto {
    private Long id;
    
    @NotBlank(message = "District name is required")
    private String name;
    
    private String createdAt;

    // Constructors
    public DistrictDto() {}
    
    public DistrictDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
