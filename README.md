# 🚀 SPRINGBOOT-SUITE

> A collection of production-structured Spring Boot applications — built from scratch with layered architecture, Spring Data JPA, MySQL, Spring Security, and Thymeleaf.

---

## 📁 Repository Structure

```
SPRINGBOOT-SUITE/
├── SpringBoot-CRUD-Projects/
│   ├── StudentManagementSystem_01/    → DB: studentspringdb          | Port: 8080
│   ├── EmployeeManagementSystem_02/   → DB: employeespringdb         | Port: 8080
│   ├── ProductManagementSystem_03/    → DB: productspringdb          | Port: 8080
│   ├── BookManagementSystem_04/       → DB: bookmanagement_springdb  | Port: 8080
│   └── CustomerManagementSystem_05/   → DB: Customer_springdb        | Port: 8989
│
└── SpringBoot-FullStack-Projects/
    └── CustomerManagementSystem/      → DB: customer_springdb        | Port: 8989
```

---

## 🛠️ Common Tech Stack (CRUD Projects)

| Technology                   | Role                          |
| ---------------------------- | ----------------------------- |
| Java                         | Core language                 |
| Spring Boot                  | Application framework         |
| spring-boot-starter-data-jpa | ORM / JPA abstraction         |
| spring-boot-starter-webmvc   | REST API layer                |
| MySQL                        | Relational database           |
| Lombok                       | Boilerplate elimination       |
| spring-boot-devtools         | Live reload in development    |
| Maven                        | Build & dependency management |

---

## 🏗️ Layered Architecture (Applied in All Projects)

```
HTTP Request
      │
      ▼
┌──────────────────┐
│    Controller    │  ← @RestController — maps HTTP to service calls
│  @RequestMapping │    @RequestBody, @PathVariable
└────────┬─────────┘
         │  Constructor Injection
         ▼
┌──────────────────┐
│ Service Interface│  ← Contract: defines what business logic exists
│  + ServiceImpl   │    @Service on implementation class
└────────┬─────────┘
         │  Constructor Injection
         ▼
┌──────────────────┐
│   Repository     │  ← extends JpaRepository<Entity, ID>
│  JpaRepository   │    save(), findAll(), findById(), deleteById()
└────────┬─────────┘
         │
         ▼
┌──────────────────┐
│     Entity       │  ← @Entity + @Table + Lombok @Data
│   MySQL Table    │    Hibernate auto-creates table via ddl-auto=update
└──────────────────┘
```

---

## 📦 CRUD Projects At a Glance

| #   | Project                                                                            | MySQL Table      | Key Fields                         | Port     |
| --- | ---------------------------------------------------------------------------------- | ---------------- | ---------------------------------- | -------- |
| 01  | [StudentManagementSystem](./SpringBoot-CRUD-Projects/StudentManagementSystem_01)   | `students`       | id, name, course, fee              | 8080     |
| 02  | [EmployeeManagementSystem](./SpringBoot-CRUD-Projects/EmployeeManagementSystem_02) | `employee`       | empId, empName, empsalary, empcity | 8080     |
| 03  | [ProductManagementSystem](./SpringBoot-CRUD-Projects/ProductManagementSystem_03)   | `products`       | pid, pname, pprice, pquantity      | 8080     |
| 04  | [BookManagementSystem](./SpringBoot-CRUD-Projects/BookManagementSystem_04)         | `book`           | id, title, author, price           | 8080     |
| 05  | [CustomerManagementSystem](./SpringBoot-CRUD-Projects/CustomerManagementSystem_05) | `customer_table` | id, name, city, mobile, email      | **8989** |

---

## 🌟 FullStack Projects At a Glance

| #   | Project                                                                              | Key Features                                                       | Port     |
| --- | ------------------------------------------------------------------------------------ | ------------------------------------------------------------------ | -------- |
| 01  | [CustomerManagementSystem](./SpringBoot-FullStack-Projects/CustomerManagementSystem) | OAuth2, Role Based Access, Thymeleaf UI, Email, Exception Handling | **8989** |

---

## 📡 REST API Pattern (CRUD Projects)

```
POST   /{resource}/save           → Create new record
GET    /{resource}/get-all        → Retrieve all records
GET    /{resource}/{id}           → Retrieve by ID
PUT    /{resource}/update/{id}    → Update existing record
DELETE /{resource}/delete/{id}    → Delete record
```

---

## ⚙️ Common application.properties Pattern

```properties
spring.application.name=<ProjectName>

spring.datasource.url=jdbc:mysql://localhost:3306/<db_name>
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ How to Run Any Project

```bash
# 1. Clone the repository
git clone https://github.com/jatinsoni08/SpringBoot-Suite.git

# 2. Navigate into a project
cd SpringBoot-CRUD-Projects/StudentManagementSystem_01

# 3. Create the MySQL database
mysql -u root -p
CREATE DATABASE studentspringdb;

# 4. Update credentials in src/main/resources/application.properties

# 5. Run
mvn spring-boot:run
```

---

## 🧠 Key Learnings Across All Projects

- **Service Interface Pattern** — Controller injects the interface, not the impl class. Clean abstraction.
- **Constructor Injection** — Used throughout instead of field-level `@Autowired`
- **JpaRepository** — Zero SQL written. `save()`, `findAll()`, `findById()`, `deleteById()` all inherited
- **findById().orElseThrow()** — Proper exception handling instead of null returns
- **ddl-auto=update** — Hibernate auto-creates and syncs tables on every startup
- **show-sql=true** — Every query printed to console, great for understanding JPA behavior
- **Lombok @Data** — `@AllArgsConstructor` + `@NoArgsConstructor` keeps all entities clean
- **OAuth2 + Form Login** — Dual authentication strategy with role-based access control
- **Global Exception Handling** — `@RestControllerAdvice` for clean error responses
- **Thymeleaf + Spring Security** — Server-side rendering with `sec:authorize` for role-based UI

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)

---

> _"Building the same architecture 5 times wasn't repetition — it was mastery."_
