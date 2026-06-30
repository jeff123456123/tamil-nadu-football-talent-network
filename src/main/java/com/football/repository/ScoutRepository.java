package com.football.repository;

import com.football.entity.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ScoutRepository extends JpaRepository<Scout, Long> {
    Optional<Scout> findByUserId(Long userId);
    
    List<Scout> findBySpecialization(String specialization);
    
    List<Scout> findByActive(Boolean active);
}
