# 📚 Book Management System Backend

Spring Boot backend for book and user management system.

---

## 🚀 Features

- Add, update, delete, and list books
- Add, update, delete, and list users
- Soft delete support for books and users
- Validation for book and user data
- RESTful API for books and users
- CORS configuration for frontend integration

---

## 🛠️ Tech Stack

- Java 21
- Spring Boot 3.5.5
- Spring Data JPA
- MySQL
- Lombok
- Maven

---

## ⚡ Getting Started

### 1️⃣ Prerequisites

- Java 21+
- Maven
- MySQL (running on `localhost:3307` with database `bms`)

### 2️⃣ Setup Database

Create the database in MySQL:
```sql
CREATE DATABASE bms;
```

### 3️⃣ Configure Database Credentials

Edit `src/main/resources/application.properties` if needed:
```
spring.datasource.url=jdbc:mysql://localhost:3307/bms
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 4️⃣ Build & Run

```sh
./mvnw spring-boot:run
```

The backend will start at [http://localhost:8080](http://localhost:8080).

---

## 📖 API Documentation

Base URL: `/api/v1`

### 📚 Book Endpoints

#### ➕ Create Book

- **POST** `/books`
- **Body:**  
  ```json
  {
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationDate": "2024-06-01"
  }
  ```
- **Response:**  
  `201 Created`  
  ```json
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationDate": "2024-06-01"
  }
  ```

#### 📚 Get All Books

- **GET** `/books`
- **Response:**  
  `200 OK`  
  ```json
  [
    {
      "id": 1,
      "title": "Book Title",
      "author": "Author Name",
      "isbn": "1234567890",
      "publicationDate": "2024-06-01"
    }
  ]
  ```

#### 🔍 Get Book By ID

- **GET** `/books/{id}`
- **Response:**  
  `200 OK`  
  ```json
  {
    "id": 1,
    "title": "Book Title",
    "author": "Author Name",
    "isbn": "1234567890",
    "publicationDate": "2024-06-01"
  }
  ```

#### ✏️ Update Book

- **PUT** `/books/{id}`
- **Body:**  
  ```json
  {
    "title": "Updated Title",
    "author": "Updated Author",
    "isbn": "0987654321",
    "publicationDate": "2024-07-01"
  }
  ```
- **Response:**  
  `200 OK`  
  ```json
  {
    "id": 1,
    "title": "Updated Title",
    "author": "Updated Author",
    "isbn": "0987654321",
    "publicationDate": "2024-07-01"
  }
  ```

#### 🗑️ Delete Book (Soft Delete)

- **DELETE** `/books/{id}`
- **Response:**  
  `200 OK`  
  `"Book deleted Successfully"`

#### 📅 Get Books By Published Date

- **GET** `/books/by-date?fromDate=2024-01-01&toDate=2024-12-31`
- **Response:**  
  `200 OK`  
  ```json
  [
    {
      "id": 1,
      "title": "Book Title",
      "author": "Author Name",
      "isbn": "1234567890",
      "publicationDate": "2024-06-01"
    }
  ]
  ```

---

### 👤 User Endpoints

#### ➕ Create User

- **POST** `/user`
- **Body:**  
  ```json
  {
    "name": "User Name",
    "email": "user@example.com",
    "password": "password123"
  }
  ```
- **Response:**  
  `201 Created`  
  ```json
  {
    "id": 1,
    "name": "User Name",
    "email": "user@example.com"
  }
  ```

#### 👥 Get All Users

- **GET** `/user`
- **Response:**  
  `200 OK`  
  ```json
  [
    {
      "id": 1,
      "name": "User Name",
      "email": "user@example.com"
    }
  ]
  ```

#### 🔍 Get User By ID

- **GET** `/user/{id}`
- **Response:**  
  `200 OK`  
  ```json
  {
    "id": 1,
    "name": "User Name",
    "email": "user@example.com"
  }
  ```

#### ✏️ Update User

- **PUT** `/user/{id}`
- **Body:**  
  ```json
  {
    "name": "Updated Name",
    "email": "updated@example.com",
    "password": "newpassword"
  }
  ```
- **Response:**  
  `200 OK`  
  ```json
  {
    "id": 1,
    "name": "Updated Name",
    "email": "updated@example.com"
  }
  ```

#### 🗑️ Delete User (Soft Delete)

- **DELETE** `/user/{id}`
- **Response:**  
  `200 OK`  
  `"User deleted Successfully"`

---

## 🧩 Project Structure

```
src/
  main/
    java/com/sdm/bms/
      controller/      # REST controllers
      service/         # Business logic
      repository/      # JPA repositories
      entity/          # JPA entities
      dto/             # Data transfer objects
      config/          # Configuration
    resources/
      application.properties
  test/
    java/com/sdm/bms/
      BmsApplicationTests.java
```

---

## 📝 License

This project is licensed under the MIT License.

---

## 👤 Author

Sandaru Gunathilake

---

## 🌐 CORS

CORS is enabled for `http://localhost:5173` (see [`config.WebConfig`](src/main/java/com/sdm/bms/config/WebConfig.java)).

---

## 🧪 Running Tests

```sh
./mvnw test
```

---

## 💡 Contributing

Pull requests are welcome!  
Feel free to open issues for suggestions or bugs.

---

## 📬 Contact

For questions, reach out via GitHub Issues.

---
