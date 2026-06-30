package com.football.controller;

import com.football.entity.Coach;
import com.football.entity.Club;
import com.football.service.CoachService;
import com.football.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coaches")
@CrossOrigin(origins = "*")
public class CoachController {
    
    @Autowired
    private CoachService coachService;
    
    @Autowired
    private ClubService clubService;
    
    @PostMapping
    public ResponseEntity<Coach> createCoach(@RequestBody Coach coach) {
        Coach savedCoach = coachService.createCoach(coach);
        return new ResponseEntity<>(savedCoach, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        Optional<Coach> coach = coachService.getCoachById(id);
        return coach.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Coach>> getAllCoaches() {
        List<Coach> coaches = coachService.getAllCoaches();
        return ResponseEntity.ok(coaches);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<Coach> getCoachByUserId(@PathVariable Long userId) {
        Optional<Coach> coach = coachService.getCoachByUserId(userId);
        return coach.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<Coach>> getCoachesByClub(@PathVariable Long clubId) {
        Optional<Club> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            List<Coach> coaches = coachService.getCoachesByClub(club.get());
            return ResponseEntity.ok(coaches);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Coach>> getCoachesBySpecialization(@PathVariable String specialization) {
        List<Coach> coaches = coachService.getCoachesBySpecialization(specialization);
        return ResponseEntity.ok(coaches);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Coach>> getActiveCoaches() {
        List<Coach> coaches = coachService.getActiveCoaches();
        return ResponseEntity.ok(coaches);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coachDetails) {
        Coach updatedCoach = coachService.updateCoach(id, coachDetails);
        return updatedCoach != null ? ResponseEntity.ok(updatedCoach) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        if (coachService.getCoachById(id).isPresent()) {
            coachService.deleteCoach(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
