package com.football.controller;

import com.football.entity.Trial;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.entity.PlayerLevel;
import com.football.service.TrialService;
import com.football.service.ClubService;
import com.football.service.DistrictService;
import com.football.service.PlayerLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trials")
@CrossOrigin(origins = "*")
public class TrialController {
    
    @Autowired
    private TrialService trialService;
    
    @Autowired
    private ClubService clubService;
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private PlayerLevelService playerLevelService;
    
    @PostMapping
    public ResponseEntity<Trial> createTrial(@RequestBody Trial trial) {
        Trial savedTrial = trialService.createTrial(trial);
        return new ResponseEntity<>(savedTrial, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Trial> getTrialById(@PathVariable Long id) {
        Optional<Trial> trial = trialService.getTrialById(id);
        return trial.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Trial>> getAllTrials() {
        List<Trial> trials = trialService.getAllTrials();
        return ResponseEntity.ok(trials);
    }
    
    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<Trial>> getTrialsByClub(@PathVariable Long clubId) {
        Optional<Club> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            List<Trial> trials = trialService.getTrialsByClub(club.get());
            return ResponseEntity.ok(trials);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/district/{districtId}")
    public ResponseEntity<List<Trial>> getTrialsByDistrict(@PathVariable Long districtId) {
        Optional<District> district = districtService.getDistrictById(districtId);
        if (district.isPresent()) {
            List<Trial> trials = trialService.getTrialsByDistrict(district.get());
            return ResponseEntity.ok(trials);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/level/{levelId}")
    public ResponseEntity<List<Trial>> getTrialsByPlayerLevel(@PathVariable Long levelId) {
        Optional<PlayerLevel> playerLevel = playerLevelService.getPlayerLevelById(levelId);
        if (playerLevel.isPresent()) {
            List<Trial> trials = trialService.getTrialsByPlayerLevel(playerLevel.get());
            return ResponseEntity.ok(trials);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/date/{trialDate}")
    public ResponseEntity<List<Trial>> getTrialsByDate(@PathVariable LocalDate trialDate) {
        List<Trial> trials = trialService.getTrialsByDate(trialDate);
        return ResponseEntity.ok(trials);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Trial>> getActiveTrials() {
        List<Trial> trials = trialService.getActiveTrials();
        return ResponseEntity.ok(trials);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Trial> updateTrial(@PathVariable Long id, @RequestBody Trial trialDetails) {
        Trial updatedTrial = trialService.updateTrial(id, trialDetails);
        return updatedTrial != null ? ResponseEntity.ok(updatedTrial) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrial(@PathVariable Long id) {
        if (trialService.getTrialById(id).isPresent()) {
            trialService.deleteTrial(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
