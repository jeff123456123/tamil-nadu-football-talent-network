package com.football.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "player_levels")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private Level level;

    public enum Level {
        STREET, SCHOOL, COLLEGE, DISTRICT, ACADEMY, LEAGUE, DIVISION, STATE, PROFESSIONAL
    }
}
