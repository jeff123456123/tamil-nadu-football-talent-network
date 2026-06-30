package com.football.repository;

import com.football.entity.PlayerLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PlayerLevelRepository extends JpaRepository<PlayerLevel, Long> {
    Optional<PlayerLevel> findByLevel(PlayerLevel.Level level);
}
