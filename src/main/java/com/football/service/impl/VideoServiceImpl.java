package com.football.service.impl;

import com.football.entity.Video;
import com.football.entity.Player;
import com.football.entity.Scout;
import com.football.entity.User;
import com.football.repository.VideoRepository;
import com.football.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VideoServiceImpl implements VideoService {
    
    @Autowired
    private VideoRepository videoRepository;
    
    @Override
    public Video uploadVideo(Video video) {
        return videoRepository.save(video);
    }
    
    @Override
    public Optional<Video> getVideoById(Long id) {
        return videoRepository.findById(id);
    }
    
    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }
    
    @Override
    public List<Video> getVideosByPlayer(Player player) {
        return videoRepository.findByPlayer(player);
    }
    
    @Override
    public List<Video> getVideosByScout(Scout scout) {
        return videoRepository.findByScout(scout);
    }
    
    @Override
    public List<Video> getVideosByUploader(User uploadedBy) {
        return videoRepository.findByUploadedBy(uploadedBy);
    }
    
    @Override
    public Video updateVideo(Long id, Video videoDetails) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            Video existingVideo = video.get();
            existingVideo.setTitle(videoDetails.getTitle());
            existingVideo.setDescription(videoDetails.getDescription());
            existingVideo.setFileUrl(videoDetails.getFileUrl());
            return videoRepository.save(existingVideo);
        }
        return null;
    }
    
    @Override
    public void deleteVideo(Long id) {
        videoRepository.deleteById(id);
    }
}
