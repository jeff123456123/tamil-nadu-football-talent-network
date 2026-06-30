package com.football.repository;

import com.football.entity.TrialApplication;
import com.football.entity.Player;
import com.football.entity.Trial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TrialApplicationRepository extends JpaRepository<TrialApplication, Long> {
    List<TrialApplication> findByPlayer(Player player);
    
    List<TrialApplication> findByTrial(Trial trial);
    
    List<TrialApplication> findByStatus(TrialApplication.ApplicationStatus status);
}
