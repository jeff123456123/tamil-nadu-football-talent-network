package com.football.repository;

import com.football.entity.RecruitmentRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecruitmentRequestRepository
        extends JpaRepository<RecruitmentRequest, Integer> {

    List<RecruitmentRequest> findByPlayerId(Long playerId);

    List<RecruitmentRequest> findByScoutId(Long scoutId);

}