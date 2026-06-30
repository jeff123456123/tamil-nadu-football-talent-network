package com.football.controller;

import com.football.entity.ShortlistedPlayer;
import com.football.entity.Scout;
import com.football.service.ShortlistedPlayerService;
import com.football.service.ScoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shortlists")
@CrossOrigin(origins = "*")
public class ShortlistedPlayerController {

    @Autowired
    private ShortlistedPlayerService service;

    @Autowired
    private ScoutService scoutService;

    @PostMapping
    public ResponseEntity<ShortlistedPlayer> save(
            @RequestBody ShortlistedPlayer shortlistedPlayer) {

        return ResponseEntity.ok(
                service.saveShortlist(shortlistedPlayer));
    }

    @GetMapping("/scout/{scoutId}")
    public ResponseEntity<List<ShortlistedPlayer>>
    getByScout(@PathVariable Long scoutId) {

        Scout scout =
                scoutService.getScoutById(scoutId).orElse(null);

        return ResponseEntity.ok(
                service.getShortlistedPlayersByScout(scout));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id) {

        service.deleteShortlistedPlayer(id);

        return ResponseEntity.noContent().build();
    }
}