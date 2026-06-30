package com.football.entity;

import jakarta.persistence.*;

@Entity
public class RecruitmentRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Scout scout;

    @ManyToOne
    private Player player;

    private String status = "PENDING";

    public RecruitmentRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Scout getScout() {
        return scout;
    }

    public void setScout(Scout scout) {
        this.scout = scout;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

