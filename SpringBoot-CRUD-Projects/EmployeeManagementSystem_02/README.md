# 👔 Employee Management System

> Spring Boot REST API for managing employee data — layered architecture, Spring Data JPA, and MySQL persistence.

---

## 📁 Package Structure

```
com.example.employeemanagement/
├── EmployeeManagementSystem02Application.java
├── entity/
│   └── Employee.java
├── repository/
│   └── EmployeeRepository.java
├── service/
│   ├── EmployeeService.java         ← interface
│   └── EmployeeServiceImpl.java     ← @Service implementation
└── controller/
    └── EmployeeController.java
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
@Table(name = "employee")
public class Employee {

    @Id
    private Integer empId;
    private String empName;
    private Double empsalary;
    private String empcity;
}
```

---

## 🔗 Repository

```java
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // save(), findAll(), findById(), deleteById() — zero SQL needed
}
```

---

## ⚙️ Service Interface + Implementation

```java
// EmployeeService.java — contract
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Integer id, Employee employee);
    void deleteEmployee(Integer id);
}

// EmployeeServiceImpl.java — business logic
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {  // Constructor Injection
        this.repository = repository;
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee emStudent = repository.findById(id).orElse(null);
        if (emStudent != null) {
            emStudent.setEmpName(employee.getEmpName());
            emStudent.setEmpcity(employee.getEmpcity());
            emStudent.setEmpsalary(employee.getEmpsalary());
            return repository.save(emStudent);
        }
        return null;
    }
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint                    | Description        |
| ------ | --------------------------- | ------------------ |
| POST   | `/employee/save-emp`        | Save new employee  |
| GET    | `/employee/get-all`         | Get all employees  |
| GET    | `/employee/{id}`            | Get employee by ID |
| PUT    | `/employee/update-emp/{id}` | Update employee    |
| DELETE | `/employee/del-emp/{id}`    | Delete employee    |

---

## 🔄 Request / Response

### POST `/employee/save-emp`

```json
{
  "empId": 1,
  "empName": "Priya Mehta",
  "empsalary": 55000.0,
  "empcity": "Jaipur"
}
```

### Response

```json
{
  "empId": 1,
  "empName": "Priya Mehta",
  "empsalary": 55000.0,
  "empcity": "Jaipur"
}
```

---

## ⚙️ application.properties

```properties
spring.application.name=EmployeeManagementSystem_02

spring.datasource.url=jdbc:mysql://localhost:3306/employeespringdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## ▶️ How to Run

```bash
# 1. Create MySQL database
CREATE DATABASE employeespringdb;

# 2. Clone & navigate
git clone https://github.com/jatinsoni08/SpringBoot-Suite.git
cd SpringBootCRUDProjects/EmployeeManagementSystem_02

# 3. Update credentials in application.properties

# 4. Run
mvn spring-boot:run
```

Base URL: `http://localhost:8080/employee`

---

## 🧠 Key Concepts Applied

- `@Entity` + `@Table(name = "employee")` — custom table name via annotation
- `JpaRepository<Employee, Integer>` — typed repo, CRUD out of the box
- `Service Interface` pattern — `EmployeeService` consumed by controller, `EmployeeServiceImpl` does the work
- `Constructor Injection` — `EmployeeServiceImpl(EmployeeRepository repository)`
- `findById().orElse(null)` — safe null handling before update
- Lombok `@Data` — zero boilerplate entity

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)
