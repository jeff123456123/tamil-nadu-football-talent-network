package com.football.service.impl;

import com.football.entity.PlayerLevel;
import com.football.repository.PlayerLevelRepository;
import com.football.service.PlayerLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerLevelServiceImpl implements PlayerLevelService {
    
    @Autowired
    private PlayerLevelRepository playerLevelRepository;
    
    @Override
    public PlayerLevel createPlayerLevel(PlayerLevel playerLevel) {
        return playerLevelRepository.save(playerLevel);
    }
    
    @Override
    public Optional<PlayerLevel> getPlayerLevelById(Long id) {
        return playerLevelRepository.findById(id);
    }
    
    @Override
    public List<PlayerLevel> getAllPlayerLevels() {
        return playerLevelRepository.findAll();
    }
    
    @Override
    public Optional<PlayerLevel> getPlayerLevelByLevel(PlayerLevel.Level level) {
        return playerLevelRepository.findByLevel(level);
    }
    
    @Override
    public void deletePlayerLevel(Long id) {
        playerLevelRepository.deleteById(id);
    }
}
