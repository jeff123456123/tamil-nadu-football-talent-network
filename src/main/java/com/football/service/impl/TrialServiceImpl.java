package com.football.service.impl;

import com.football.entity.Trial;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.entity.PlayerLevel;
import com.football.repository.TrialRepository;
import com.football.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrialServiceImpl implements TrialService {
    
    @Autowired
    private TrialRepository trialRepository;
    
    @Override
    public Trial createTrial(Trial trial) {
        return trialRepository.save(trial);
    }
    
    @Override
    public Optional<Trial> getTrialById(Long id) {
        return trialRepository.findById(id);
    }
    
    @Override
    public List<Trial> getAllTrials() {
        return trialRepository.findAll();
    }
    
    @Override
    public List<Trial> getTrialsByClub(Club club) {
        return trialRepository.findByClub(club);
    }
    
    @Override
    public List<Trial> getTrialsByDistrict(District district) {
        return trialRepository.findByDistrict(district);
    }
    
    @Override
    public List<Trial> getTrialsByPlayerLevel(PlayerLevel playerLevel) {
        return trialRepository.findByPlayerLevel(playerLevel);
    }
    
    @Override
    public List<Trial> getTrialsByDate(LocalDate trialDate) {
        return trialRepository.findByTrialDate(trialDate);
    }
    
    @Override
    public List<Trial> getActiveTrials() {
        return trialRepository.findByActive(true);
    }
    
    @Override
    public Trial updateTrial(Long id, Trial trialDetails) {
        Optional<Trial> trial = trialRepository.findById(id);
        if (trial.isPresent()) {
            Trial existingTrial = trial.get();
            existingTrial.setClub(trialDetails.getClub());
            existingTrial.setDistrict(trialDetails.getDistrict());
            existingTrial.setPlayerLevel(trialDetails.getPlayerLevel());
            existingTrial.setTrialDate(trialDetails.getTrialDate());
            existingTrial.setLocation(trialDetails.getLocation());
            existingTrial.setDescription(trialDetails.getDescription());
            existingTrial.setCapacity(trialDetails.getCapacity());
            existingTrial.setActive(trialDetails.getActive());
            return trialRepository.save(existingTrial);
        }
        return null;
    }
    
    @Override
    public void deleteTrial(Long id) {
        trialRepository.deleteById(id);
    }
}
