package com.football.controller;

import com.football.entity.TrialApplication;
import com.football.entity.Player;
import com.football.entity.Trial;
import com.football.service.TrialApplicationService;
import com.football.service.PlayerService;
import com.football.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trial-applications")
@CrossOrigin(origins = "*")
public class TrialApplicationController {
    
    @Autowired
    private TrialApplicationService trialApplicationService;
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private TrialService trialService;
    
    @PostMapping
    public ResponseEntity<TrialApplication> applyForTrial(@RequestBody TrialApplication trialApplication) {
        TrialApplication savedApplication = trialApplicationService.applyForTrial(trialApplication);
        return new ResponseEntity<>(savedApplication, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TrialApplication> getTrialApplicationById(@PathVariable Long id) {
        Optional<TrialApplication> application = trialApplicationService.getTrialApplicationById(id);
        return application.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<TrialApplication>> getAllTrialApplications() {
        List<TrialApplication> applications = trialApplicationService.getAllTrialApplications();
        return ResponseEntity.ok(applications);
    }
    
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<TrialApplication>> getApplicationsByPlayer(@PathVariable Long playerId) {
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            List<TrialApplication> applications = trialApplicationService.getApplicationsByPlayer(player.get());
            return ResponseEntity.ok(applications);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/trial/{trialId}")
    public ResponseEntity<List<TrialApplication>> getApplicationsByTrial(@PathVariable Long trialId) {
        Optional<Trial> trial = trialService.getTrialById(trialId);
        if (trial.isPresent()) {
            List<TrialApplication> applications = trialApplicationService.getApplicationsByTrial(trial.get());
            return ResponseEntity.ok(applications);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/status/{status}")
    public ResponseEntity<List<TrialApplication>> getApplicationsByStatus(@PathVariable TrialApplication.ApplicationStatus status) {
        List<TrialApplication> applications = trialApplicationService.getApplicationsByStatus(status);
        return ResponseEntity.ok(applications);
    }
    
    @PutMapping("/{id}/status/{status}")
    public ResponseEntity<TrialApplication> updateApplicationStatus(@PathVariable Long id, @PathVariable TrialApplication.ApplicationStatus status) {
        TrialApplication updatedApplication = trialApplicationService.updateApplicationStatus(id, status);
        return updatedApplication != null ? ResponseEntity.ok(updatedApplication) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrialApplication(@PathVariable Long id) {
        if (trialApplicationService.getTrialApplicationById(id).isPresent()) {
            trialApplicationService.deleteTrialApplication(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
