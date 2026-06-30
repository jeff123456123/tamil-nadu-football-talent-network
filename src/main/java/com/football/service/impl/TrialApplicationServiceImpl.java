package com.football.service.impl;

import com.football.entity.TrialApplication;
import com.football.entity.Player;
import com.football.entity.Trial;
import com.football.repository.TrialApplicationRepository;
import com.football.service.TrialApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrialApplicationServiceImpl implements TrialApplicationService {
    
    @Autowired
    private TrialApplicationRepository trialApplicationRepository;
    
    @Override
    public TrialApplication applyForTrial(TrialApplication trialApplication) {
        return trialApplicationRepository.save(trialApplication);
    }
    
    @Override
    public Optional<TrialApplication> getTrialApplicationById(Long id) {
        return trialApplicationRepository.findById(id);
    }
    
    @Override
    public List<TrialApplication> getAllTrialApplications() {
        return trialApplicationRepository.findAll();
    }
    
    @Override
    public List<TrialApplication> getApplicationsByPlayer(Player player) {
        return trialApplicationRepository.findByPlayer(player);
    }
    
    @Override
    public List<TrialApplication> getApplicationsByTrial(Trial trial) {
        return trialApplicationRepository.findByTrial(trial);
    }
    
    @Override
    public List<TrialApplication> getApplicationsByStatus(TrialApplication.ApplicationStatus status) {
        return trialApplicationRepository.findByStatus(status);
    }
    
    @Override
    public TrialApplication updateApplicationStatus(Long id, TrialApplication.ApplicationStatus status) {
        Optional<TrialApplication> application = trialApplicationRepository.findById(id);
        if (application.isPresent()) {
            TrialApplication existingApplication = application.get();
            existingApplication.setStatus(status);
            return trialApplicationRepository.save(existingApplication);
        }
        return null;
    }
    
    @Override
    public void deleteTrialApplication(Long id) {
        trialApplicationRepository.deleteById(id);
    }
}
