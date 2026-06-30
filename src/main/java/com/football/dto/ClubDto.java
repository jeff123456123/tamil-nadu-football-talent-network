package com.football.dto;

import jakarta.validation.constraints.*;

public class ClubDto {
    private Long id;
    
    @NotBlank(message = "Club name is required")
    private String name;
    
    @NotBlank(message = "City is required")
    private String city;
    
    @NotNull(message = "Founded year is required")
    @Min(value = 1900, message = "Founded year must be after 1900")
    @Max(value = 2100, message = "Founded year must be valid")
    private Integer foundedYear;
    
    private Boolean active;
    
    private String createdAt;
    private String updatedAt;

    // Constructors
    public ClubDto() {}
    
    public ClubDto(Long id, String name, String city, Integer foundedYear) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.foundedYear = foundedYear;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    
    public Integer getFoundedYear() { return foundedYear; }
    public void setFoundedYear(Integer foundedYear) { this.foundedYear = foundedYear; }
    
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    
    public String getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(String updatedAt) { this.updatedAt = updatedAt; }
}
