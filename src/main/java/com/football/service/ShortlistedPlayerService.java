package com.football.service;

import com.football.entity.ShortlistedPlayer;
import com.football.entity.Scout;

import java.util.List;
import java.util.Optional;

public interface ShortlistedPlayerService {

    ShortlistedPlayer saveShortlist(
            ShortlistedPlayer shortlistedPlayer);

    List<ShortlistedPlayer> getShortlistedPlayersByScout(
            Scout scout);

    Optional<ShortlistedPlayer> getShortlistedPlayerById(
            Long id);

    void deleteShortlistedPlayer(Long id);
}