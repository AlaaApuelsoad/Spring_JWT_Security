# Spring JWT Security

A Spring Boot application that implements JSON Web Token (JWT) authentication and authorization to secure RESTful APIs. This project demonstrates how to integrate JWT-based security to manage user authentication, secure endpoints, and enforce role-based access control.

## Features

- **JWT Authentication and Authorization**: Securely authenticates users using JWT tokens. Each request must include a valid token in the Authorization header.
- **Role-Based Access Control (RBAC)**: Supports different user roles (e.g., `ADMIN`, `USER`) and secures endpoints based on user roles.
- **Password Encryption**: Uses `BCryptPasswordEncoder` for secure password hashing.
- **Custom JWT Filter**: Integrates a custom filter to validate JWT tokens in incoming requests.
- **Stateless Session Management**: Uses JWT for stateless authentication, making the application scalable.

## Technology Stack

- **Backend**: Spring Boot
- **Security**: Spring Security, JWT
- **Password Hashing**: BCrypt
- **Build Tool**: Maven
- **Java Version**: 17+

## Installation and Setup

1. **Clone the Repository**
   ```bash
   git clone https://github.com/AlaaApuelsoad/Spring_JWT_Security.git
   cd Spring_JWT_Security


1. **Configure the Database**

Update the application.properties file with your database configurations.
Run the Application
```bash
   mvn spring-boot:run

