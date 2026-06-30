package com.football.controller;

import com.football.entity.Player;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.entity.PlayerLevel;
import com.football.service.PlayerService;
import com.football.service.ClubService;
import com.football.service.DistrictService;
import com.football.service.PlayerLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "*")
public class PlayerController {
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private ClubService clubService;
    
    @Autowired
    private DistrictService districtService;
    
    @Autowired
    private PlayerLevelService playerLevelService;
    
    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        Player savedPlayer = playerService.createPlayer(player);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Optional<Player> player = playerService.getPlayerById(id);
        return player.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<Player> getPlayerByUserId(@PathVariable Long userId) {
        Optional<Player> player = playerService.getPlayerByUserId(userId);
        return player.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping("/club/{clubId}")
    public ResponseEntity<List<Player>> getPlayersByClub(@PathVariable Long clubId) {
        Optional<Club> club = clubService.getClubById(clubId);
        if (club.isPresent()) {
            List<Player> players = playerService.getPlayersByClub(club.get());
            return ResponseEntity.ok(players);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/district/{districtId}")
    public ResponseEntity<List<Player>> getPlayersByDistrict(@PathVariable Long districtId) {
        Optional<District> district = districtService.getDistrictById(districtId);
        if (district.isPresent()) {
            List<Player> players = playerService.getPlayersByDistrict(district.get());
            return ResponseEntity.ok(players);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/active")
    public ResponseEntity<List<Player>> getActivePlayers() {
        List<Player> players = playerService.getActivePlayers();
        return ResponseEntity.ok(players);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
        Player updatedPlayer = playerService.updatePlayer(id, playerDetails);
        return updatedPlayer != null ? ResponseEntity.ok(updatedPlayer) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable Long id) {
        if (playerService.getPlayerById(id).isPresent()) {
            playerService.deletePlayer(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
