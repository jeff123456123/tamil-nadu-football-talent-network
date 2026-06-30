package com.football.controller;

import com.football.entity.RecruitmentRequest;
import com.football.repository.RecruitmentRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recruitment")
@CrossOrigin("*")
public class RecruitmentRequestController {

    @Autowired
    private RecruitmentRequestRepository repository;

    @PostMapping
    public RecruitmentRequest createRequest(
            @RequestBody RecruitmentRequest request) {

        request.setStatus("PENDING");
        return repository.save(request);
    }

    @GetMapping("/player/{playerId}")
    public List<RecruitmentRequest> getPlayerRequests(
            @PathVariable Long playerId) {

        return repository.findByPlayerId(playerId);
    }

    @GetMapping("/scout/{scoutId}")
    public List<RecruitmentRequest> getScoutRequests(
            @PathVariable Long scoutId) {

        return repository.findByScoutId(scoutId);
    }

    @PutMapping("/{id}/{status}")
    public RecruitmentRequest updateStatus(
            @PathVariable Integer id,
            @PathVariable String status) {

        RecruitmentRequest request =
                repository.findById(id).orElseThrow();

        request.setStatus(status);

        return repository.save(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(
            @PathVariable Integer id) {

        repository.deleteById(id);
    }
}