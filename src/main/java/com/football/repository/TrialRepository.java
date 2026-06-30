package com.football.repository;

import com.football.entity.Trial;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.entity.PlayerLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrialRepository extends JpaRepository<Trial, Long> {
    List<Trial> findByClub(Club club);
    
    List<Trial> findByDistrict(District district);
    
    List<Trial> findByPlayerLevel(PlayerLevel playerLevel);
    
    List<Trial> findByTrialDate(LocalDate trialDate);
    
    List<Trial> findByActive(Boolean active);
}
