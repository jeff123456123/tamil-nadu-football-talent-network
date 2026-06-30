package com.football.service;

import com.football.entity.Scout;
import java.util.List;
import java.util.Optional;

public interface ScoutService {
    Scout createScout(Scout scout);
    
    Optional<Scout> getScoutById(Long id);
    
    List<Scout> getAllScouts();
    
    Optional<Scout> getScoutByUserId(Long userId);
    
    List<Scout> getScoutsBySpecialization(String specialization);
    
    List<Scout> getActiveScouts();
    
    Scout updateScout(Long id, Scout scoutDetails);
    
    void deleteScout(Long id);
}
