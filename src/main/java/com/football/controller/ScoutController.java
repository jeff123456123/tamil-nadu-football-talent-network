package com.football.controller;

import com.football.entity.Scout;
import com.football.service.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scouts")
@CrossOrigin(origins = "*")
public class ScoutController {
    
    @Autowired
    private ScoutService scoutService;
    
    @PostMapping
    public ResponseEntity<Scout> createScout(@RequestBody Scout scout) {
        Scout savedScout = scoutService.createScout(scout);
        return new ResponseEntity<>(savedScout, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Scout> getScoutById(@PathVariable Long id) {
        Optional<Scout> scout = scoutService.getScoutById(id);
        return scout.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Scout>> getAllScouts() {
        List<Scout> scouts = scoutService.getAllScouts();
        return ResponseEntity.ok(scouts);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<Scout> getScoutByUserId(@PathVariable Long userId) {
        Optional<Scout> scout = scoutService.getScoutByUserId(userId);
        return scout.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/specialization/{specialization}")
    public ResponseEntity<List<Scout>> getScoutsBySpecialization(@PathVariable String specialization) {
        List<Scout> scouts = scoutService.getScoutsBySpecialization(specialization);
        return ResponseEntity.ok(scouts);
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Scout>> getActiveScouts() {
        List<Scout> scouts = scoutService.getActiveScouts();
        return ResponseEntity.ok(scouts);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Scout> updateScout(@PathVariable Long id, @RequestBody Scout scoutDetails) {
        Scout updatedScout = scoutService.updateScout(id, scoutDetails);
        return updatedScout != null ? ResponseEntity.ok(updatedScout) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScout(@PathVariable Long id) {
        if (scoutService.getScoutById(id).isPresent()) {
            scoutService.deleteScout(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
