package com.football.controller;

import com.football.entity.Player;
import com.football.service.OpenAIService;
import com.football.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@CrossOrigin(origins = "*")
public class AIController {

    @Autowired
    private OpenAIService openAIService;

    @Autowired
    private PlayerService playerService;

    @GetMapping("/player/{userId}")
    public String analyzePlayer(
            @PathVariable Long userId) {

        Player player =
                playerService.getPlayerByUserId(userId)
                        .orElse(null);

        if(player == null) {
            return "Player not found";
        }

        return openAIService.analyzePlayer(
                player.getPosition(),
                player.getHeight(),
                player.getWeight()
        );
    }
}