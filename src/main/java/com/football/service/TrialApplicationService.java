package com.football.service;

import com.football.entity.TrialApplication;
import com.football.entity.Player;
import com.football.entity.Trial;
import java.util.List;
import java.util.Optional;

public interface TrialApplicationService {
    TrialApplication applyForTrial(TrialApplication trialApplication);
    
    Optional<TrialApplication> getTrialApplicationById(Long id);
    
    List<TrialApplication> getAllTrialApplications();
    
    List<TrialApplication> getApplicationsByPlayer(Player player);
    
    List<TrialApplication> getApplicationsByTrial(Trial trial);
    
    List<TrialApplication> getApplicationsByStatus(TrialApplication.ApplicationStatus status);
    
    TrialApplication updateApplicationStatus(Long id, TrialApplication.ApplicationStatus status);
    
    void deleteTrialApplication(Long id);
}
