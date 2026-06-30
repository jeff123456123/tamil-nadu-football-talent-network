package com.football.service;

import com.football.entity.Club;

import java.util.List;
import java.util.Optional;

public interface ClubService {

    Club createClub(Club club);

    Optional<Club> getClubById(Long id);

    List<Club> getAllClubs();

    Optional<Club> getClubByName(String name);

    List<Club> getActiveClubs();

    Club updateClub(Long id, Club clubDetails);

    void deleteClub(Long id);

    

}