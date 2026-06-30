package com.football.repository;

import com.football.entity.Video;
import com.football.entity.Player;
import com.football.entity.Scout;
import com.football.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findByPlayer(Player player);
    
    List<Video> findByScout(Scout scout);
    
    List<Video> findByUploadedBy(User uploadedBy);
}
