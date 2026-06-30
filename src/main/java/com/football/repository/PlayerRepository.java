package com.football.repository;

import com.football.entity.Player;
import com.football.entity.Club;
import com.football.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByUserId(Long userId);
    
    List<Player> findByClub(Club club);
    
    List<Player> findByDistrict(District district);
    
    List<Player> findByActive(Boolean active);
}
