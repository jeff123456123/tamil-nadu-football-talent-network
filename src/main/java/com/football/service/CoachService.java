package com.football.service;

import com.football.entity.Coach;
import com.football.entity.Club;
import java.util.List;
import java.util.Optional;

public interface CoachService {
    Coach createCoach(Coach coach);
    
    Optional<Coach> getCoachById(Long id);
    
    List<Coach> getAllCoaches();
    
    Optional<Coach> getCoachByUserId(Long userId);
    
    List<Coach> getCoachesByClub(Club club);
    
    List<Coach> getCoachesBySpecialization(String specialization);
    
    List<Coach> getActiveCoaches();
    
    Coach updateCoach(Long id, Coach coachDetails);
    
    void deleteCoach(Long id);
}
