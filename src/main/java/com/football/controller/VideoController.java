package com.football.controller;

import com.football.entity.Video;
import com.football.entity.Player;
import com.football.entity.Scout;
import com.football.entity.User;
import com.football.service.VideoService;
import com.football.service.PlayerService;
import com.football.service.ScoutService;
import com.football.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/videos")
@CrossOrigin(origins = "*")
public class VideoController {
    
    @Autowired
    private VideoService videoService;
    
    @Autowired
    private PlayerService playerService;
    
    @Autowired
    private ScoutService scoutService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public ResponseEntity<Video> uploadVideo(@RequestBody Video video) {
        Video savedVideo = videoService.uploadVideo(video);
        return new ResponseEntity<>(savedVideo, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoById(@PathVariable Long id) {
        Optional<Video> video = videoService.getVideoById(id);
        return video.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<Video>> getAllVideos() {
        List<Video> videos = videoService.getAllVideos();
        return ResponseEntity.ok(videos);
    }
    
    @GetMapping("/player/{playerId}")
    public ResponseEntity<List<Video>> getVideosByPlayer(@PathVariable Long playerId) {
        Optional<Player> player = playerService.getPlayerById(playerId);
        if (player.isPresent()) {
            List<Video> videos = videoService.getVideosByPlayer(player.get());
            return ResponseEntity.ok(videos);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/scout/{scoutId}")
    public ResponseEntity<List<Video>> getVideosByScout(@PathVariable Long scoutId) {
        Optional<Scout> scout = scoutService.getScoutById(scoutId);
        if (scout.isPresent()) {
            List<Video> videos = videoService.getVideosByScout(scout.get());
            return ResponseEntity.ok(videos);
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/uploader/{userId}")
    public ResponseEntity<List<Video>> getVideosByUploader(@PathVariable Long userId) {
        Optional<User> user = userService.getUserById(userId);
        if (user.isPresent()) {
            List<Video> videos = videoService.getVideosByUploader(user.get());
            return ResponseEntity.ok(videos);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Video> updateVideo(@PathVariable Long id, @RequestBody Video videoDetails) {
        Video updatedVideo = videoService.updateVideo(id, videoDetails);
        return updatedVideo != null ? ResponseEntity.ok(updatedVideo) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable Long id) {
        if (videoService.getVideoById(id).isPresent()) {
            videoService.deleteVideo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
