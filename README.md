Application Tracker
A backend REST API for managing job applications built with Spring Boot, JWT authentication, and PostgreSQL — deployed on AWS using a fully containerized CI/CD pipeline.
Overview
Application Tracker provides a secure backend API that allows users to register and authenticate using JWT, perform full CRUD operations on job applications, and persist data using PostgreSQL. The project is backend-only and designed to be paired with a frontend in the future.
Features

JWT-based authentication & authorization
CRUD operations for job applications
PostgreSQL database integration via AWS RDS
Environment-based configuration using Spring Boot profiles
Containerized with Docker using multi-stage builds (66% image size reduction)
Deployed on AWS EC2 with images stored in Amazon ECR
Automated CI/CD pipeline via GitHub Actions — pushes to main trigger automatic build and deployment

Tech Stack
Backend: Java, Spring Boot, Spring Security, JWT
Database: PostgreSQL, AWS RDS
Cloud & DevOps: AWS EC2, AWS RDS, Amazon ECR, Docker, GitHub Actions, Maven
Tools: Postman, Git & GitHub
Architecture
GitHub (push to main)
    → GitHub Actions CI/CD
        → Build Docker image (linux/amd64)
        → Push to Amazon ECR
        → SSH into EC2
        → Pull latest image & redeploy container
            → Spring Boot app connects to AWS RDS PostgreSQL
Getting Started (Local Development)
1. Clone the Repository
bashgit clone https://github.com/victorg224/Application-Tracker.git
cd Application-Tracker
```

**2. Configure Environment Variables**

Create a `.env` file in the project root:
```
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/yourdb
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
JWT_EXPIRATION=86400000
3. Run with Docker
bashdocker build -t application-tracker -f dockerfile .
docker run -p 8080:8080 --env-file .env application-tracker


API Endpoints

Method    Endpoint                  Description                 Auth Required
POST     /api/auth/register         Register a new user         No
POST     /api/auth/login            Login and receive JWT       No
GET      /api/applications          Get all applications        Yes
POST     /api/applications          Create application          Yes
PUT      /api/applications/{id}     Update application          Yes
DELETE   /api/applications/{id}     Delete application          Yes


Deployment
The application is deployed on AWS EC2 with the following infrastructure:

Amazon ECR — private Docker image registry
AWS EC2 — hosts and runs the Docker container
AWS RDS — managed PostgreSQL database
GitHub Actions — automated CI/CD pipeline on push to main
