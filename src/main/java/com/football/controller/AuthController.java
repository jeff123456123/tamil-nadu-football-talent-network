package com.football.controller;

import com.football.dto.LoginRequest;
import com.football.dto.LoginResponse;
import com.football.entity.User;
import com.football.service.UserService;
import com.football.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.getUserByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new ErrorResponse("Email already registered"));
        }
        user.setActive(true);
        if (user.getRole() == null) {
            user.setRole(User.UserRole.PLAYER);
        }
        User registeredUser = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(registeredUser);
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByEmail(loginRequest.getEmail());
        
        if (!user.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid email or password"));
        }
        
        User foundUser = user.get();
        // Verify password using BCrypt
        if (!passwordEncoder.matches(loginRequest.getPassword(), foundUser.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid email or password"));
        }
        
        if (!foundUser.getActive()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("User account is inactive"));
        }
        
        String token = jwtTokenProvider.generateToken(foundUser.getEmail(), foundUser.getId());
        
        LoginResponse response = new LoginResponse(
                token,
                foundUser.getId(),
                foundUser.getEmail(),
                foundUser.getFirstName(),
                foundUser.getLastName(),
                foundUser.getRole().toString()
        );
        
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestHeader(value = "Authorization", required = false) String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Missing or invalid token"));
        }
        
        String token = authHeader.substring(7);
        
        if (!jwtTokenProvider.validateToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new ErrorResponse("Invalid token"));
        }
        
        String email = jwtTokenProvider.getEmailFromToken(token);
        Long userId = jwtTokenProvider.getUserIdFromToken(token);
        
        return ResponseEntity.ok(new TokenValidationResponse(true, email, userId));
    }
    
    public static class ErrorResponse {
        public String message;
        
        public ErrorResponse(String message) {
            this.message = message;
        }
        
        public String getMessage() {
            return message;
        }
    }
    
    public static class TokenValidationResponse {
        public boolean valid;
        public String email;
        public Long userId;
        
        public TokenValidationResponse(boolean valid, String email, Long userId) {
            this.valid = valid;
            this.email = email;
            this.userId = userId;
        }
        
        public boolean isValid() {
            return valid;
        }
        
        public String getEmail() {
            return email;
        }
        
        public Long getUserId() {
            return userId;
        }
    }
}
