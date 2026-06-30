package com.football.service.impl;

import com.football.entity.Club;
import com.football.repository.ClubRepository;
import com.football.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClubServiceImpl implements ClubService {

    @Autowired
    private ClubRepository clubRepository;

    @Override
    public Club createClub(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Optional<Club> getClubById(Long id) {
        return clubRepository.findById(id);
    }

    @Override
    public List<Club> getAllClubs() {
        return clubRepository.findAll();
    }

    @Override
    public Optional<Club> getClubByName(String name) {
        return clubRepository.findByName(name);
    }

    @Override
    public List<Club> getActiveClubs() {
        return clubRepository.findByActive(true);
    }

    @Override
    public Club updateClub(Long id, Club clubDetails) {
        Optional<Club> club = clubRepository.findById(id);

        if (club.isPresent()) {
            Club existingClub = club.get();
            existingClub.setName(clubDetails.getName());
            existingClub.setCity(clubDetails.getCity());
            existingClub.setFoundedYear(clubDetails.getFoundedYear());
            existingClub.setActive(clubDetails.getActive());
            return clubRepository.save(existingClub);
        }

        return null;
    }

    @Override
    public void deleteClub(Long id) {
        clubRepository.deleteById(id);
    }

    // ❌ REMOVE THIS METHOD COMPLETELY
    // public Optional<Club> getClubByUserId(Long userId)
}