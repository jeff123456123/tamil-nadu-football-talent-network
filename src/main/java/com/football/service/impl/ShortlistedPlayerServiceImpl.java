package com.football.service.impl;

import com.football.entity.ShortlistedPlayer;
import com.football.entity.Scout;
import com.football.repository.ShortlistedPlayerRepository;
import com.football.service.ShortlistedPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShortlistedPlayerServiceImpl
        implements ShortlistedPlayerService {

    @Autowired
    private ShortlistedPlayerRepository repository;

    @Override
    public ShortlistedPlayer saveShortlist(
            ShortlistedPlayer shortlistedPlayer) {

        return repository.save(shortlistedPlayer);
    }

    @Override
    public List<ShortlistedPlayer>
    getShortlistedPlayersByScout(Scout scout) {

        return repository.findByScout(scout);
    }

    @Override
    public Optional<ShortlistedPlayer>
    getShortlistedPlayerById(Long id) {

        return repository.findById(id);
    }

    @Override
    public void deleteShortlistedPlayer(Long id) {

        repository.deleteById(id);
    }
}