package com.football.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "shortlisted_players")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortlistedPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Scout who shortlisted the player
    @ManyToOne
    @JoinColumn(name = "scout_id", nullable = false)
    private Scout scout;

    // Player who was shortlisted
    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    // Date and time of shortlisting
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}