# 🏢 CustomerManagementSystem

A full-stack Spring Boot application for managing customers — built with REST APIs, Spring Security (OAuth2 + Form Login), Role-Based Access Control, Thymeleaf frontend, Email notifications, and Global Exception Handling.

---

## 🚀 Features

| Feature               | Description                                          |
| --------------------- | ---------------------------------------------------- |
| ✅ CRUD Operations    | Create, Read, Update, Delete customers               |
| 🔐 OAuth2 Login       | Google login via Spring Security OAuth2              |
| 👤 Form Login         | Username/password login (ADMIN & USER roles)         |
| 🛡️ Role Based Access  | ADMIN → full access, USER → read only                |
| 📧 Email Notification | Auto email sent on customer registration             |
| ⚠️ Exception Handling | Global exception handler with proper error responses |
| 🚫 Duplicate Email    | Email uniqueness enforced at DB + service layer      |
| 🖥️ Thymeleaf Frontend | Clean sidebar dashboard UI                           |
| 🗄️ MySQL Database     | Persistent storage with Spring Data JPA              |

---

## 🛠️ Tech Stack

- **Backend** — Java 17, Spring Boot, Spring Security, Spring Data JPA
- **Frontend** — Thymeleaf, HTML, CSS, Font Awesome
- **Database** — MySQL
- **Email** — JavaMailSender (Gmail SMTP)
- **Security** — OAuth2 (Google), Form Login, InMemoryUserDetailsManager
- **Build Tool** — Maven

---

## 📁 Project Structure

```
CustomerManagementSystem/
├── config/
│   └── SecurityConfig.java
├── controller/
│   ├── CustomerController.java     ← REST API
│   └── WebController.java          ← Thymeleaf views
├── entity/
│   └── Customer.java
├── exception/
│   ├── CustomerNotFoundException.java
│   └── GlobalExceptionHandler.java
├── repository/
│   └── CustomerRepository.java
├── service/
│   ├── CustomerService.java
│   ├── CustomerServiceImpl.java
│   └── EmailService.java
└── resources/
    ├── templates/
    │   ├── login.html
    │   ├── customers.html
    │   ├── add-customer.html
    │   └── edit-customer.html
    └── application.properties
```

---

## 🔐 Security Configuration

### Login Options

| Method     | Credentials        | Role   |
| ---------- | ------------------ | ------ |
| Form Login | `jatin / 12345`    | ADMIN  |
| Form Login | `guest / guest123` | USER   |
| OAuth2     | Google Account     | GOOGLE |

### Role Permissions

| Endpoint           | ADMIN | USER | GOOGLE |
| ------------------ | ----- | ---- | ------ |
| View all customers | ✅    | ✅   | ✅     |
| Add customer       | ✅    | ❌   | ❌     |
| Edit customer      | ✅    | ❌   | ❌     |
| Delete customer    | ✅    | ❌   | ❌     |

---

## 🌐 API Endpoints (REST)

| Method   | Endpoint                      | Description        |
| -------- | ----------------------------- | ------------------ |
| `GET`    | `/customers/getAllCustomer`   | Get all customers  |
| `GET`    | `/customers/getCustomer/{id}` | Get customer by ID |
| `POST`   | `/customers/save`             | Save new customer  |
| `PUT`    | `/customers/update/{id}`      | Update customer    |
| `DELETE` | `/customers/delete/{id}`      | Delete customer    |

---

## 🖥️ Web Endpoints (Thymeleaf)

| Method | Endpoint                     | Description               |
| ------ | ---------------------------- | ------------------------- |
| `GET`  | `/web/customers`             | Dashboard — all customers |
| `GET`  | `/web/customers/add`         | Add customer form         |
| `POST` | `/web/customers/save`        | Save customer             |
| `GET`  | `/web/customers/edit/{id}`   | Edit customer form        |
| `POST` | `/web/customers/update/{id}` | Update customer           |
| `GET`  | `/web/customers/delete/{id}` | Delete customer           |

---

## ⚙️ Configuration

### `application.properties`

```properties
spring.application.name=CustomerManagementSystem

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/customer_springdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# Server
server.port=8989

# Email
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=YOUR_EMAIL
spring.mail.password=YOUR_APP_PASSWORD
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# OAuth2 Google
spring.security.oauth2.client.registration.google.client-id=YOUR_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_CLIENT_SECRET
spring.security.oauth2.client.registration.google.scope=email,profile
```

---

## 🗄️ Database

- **Database Name** — `customer_springdb`
- **Table Name** — `customer_table`
- **Entity Fields** — `id`, `name`, `city`, `mobile`, `email` (unique)

---

## 📧 Email Feature

On every new customer registration, an automatic email is sent:

- **Subject** — `Customer Registration Successful`
- **Body** — `Hello {name}, your registration has been completed successfully.`

---

## ⚠️ Exception Handling

| Scenario                 | Response                                     |
| ------------------------ | -------------------------------------------- |
| Customer not found       | `{"error": "Customer not found with id: X"}` |
| Duplicate email (save)   | `{"error": "Email already registered: X"}`   |
| Duplicate email (update) | `{"error": "Email already registered: X"}`   |

---

## 🚀 How to Run

1. Clone the repository
2. Create MySQL database: `customer_springdb`
3. Add your credentials in `application.properties`
4. Add Google OAuth2 Client ID & Secret
5. Run the application:

```bash
mvn spring-boot:run
```

6. Open browser: `http://localhost:8989`

---

## 📌 Notes

- Replace all `YOUR_*` placeholders in `application.properties` before running
- OAuth2 redirect URI must be registered in Google Cloud Console:
  `http://localhost:8989/login/oauth2/code/google`
- Gmail App Password required for email (not regular password)
