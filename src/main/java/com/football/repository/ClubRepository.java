package com.football.repository;

import com.football.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClubRepository extends JpaRepository<Club, Long> {

    Optional<Club> findByName(String name);

    List<Club> findByActive(Boolean active);

    // ❌ REMOVE THIS (it breaks app)
    // Optional<Club> findByUserId(Long userId);
}