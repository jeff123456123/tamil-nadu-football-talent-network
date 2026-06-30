# Tamil Nadu Football Talent Network - Setup Guide

## Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+

## Database Setup

1. Create MySQL database:
```sql
CREATE DATABASE football_db;
```

2. Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/football_db
spring.datasource.username=root
spring.datasource.password=your_password
```

## Build & Run

### Build the project:
```bash
mvn clean package
```

### Run the application:
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Frontend Access

- **Login Page:** `http://localhost:8080/login.html`
- **Player Registration:** `http://localhost:8080/player-registration.html`
- **Club Dashboard:** `http://localhost:8080/club-dashboard.html`

## Project Structure

```
src/main/java/com/football/
├── FootballTalentNetworkApplication.java  (Main Application)
├── config/                                 (Configuration classes)
├── controller/                             (REST API Controllers)
├── entity/                                 (JPA Entities)
├── repository/                             (Data Access Layer)
└── service/                                (Business Logic)

src/main/resources/
├── application.properties                  (Spring Boot Configuration)
└── static/                                 (Frontend Files)
    ├── login.html
    ├── player-registration.html
    └── club-dashboard.html
```

## API Documentation

All APIs follow REST conventions on `/api/**` endpoints:

- Users: `/api/users`
- Districts: `/api/districts`
- Clubs: `/api/clubs`
- Players: `/api/players`
- Scouts: `/api/scouts`
- Coaches: `/api/coaches`
- Trials: `/api/trials`
- Trial Applications: `/api/trial-applications`
- Videos: `/api/videos`

## Troubleshooting

1. **Port Already in Use:**
   Change port in `application.properties`:
   ```properties
   server.port=8081
   ```

2. **Database Connection Error:**
   Ensure MySQL is running and credentials are correct

3. **CORS Errors:**
   Check that CORS is enabled in `FootballTalentNetworkApplication.java`

## Next Steps

1. Initialize database with sample data (Districts, Player Levels)
2. Create user accounts for testing
3. Integrate authentication with JWT tokens
4. Add file upload functionality for videos
