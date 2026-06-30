package com.football.repository;

import com.football.entity.Coach;
import com.football.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    Optional<Coach> findByUserId(Long userId);
    
    List<Coach> findByClub(Club club);
    
    List<Coach> findBySpecialization(String specialization);
    
    List<Coach> findByActive(Boolean active);
}
