package com.football.service.impl;

import com.football.entity.Scout;
import com.football.repository.ScoutRepository;
import com.football.service.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ScoutServiceImpl implements ScoutService {
    
    @Autowired
    private ScoutRepository scoutRepository;
    
    @Override
    public Scout createScout(Scout scout) {
        return scoutRepository.save(scout);
    }
    
    @Override
    public Optional<Scout> getScoutById(Long id) {
        return scoutRepository.findById(id);
    }
    
    @Override
    public List<Scout> getAllScouts() {
        return scoutRepository.findAll();
    }
    
    @Override
    public Optional<Scout> getScoutByUserId(Long userId) {
        return scoutRepository.findByUserId(userId);
    }
    
    @Override
    public List<Scout> getScoutsBySpecialization(String specialization) {
        return scoutRepository.findBySpecialization(specialization);
    }
    
    @Override
    public List<Scout> getActiveScouts() {
        return scoutRepository.findByActive(true);
    }
    
    @Override
    public Scout updateScout(Long id, Scout scoutDetails) {
        Optional<Scout> scout = scoutRepository.findById(id);
        if (scout.isPresent()) {
            Scout existingScout = scout.get();
            existingScout.setSpecialization(scoutDetails.getSpecialization());
            existingScout.setExperience(scoutDetails.getExperience());
            existingScout.setActive(scoutDetails.getActive());
            return scoutRepository.save(existingScout);
        }
        return null;
    }
    
    @Override
    public void deleteScout(Long id) {
        scoutRepository.deleteById(id);
    }
}
