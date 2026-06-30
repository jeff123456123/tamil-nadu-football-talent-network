package com.football.controller;

import com.football.entity.PlayerLevel;
import com.football.service.PlayerLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/player-levels")
@CrossOrigin(origins = "*")
public class PlayerLevelController {
    
    @Autowired
    private PlayerLevelService playerLevelService;
    
    @PostMapping
    public ResponseEntity<PlayerLevel> createPlayerLevel(@RequestBody PlayerLevel playerLevel) {
        PlayerLevel savedPlayerLevel = playerLevelService.createPlayerLevel(playerLevel);
        return new ResponseEntity<>(savedPlayerLevel, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PlayerLevel> getPlayerLevelById(@PathVariable Long id) {
        Optional<PlayerLevel> playerLevel = playerLevelService.getPlayerLevelById(id);
        return playerLevel.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<PlayerLevel>> getAllPlayerLevels() {
        List<PlayerLevel> playerLevels = playerLevelService.getAllPlayerLevels();
        return ResponseEntity.ok(playerLevels);
    }
    
    @GetMapping("/level/{level}")
    public ResponseEntity<PlayerLevel> getPlayerLevelByLevel(@PathVariable PlayerLevel.Level level) {
        Optional<PlayerLevel> playerLevel = playerLevelService.getPlayerLevelByLevel(level);
        return playerLevel.map(ResponseEntity::ok)
                          .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerLevel(@PathVariable Long id) {
        if (playerLevelService.getPlayerLevelById(id).isPresent()) {
            playerLevelService.deletePlayerLevel(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
