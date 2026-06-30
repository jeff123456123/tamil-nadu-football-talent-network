package com.football.config;

import com.football.dto.*;
import com.football.entity.*;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DtoMapper {
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    // User mappings
    public UserDto toUserDto(User user) {
        if (user == null) return null;
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setRole(user.getRole() != null ? user.getRole().toString() : null);
        dto.setActive(user.getActive());
        if (user.getCreatedAt() != null) {
            dto.setCreatedAt(user.getCreatedAt().format(formatter));
        }
        if (user.getUpdatedAt() != null) {
            dto.setUpdatedAt(user.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    public User toUserEntity(UserDto dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setEmail(dto.getEmail());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        if (dto.getRole() != null) {
            user.setRole(User.UserRole.valueOf(dto.getRole()));
        }
        user.setActive(dto.getActive());
        return user;
    }
    
    // Player mappings
    public PlayerDto toPlayerDto(Player player) {
        if (player == null) return null;
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        if (player.getUser() != null) {
            dto.setUserId(player.getUser().getId());
            dto.setUserEmail(player.getUser().getEmail());
        }
        if (player.getClub() != null) {
            dto.setClubId(player.getClub().getId());
            dto.setClubName(player.getClub().getName());
        }
        if (player.getDistrict() != null) {
            dto.setDistrictId(player.getDistrict().getId());
            dto.setDistrictName(player.getDistrict().getName());
        }
        dto.setDateOfBirth(player.getDateOfBirth());
        dto.setHeight(player.getHeight());
        dto.setWeight(player.getWeight());
        dto.setPosition(player.getPosition());
        dto.setStatistics(player.getStatistics());
        dto.setActive(player.getActive());
        if (player.getCreatedAt() != null) {
            dto.setCreatedAt(player.getCreatedAt().format(formatter));
        }
        if (player.getUpdatedAt() != null) {
            dto.setUpdatedAt(player.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    // Club mappings
    public ClubDto toClubDto(Club club) {
        if (club == null) return null;
        ClubDto dto = new ClubDto();
        dto.setId(club.getId());
        dto.setName(club.getName());
        dto.setCity(club.getCity());
        dto.setFoundedYear(club.getFoundedYear());
        dto.setActive(club.getActive());
        if (club.getCreatedAt() != null) {
            dto.setCreatedAt(club.getCreatedAt().format(formatter));
        }
        if (club.getUpdatedAt() != null) {
            dto.setUpdatedAt(club.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    public Club toClubEntity(ClubDto dto) {
        if (dto == null) return null;
        Club club = new Club();
        club.setId(dto.getId());
        club.setName(dto.getName());
        club.setCity(dto.getCity());
        club.setFoundedYear(dto.getFoundedYear());
        club.setActive(dto.getActive());
        return club;
    }
    
    // Coach mappings
    public CoachDto toCoachDto(Coach coach) {
        if (coach == null) return null;
        CoachDto dto = new CoachDto();
        dto.setId(coach.getId());
        if (coach.getUser() != null) {
            dto.setUserId(coach.getUser().getId());
            dto.setUserEmail(coach.getUser().getEmail());
            dto.setUserName(coach.getUser().getFirstName() + " " + coach.getUser().getLastName());
        }
        if (coach.getClub() != null) {
            dto.setClubId(coach.getClub().getId());
            dto.setClubName(coach.getClub().getName());
        }
        dto.setSpecialization(coach.getSpecialization());
        dto.setYearsExperience(coach.getYearsExperience());
        dto.setActive(coach.getActive());
        if (coach.getCreatedAt() != null) {
            dto.setCreatedAt(coach.getCreatedAt().format(formatter));
        }
        if (coach.getUpdatedAt() != null) {
            dto.setUpdatedAt(coach.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    // Scout mappings
    public ScoutDto toScoutDto(Scout scout) {
        if (scout == null) return null;
        ScoutDto dto = new ScoutDto();
        dto.setId(scout.getId());
        if (scout.getUser() != null) {
            dto.setUserId(scout.getUser().getId());
            dto.setUserEmail(scout.getUser().getEmail());
            dto.setUserName(scout.getUser().getFirstName() + " " + scout.getUser().getLastName());
        }
        dto.setSpecialization(scout.getSpecialization());
        dto.setExperience(scout.getExperience());
        dto.setActive(scout.getActive());
        if (scout.getCreatedAt() != null) {
            dto.setCreatedAt(scout.getCreatedAt().format(formatter));
        }
        if (scout.getUpdatedAt() != null) {
            dto.setUpdatedAt(scout.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    // Trial mappings
    public TrialDto toTrialDto(Trial trial) {
        if (trial == null) return null;
        TrialDto dto = new TrialDto();
        dto.setId(trial.getId());
        if (trial.getClub() != null) {
            dto.setClubId(trial.getClub().getId());
            dto.setClubName(trial.getClub().getName());
        }
        if (trial.getDistrict() != null) {
            dto.setDistrictId(trial.getDistrict().getId());
            dto.setDistrictName(trial.getDistrict().getName());
        }
        if (trial.getPlayerLevel() != null) {
            dto.setPlayerLevelId(trial.getPlayerLevel().getId());
            dto.setPlayerLevelName(trial.getPlayerLevel().getLevel().toString());
        }
        dto.setTrialDate(trial.getTrialDate());
        dto.setLocation(trial.getLocation());
        dto.setDescription(trial.getDescription());
        dto.setCapacity(trial.getCapacity());
        dto.setActive(trial.getActive());
        if (trial.getCreatedAt() != null) {
            dto.setCreatedAt(trial.getCreatedAt().format(formatter));
        }
        if (trial.getUpdatedAt() != null) {
            dto.setUpdatedAt(trial.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    // TrialApplication mappings
    public TrialApplicationDto toTrialApplicationDto(TrialApplication app) {
        if (app == null) return null;
        TrialApplicationDto dto = new TrialApplicationDto();
        dto.setId(app.getId());
        if (app.getPlayer() != null && app.getPlayer().getUser() != null) {
            dto.setPlayerId(app.getPlayer().getId());
            dto.setPlayerEmail(app.getPlayer().getUser().getEmail());
        }
        if (app.getTrial() != null) {
            dto.setTrialId(app.getTrial().getId());
            dto.setTrialLocation(app.getTrial().getLocation());
        }
        dto.setStatus(app.getStatus().toString());
        if (app.getAppliedDate() != null) {
            dto.setAppliedDate(app.getAppliedDate().format(formatter));
        }
        if (app.getUpdatedAt() != null) {
            dto.setUpdatedAt(app.getUpdatedAt().format(formatter));
        }
        return dto;
    }
    
    // District mappings
    public DistrictDto toDistrictDto(District district) {
        if (district == null) return null;
        DistrictDto dto = new DistrictDto();
        dto.setId(district.getId());
        dto.setName(district.getName());
        if (district.getCreatedAt() != null) {
            dto.setCreatedAt(district.getCreatedAt().format(formatter));
        }
        return dto;
    }
    
    public District toDistrictEntity(DistrictDto dto) {
        if (dto == null) return null;
        District district = new District();
        district.setId(dto.getId());
        district.setName(dto.getName());
        return district;
    }
    
    // PlayerLevel mappings
    public PlayerLevelDto toPlayerLevelDto(PlayerLevel level) {
        if (level == null) return null;
        PlayerLevelDto dto = new PlayerLevelDto();
        dto.setId(level.getId());
        dto.setLevel(level.getLevel().toString());
        return dto;
    }
    
    // Video mappings
    public VideoDto toVideoDto(Video video) {
        if (video == null) return null;
        VideoDto dto = new VideoDto();
        dto.setId(video.getId());
        if (video.getPlayer() != null && video.getPlayer().getUser() != null) {
            dto.setPlayerId(video.getPlayer().getId());
            dto.setPlayerEmail(video.getPlayer().getUser().getEmail());
        }
        if (video.getScout() != null && video.getScout().getUser() != null) {
            dto.setScoutId(video.getScout().getId());
            dto.setScoutEmail(video.getScout().getUser().getEmail());
        }
        dto.setFileUrl(video.getFileUrl());
        dto.setTitle(video.getTitle());
        dto.setDescription(video.getDescription());
        if (video.getUploadedBy() != null) {
            dto.setUploadedById(video.getUploadedBy().getId());
            dto.setUploadedByEmail(video.getUploadedBy().getEmail());
        }
        if (video.getCreatedAt() != null) {
            dto.setCreatedAt(video.getCreatedAt().format(formatter));
        }
        return dto;
    }
}
