# 🎓 Student Management System

> Spring Boot REST API for managing student records — built with layered architecture, Spring Data JPA, and MySQL.

---

## 📁 Package Structure

```
com.example.studentmanagement/
├── StudentManagementSystem01Application.java
├── entity/
│   └── Student.java
├── repository/
│   └── StudentRepository.java
├── service/
│   ├── StudentService.java         ← interface
│   └── StudentServiceImpl.java     ← @Service implementation
└── controller/
    └── StudentController.java
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
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    private Integer id;
    private String name;
    private String course;
    private Double fee;
}
```

---

## 🔗 Repository

```java
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // save(), findAll(), findById(), deleteById() — inherited, no code needed
}
```

---

## ⚙️ Service Interface + Implementation

```java
// StudentService.java — contract
public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Integer id);
    Student updateStudent(Integer id, Student student);
    void deleteStudent(Integer id);
}

// StudentServiceImpl.java — business logic
@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {  // Constructor Injection
        this.repository = repository;
    }

    public Student updateStudent(Integer id, Student student) {
        Student dbStudent = repository.findById(id).orElse(null);
        if (dbStudent != null) {
            dbStudent.setName(student.getName());
            dbStudent.setCourse(student.getCourse());
            dbStudent.setFee(student.getFee());
            return repository.save(dbStudent);
        }
        return null;
    }
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint            | Description       |
| ------ | ------------------- | ----------------- |
| POST   | `/students/save`    | Save new student  |
| GET    | `/students/get-All` | Get all students  |
| GET    | `/students/{id}`    | Get student by ID |
| PUT    | `/students/{id}`    | Update student    |
| DELETE | `/students/{id}`    | Delete student    |

---

## 🔄 Request / Response

### POST `/students/save`

```json
{
  "id": 1,
  "name": "Ravi Sharma",
  "course": "Java Full Stack",
  "fee": 15000.0
}
```

### Response

```json
{
  "id": 1,
  "name": "Ravi Sharma",
  "course": "Java Full Stack",
  "fee": 15000.0
}
```

---

## ⚙️ application.properties

```properties
spring.application.name=StudentManagementSystem_01

spring.datasource.url=jdbc:mysql://localhost:3306/studentspringdb
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
CREATE DATABASE studentspringdb;

# 2. Clone & navigate
git clone https://github.com/jatinsoni08/SpringBoot-Suite.git
cd SpringBootCRUDProjects/StudentManagementSystem_01

# 3. Update credentials in application.properties

# 4. Run
mvn spring-boot:run
```

Base URL: `http://localhost:8080/students`

---

## 🧠 Key Concepts Applied

- `@Entity` + `@Table(name = "students")` — Java class maps to MySQL table
- `JpaRepository<Student, Integer>` — full CRUD, no SQL written
- `Service Interface` — controller depends on abstraction, not implementation
- `Constructor Injection` — cleaner than field-level `@Autowired`
- `findById().orElse(null)` — null-safe retrieval pattern
- Lombok `@Data` — auto-generates all getters, setters, equals, hashCode, toString

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)
