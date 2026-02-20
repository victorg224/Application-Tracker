# 📋 Application Tracker

> A backend REST API for managing job applications built with Spring Boot, JWT authentication, and PostgreSQL — deployed on AWS using a fully containerized CI/CD pipeline.

---

## 📖 Overview

Application Tracker provides a secure backend API that allows users to register and authenticate using JWT, perform full CRUD operations on job applications, and persist data using PostgreSQL. The project is backend-only and designed to be paired with a frontend in the future.

---

## ✨ Features

- 🔐 JWT-based authentication & authorization
- 📝 Full CRUD operations for job applications
- 🗃️ PostgreSQL integration via AWS RDS
- ⚙️ Environment-based configuration using Spring Boot profiles
- 🐳 Multi-stage Docker builds (66% image size reduction)
- ☁️ Docker images stored in Amazon ECR
- 🚀 Automated CI/CD — every push to `main` triggers a full build and deployment

---

## 🛠️ Tech Stack

| Category | Technologies |
|----------|-------------|
| **Backend** | Java 23, Spring Boot, Spring Security, JWT |
| **Database** | PostgreSQL, AWS RDS |
| **Cloud** | AWS EC2, AWS RDS, Amazon ECR |
| **DevOps** | Docker, GitHub Actions, Maven |
| **Tools** | Postman, Git & GitHub |

---

## 🏗️ Architecture
```
GitHub (push to main)
    → GitHub Actions CI/CD
        → Build Docker image (linux/amd64)
        → Push to Amazon ECR
        → SSH into EC2
        → Pull latest image & redeploy container
            → Spring Boot app connects to AWS RDS PostgreSQL
```

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/victorg224/Application-Tracker.git
cd Application-Tracker
```

### 2. Configure Environment Variables

Create a `.env` file in the project root:
```env
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/yourdb
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
JWT_SECRET=your_jwt_secret
JWT_EXPIRATION=86400000
```

### 3. Run with Docker
```bash
docker build -t application-tracker -f dockerfile .
docker run -p 8080:8080 --env-file .env application-tracker
```

---

## 📡 API Endpoints

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `POST` | `/api/auth/register` | Register a new user | ❌ |
| `POST` | `/api/auth/login` | Login and receive JWT | ❌ |
| `GET` | `/api/applications` | Get all applications | ✅ |
| `POST` | `/api/applications` | Create application | ✅ |
| `PUT` | `/api/applications/{id}` | Update application | ✅ |
| `DELETE` | `/api/applications/{id}` | Delete application | ✅ |

---

## ☁️ Deployment

| Service | Purpose |
|---------|---------|
| **Amazon ECR** | Private Docker image registry |
| **AWS EC2** | Hosts and runs the Docker container |
| **AWS RDS** | Managed PostgreSQL database |
| **GitHub Actions** | Automated CI/CD pipeline |
