# 🚀 Online Learning Platform

An Online Learning Platform designed to provide seamless access to courses and learning materials. This project is built with a **React.js frontend** and a **Java Spring Boot backend**.

## ⚙️ Technologies Used

- Frontend: React.js, CSS, JavaScript
- Backend: Java, Spring Boot
- Database: MySQL
- Build Tools: Maven (Java), npm (React)

## 🚀 Getting started

### 1️⃣ Backend Setup

```bash
cd demo
./mvnw clean install
./mvnw spring-boot:run
```

- API runs on `http://localhost:8080`

### 2️⃣ Frontend Setup

```bash
cd my-app
npm install
npm start
```

- App runs on `http://localhost:3000`

## 🔗 API Endpoints

- **POST** `/courses/addCourse` - Add a new course

- **GET** `/courses/getAll` - List all courses

- **GET** `/demo/test` - Test API

- **POST** `/demo/signup` - Add a new user or admin.

- **POST** `/demo/login` - User or admin can access contents.

## 💡 Features

- User Registration & Login
- Course Management (CRUD)
- Admin Dashboard for course control
- Responsive UI
