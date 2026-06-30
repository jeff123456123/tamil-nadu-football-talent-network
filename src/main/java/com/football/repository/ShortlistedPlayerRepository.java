package com.football.repository;

import com.football.entity.ShortlistedPlayer;
import com.football.entity.Scout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShortlistedPlayerRepository
        extends JpaRepository<ShortlistedPlayer, Long> {

    List<ShortlistedPlayer> findByScout(Scout scout);
}