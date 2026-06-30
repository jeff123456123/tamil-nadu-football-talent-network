package com.football.service.impl;

import com.football.entity.Coach;
import com.football.entity.Club;
import com.football.repository.CoachRepository;
import com.football.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CoachServiceImpl implements CoachService {
    
    @Autowired
    private CoachRepository coachRepository;
    
    @Override
    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    
    @Override
    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }
    
    @Override
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }
    
    @Override
    public Optional<Coach> getCoachByUserId(Long userId) {
        return coachRepository.findByUserId(userId);
    }
    
    @Override
    public List<Coach> getCoachesByClub(Club club) {
        return coachRepository.findByClub(club);
    }
    
    @Override
    public List<Coach> getCoachesBySpecialization(String specialization) {
        return coachRepository.findBySpecialization(specialization);
    }
    
    @Override
    public List<Coach> getActiveCoaches() {
        return coachRepository.findByActive(true);
    }
    
    @Override
    public Coach updateCoach(Long id, Coach coachDetails) {
        Optional<Coach> coach = coachRepository.findById(id);
        if (coach.isPresent()) {
            Coach existingCoach = coach.get();
            existingCoach.setClub(coachDetails.getClub());
            existingCoach.setSpecialization(coachDetails.getSpecialization());
            existingCoach.setYearsExperience(coachDetails.getYearsExperience());
            existingCoach.setActive(coachDetails.getActive());
            return coachRepository.save(existingCoach);
        }
        return null;
    }
    
    @Override
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}
