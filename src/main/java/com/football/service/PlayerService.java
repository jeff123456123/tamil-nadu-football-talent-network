package com.football.service;

import com.football.entity.Player;
import com.football.entity.Club;
import com.football.entity.District;
import java.util.List;
import java.util.Optional;

public interface PlayerService {
    Player createPlayer(Player player);
    
    Optional<Player> getPlayerById(Long id);
    
    List<Player> getAllPlayers();
    
    Optional<Player> getPlayerByUserId(Long userId);
    
    List<Player> getPlayersByClub(Club club);
    
    List<Player> getPlayersByDistrict(District district);
    
    List<Player> getActivePlayers();
    
    Player updatePlayer(Long id, Player playerDetails);
    
    void deletePlayer(Long id);
}
