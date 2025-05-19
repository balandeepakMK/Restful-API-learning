# 🏦 Banking RESTful API with Spring Boot (JDBC + MVC)

This project is a simple banking system API built using **Java**, **Spring Boot**, **JDBC**, and the **MVC architecture pattern**. It uses an **H2 in-memory database** for simplicity and provides full CRUD operations for managing bank accounts.

---

## 📌 Features

- RESTful API with full CRUD operations
- MVC architecture (Controller → Service → Repository)
- JDBC (no JPA or Hibernate)
- In-memory H2 database
- Database auto-initialization with SQL schema
- H2 Console enabled for inspection

---

## 🧱 Technologies Used

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring JDBC
- H2 Database
- Maven

---

## 📁 Project Structure

```plaintext
src/
 └── main/
     ├── java/
     │   └── com.learning.api_learning/
     │       ├── controller/         # REST Controllers
     │       ├── service/            # Business logic
     │       ├── repository/         # JDBC access layer
     │       └── model/              # POJOs / DTOs
     └── resources/
         ├── application.properties  # Spring Boot config
         └── schema.sql              # Initializes database schema
🚀 Getting Started
Prerequisites
Java 17+

Maven

Run the application
bash
Copy
Edit
mvn spring-boot:run
🔌 API Endpoints
Method	Endpoint	Description
GET	/api/accounts	Get all accounts
GET	/api/accounts/{id}	Get account by ID
POST	/api/accounts	Create a new account
PUT	/api/accounts/{id}	Update account
DELETE	/api/accounts/{id}	Delete account

📬 Sample Request (POST /api/accounts)
http
Copy
Edit
POST /api/accounts
Content-Type: application/json

{
  "accountHolder": "Alice Smith",
  "balance": 5000.00
}
🛠 Configuration
application.properties
properties
Copy
Edit
spring.datasource.url=jdbc:h2:mem:bankdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.sql.init.mode=always
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
schema.sql
sql
Copy
Edit
CREATE TABLE accounts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    account_holder VARCHAR(100) NOT NULL,
    balance DOUBLE NOT NULL
);
🔍 Access H2 Database Console
Visit: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:bankdb

Username: sa

Password: (leave empty)

🧪 Testing with Postman
Start the app.

Open Postman.

Send requests to:

http://localhost:8080/api/accounts

Use different HTTP methods (GET, POST, PUT, DELETE) to test.

