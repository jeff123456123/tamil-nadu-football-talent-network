package com.football.service;

import com.football.entity.PlayerLevel;
import java.util.List;
import java.util.Optional;

public interface PlayerLevelService {
    PlayerLevel createPlayerLevel(PlayerLevel playerLevel);
    
    Optional<PlayerLevel> getPlayerLevelById(Long id);
    
    List<PlayerLevel> getAllPlayerLevels();
    
    Optional<PlayerLevel> getPlayerLevelByLevel(PlayerLevel.Level level);
    
    void deletePlayerLevel(Long id);
}
