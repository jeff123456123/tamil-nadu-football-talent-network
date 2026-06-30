package com.football.service;

public interface OpenAIService {

    String analyzePlayer(
        String position,
        Double height,
        Double weight

    );
}