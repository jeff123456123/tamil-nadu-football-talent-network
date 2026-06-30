package com.football.service.impl;

import com.football.entity.Player;
import com.football.entity.Club;
import com.football.entity.District;
import com.football.repository.PlayerRepository;
import com.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {
    
    @Autowired
    private PlayerRepository playerRepository;
    
    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }
    
    @Override
    public Optional<Player> getPlayerById(Long id) {
        return playerRepository.findById(id);
    }
    
    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
    
    @Override
    public Optional<Player> getPlayerByUserId(Long userId) {
        return playerRepository.findByUserId(userId);
    }
    
    @Override
    public List<Player> getPlayersByClub(Club club) {
        return playerRepository.findByClub(club);
    }
    
    @Override
    public List<Player> getPlayersByDistrict(District district) {
        return playerRepository.findByDistrict(district);
    }
    
    @Override
    public List<Player> getActivePlayers() {
        return playerRepository.findByActive(true);
    }
    
    @Override
    public Player updatePlayer(Long id, Player playerDetails) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            Player existingPlayer = player.get();
            existingPlayer.setClub(playerDetails.getClub());
            existingPlayer.setHeight(playerDetails.getHeight());
            existingPlayer.setWeight(playerDetails.getWeight());
            existingPlayer.setPosition(playerDetails.getPosition());
            existingPlayer.setStatistics(playerDetails.getStatistics());
            existingPlayer.setActive(playerDetails.getActive());
            return playerRepository.save(existingPlayer);
        }
        return null;
    }
    
    @Override
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
    }
}
