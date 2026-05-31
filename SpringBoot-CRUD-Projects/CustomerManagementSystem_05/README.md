# 🤝 Customer Management System

> Spring Boot REST API for managing customer data — the final project in the SpringBoot-CRUD-Suite, running on port 8989 with its own dedicated MySQL database.

---

## 📁 Package Structure

```
com.example.customermanagement/
├── CustomerManagementSystem05Application.java
├── entity/
│   └── Customer.java
├── repository/
│   └── CustomerRepository.java
├── service/
│   ├── CustomerService.java         ← interface
│   └── CustomerServiceImpl.java     ← @Service implementation
└── controller/
    └── CustomerController.java
```

---

## 🛠️ Tech Stack

| Technology                   | Role                       |
| ---------------------------- | -------------------------- |
| Java                         | Core language              |
| Spring Boot                  | Application framework      |
| spring-boot-starter-data-jpa | ORM / JPA abstraction      |
| spring-boot-starter-webmvc   | REST layer                 |
| MySQL                        | Relational database        |
| Lombok                       | Boilerplate elimination    |
| spring-boot-devtools         | Live reload in development |
| Maven                        | Build management           |

---

## 🗃️ Entity

```java
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_table")
public class Customer {

    @Id
    private Integer id;
    private String name;
    private String city;
    private String mobile;
}
```

---

## 🔗 Repository

```java
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    // save(), findAll(), findById(), deleteById() — inherited automatically
}
```

---

## ⚙️ Service Interface + Implementation

```java
// CustomerService.java — contract
public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomer();
    Customer getCustomerById(Integer id);
    Customer updateCustomer(Integer id, Customer customer);
    void deleteCustomer(Integer id);
}

// CustomerServiceImpl.java — business logic
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer updateCustomer(Integer id, Customer customer) {
        Customer cs = repository.findById(id).orElse(null);
        if (cs != null) {
            cs.setName(customer.getName());
            cs.setCity(customer.getCity());
            cs.setMobile(customer.getMobile());
            return repository.save(cs);
        }
        return null;
    }
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint                      | Description        |
| ------ | ----------------------------- | ------------------ |
| POST   | `/customers/save`             | Save new customer  |
| GET    | `/customers/getAllCustomer`   | Get all customers  |
| GET    | `/customers/getCustomer/{id}` | Get customer by ID |
| PUT    | `/customers/update/{id}`      | Update customer    |
| DELETE | `/customers/delete/{id}`      | Delete customer    |

---

## 🔄 Request / Response

### POST `/customers/save`

```json
{
  "id": 1,
  "name": "Arjun Verma",
  "city": "Jaipur",
  "mobile": "9876543210"
}
```

### Response

```json
{
  "id": 1,
  "name": "Arjun Verma",
  "city": "Jaipur",
  "mobile": "9876543210"
}
```

---

## ⚙️ application.properties

```properties
spring.application.name=CustomerManagementSystem_05

spring.datasource.url=jdbc:mysql://localhost:3306/Customer_springdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties..format_sql=true

server.port=8989
```

> **Note:** This project runs on **port 8989** — not the default 8080.

---

## ▶️ How to Run

```bash
# 1. Create MySQL database
CREATE DATABASE Customer_springdb;

# 2. Clone & navigate
git clone https://github.com/jatinsoni08/SpringBoot-Suite.git
cd SpringBootCRUDProjects/CustomerManagementSystem_05

# 3. Update credentials in application.properties

# 4. Run
mvn spring-boot:run
```

Base URL: `http://localhost:8989/customers`

---

## 🧠 Key Concepts Applied

- `@Entity` + `@Table(name = "customer_table")` — custom table name in MySQL
- `JpaRepository<Customer, Integer>` — full CRUD, zero SQL written
- `CustomerService` interface + `CustomerServiceImpl` — clean separation of concerns
- `server.port=8989` — project runs on dedicated port
- `findById(id).orElse(null)` — null-safe retrieval before update
- Lombok `@Data` — eliminates all accessor boilerplate

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)
