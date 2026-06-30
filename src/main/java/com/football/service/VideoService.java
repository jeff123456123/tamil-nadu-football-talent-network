package com.football.service;

import com.football.entity.Video;
import com.football.entity.Player;
import com.football.entity.Scout;
import com.football.entity.User;
import java.util.List;
import java.util.Optional;

public interface VideoService {
    Video uploadVideo(Video video);
    
    Optional<Video> getVideoById(Long id);
    
    List<Video> getAllVideos();
    
    List<Video> getVideosByPlayer(Player player);
    
    List<Video> getVideosByScout(Scout scout);
    
    List<Video> getVideosByUploader(User uploadedBy);
    
    Video updateVideo(Long id, Video videoDetails);
    
    void deleteVideo(Long id);
}
