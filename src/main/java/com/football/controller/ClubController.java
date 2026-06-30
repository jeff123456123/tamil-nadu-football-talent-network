package com.football.controller;

import com.football.entity.Club;
import com.football.service.ClubService;
import com.football.service.DistrictService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clubs")
@CrossOrigin(origins="*")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @Autowired
    private DistrictService districtService;

    @PostMapping
    public ResponseEntity<Club> createClub(
            @RequestBody Club club){

        return new ResponseEntity<>(
                clubService.createClub(club),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Club> getClubById(
            @PathVariable Long id){

        return clubService.getClubById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping
    public ResponseEntity<List<Club>> getAllClubs(){

        return ResponseEntity.ok(
                clubService.getAllClubs());

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Club> getClubByName(
            @PathVariable String name){

        return clubService.getClubByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/active")
    public ResponseEntity<List<Club>> getActiveClubs(){

        return ResponseEntity.ok(
                clubService.getActiveClubs());

    }

    

    @PutMapping("/{id}")
    public ResponseEntity<Club> updateClub(
            @PathVariable Long id,
            @RequestBody Club club){

        Club updated =
                clubService.updateClub(id,club);

        if(updated==null){

            return ResponseEntity.notFound().build();

        }

        return ResponseEntity.ok(updated);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClub(
            @PathVariable Long id){

        if(clubService.getClubById(id).isPresent()){

            clubService.deleteClub(id);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();

    }

}