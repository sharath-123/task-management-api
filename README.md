# 📋 Task Management REST API

A RESTful Task Management API built using **Java**, **Spring Boot**, and **Maven** as part of the **Wellness360 Backend Case Study**.

The application allows users to create, retrieve, update, delete, and mark tasks as completed while following RESTful principles, proper validation, exception handling, and clean layered architecture.

---

## 🚀 Features

- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update an existing task
- Delete a task
- Mark a task as completed
- Request validation
- Global exception handling
- Basic Authentication
- Interactive API documentation using Swagger
- Unit testing with JUnit 5 and Mockito
- In-memory data storage using ConcurrentHashMap

---

## 🛠 Tech Stack

- Java 25
- Spring Boot 3
- Spring Web
- Spring Validation
- Spring Security
- SpringDoc OpenAPI (Swagger)
- Lombok
- Maven
- JUnit 5
- Mockito

---

## 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.sharath.TaskManager
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── exception
│   │       ├── model
│   │       ├── repository
│   │       ├── security
│   │       ├── service
│   │       └── TaskManagerApplication.java
│   │
│   └── resources
│       └── application.properties
│
└── test
    └── java
        └── service
            └── TaskServiceTest.java
```

---

## 📌 API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/tasks` | Retrieve all tasks |
| GET | `/tasks/{id}` | Retrieve task by ID |
| POST | `/tasks` | Create a new task |
| PUT | `/tasks/{id}` | Update an existing task |
| DELETE | `/tasks/{id}` | Delete a task |
| PATCH | `/tasks/{id}/complete` | Mark a task as completed |

---

## 🔐 Authentication

Basic Authentication is enabled.

| Username | Password |
|----------|----------|
| admin | password |

---

## 📚 API Documentation

Swagger UI is available at:

```
http://localhost:8080/swagger-ui/index.html
```

---

## ▶️ Running the Application

### Clone the repository

```bash
git clone https://github.com/<your-username>/task-management-api.git
```

### Navigate to the project

```bash
cd task-management-api
```

### Run the application

```bash
./mvnw spring-boot:run
```

or

```bash
mvn spring-boot:run
```

The application starts on

```
http://localhost:8080
```

---

## 🧪 Running Unit Tests

```bash
./mvnw test
```

or

```bash
mvn test
```

---

## 🏗 Design Decisions

- Used **ConcurrentHashMap** as an in-memory datastore as specified in the assignment.
- Used **AtomicLong** for generating unique task IDs.
- Implemented **DTO** pattern to separate API requests from the domain model.
- Applied **Global Exception Handling** using `@RestControllerAdvice`.
- Used **Bean Validation** for request validation.
- Implemented **Spring Security Basic Authentication**.
- Added **Swagger/OpenAPI** for API documentation.
- Wrote **JUnit 5 + Mockito** tests for the service layer.

---

## 🚀 Future Enhancements

- Database integration (MySQL/PostgreSQL)
- Spring Data JPA
- JWT Authentication
- Pagination and Sorting
- Search and Filter APIs
- Docker support

---

## 👨‍💻 Author

**Sharath Chandra**

Built as part of the Wellness360 Backend Case Study.
