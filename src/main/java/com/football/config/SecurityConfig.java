package com.football.config;

import com.football.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())
        .sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authorizeHttpRequests(authz -> authz
        
    .requestMatchers("/api/clubs/**").permitAll()
    .requestMatchers(
        "/api/auth/**",
        "/api/ai/**",
        "/api/districts/**",
        "/api/player-levels/**",
        "/api/players/**",
        "/api/scouts/**",
        "/api/recruitment/**",
        "/api/videos/**",
        "/api/shortlists/**",

        "/",
        "/index.html",
        "/player-registration.html",
        "/player-dashboard.html",
        "/player-recruitment.html",
        "/club-dashboard.html",
        "/edit-profile.html",
        "/upload-video.html",
        "/my-videos.html",
        "/scout-dashboard.html",
        "/my-shortlisted-players.html",
        "/style.css",
        "/script.js"
        
    ).permitAll()
    .requestMatchers("/api/admin/**").hasRole("ADMIN")
    .anyRequest().authenticated()
)
        
        .addFilterBefore(jwtAuthenticationFilter,
                UsernamePasswordAuthenticationFilter.class);

    return http.build();
}
}
