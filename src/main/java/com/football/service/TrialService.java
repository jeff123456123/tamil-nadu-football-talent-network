package com.football.service;

import com.football.entity.Trial;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.entity.PlayerLevel;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TrialService {
    Trial createTrial(Trial trial);
    
    Optional<Trial> getTrialById(Long id);
    
    List<Trial> getAllTrials();
    
    List<Trial> getTrialsByClub(Club club);
    
    List<Trial> getTrialsByDistrict(District district);
    
    List<Trial> getTrialsByPlayerLevel(PlayerLevel playerLevel);
    
    List<Trial> getTrialsByDate(LocalDate trialDate);
    
    List<Trial> getActiveTrials();
    
    Trial updateTrial(Long id, Trial trialDetails);
    
    void deleteTrial(Long id);
}
