package com.football.service;

import org.springframework.stereotype.Service;

@Service
public class OpenAIServiceImpl implements OpenAIService {

    @Override
    public String analyzePlayer(
            String position,
            Double height,
            Double weight
    ) {

        try {

            String prompt =
                "You are a football scout expert.\n\n" +
                "Analyze this player:\n" +
                "Position: " + position + "\n" +
                "Height: " + height + "\n" +
                "Weight: " + weight + "\n\n" +
                "Give:\n" +
                "1. Player strengths\n" +
                "2. Weaknesses\n" +
                "3. Training recommendations\n" +
                "4. Potential score out of 10";

            // SIMPLE MOCK (WORKING VERSION FIRST)
            // later we connect real OpenAI API

            if(position == null) {
                return "No data available";
            }

            return "🤖 AI SCOUT REPORT\n\n" +
                   "Player: " + position + "\n\n" +
                   "Strong physical profile.\n" +
                   "Needs improvement in technical skills.\n\n" +
                   "Recommended Training:\n" +
                   "✔ Stamina\n✔ Passing\n✔ Awareness\n\n" +
                   "Potential Score: 8/10";

        } catch(Exception e) {
            return "AI analysis failed";
        }
    }
}