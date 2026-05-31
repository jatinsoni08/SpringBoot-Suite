# 📚 Book Management System

> Spring Boot REST API for managing a book catalog — layered architecture, Spring Data JPA, and MySQL persistence.

---

## 📁 Package Structure

```
com.example.bookmanagement/
├── BookManagementSystem04Application.java
├── entity/
│   └── Book.java
├── repository/
│   └── BookRepository.java
├── service/
│   ├── BookService.java         ← interface
│   └── BookServiceImpl.java     ← @Service implementation
└── controller/
    └── BookController.java
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
@Table(name = "book")
public class Book {

    @Id
    private Integer id;
    private String title;
    private String author;
    private Double price;
}
```

---

## 🔗 Repository

```java
public interface BookRepository extends JpaRepository<Book, Integer> {
    // save(), findAll(), findById(), deleteById() — zero code needed
}
```

---

## ⚙️ Service Interface + Implementation

```java
// BookService.java — contract
public interface BookService {
    Book saveBook(Book book);
    List<Book> getAllBook();
    Book getBookById(Integer id);
    Book updateBook(Integer id, Book book);
    void deleteBook(Integer id);
}

// BookServiceImpl.java — business logic
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    public Book updateBook(Integer id, Book book) {
        Book bookser = repository.findById(id).orElse(null);
        if (bookser != null) {
            bookser.setTitle(book.getTitle());
            bookser.setAuthor(book.getAuthor());
            bookser.setPrice(book.getPrice());
            return repository.save(bookser);
        }
        return null;
    }
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint                 | Description    |
| ------ | ------------------------ | -------------- |
| POST   | `/books/save`            | Save new book  |
| GET    | `/books/get-allbook`     | Get all books  |
| GET    | `/books/getoneBook/{id}` | Get book by ID |
| PUT    | `/books/update/{id}`     | Update book    |
| DELETE | `/books/delete/{id}`     | Delete book    |

---

## 🔄 Request / Response

### POST `/books/save`

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 599.0
}
```

### Response

```json
{
  "id": 1,
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "price": 599.0
}
```

---

## ⚙️ application.properties

```properties
spring.application.name=BookManagementSystem_04

spring.datasource.url=jdbc:mysql://localhost:3306/bookmanagement_springdb
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.format_sql=true
```

---

## ▶️ How to Run

```bash
# 1. Create MySQL database
CREATE DATABASE bookmanagement_springdb;

# 2. Clone & navigate
git clone https://github.com/[your-username]/SpringBoot-CRUD-Suite.git
cd SpringBootCRUDProjects/BookManagementSystem_04

# 3. Update credentials in application.properties

# 4. Run
mvn spring-boot:run
```

Base URL: `http://localhost:8080/books`

---

## 🧠 Key Concepts Applied

- `@Entity` + `@Table(name = "book")` — maps to `book` table in `bookmanagement_springdb`
- `JpaRepository<Book, Integer>` — complete CRUD without writing SQL
- `BookService` interface + `BookServiceImpl` — separation of contract and logic
- `@Autowired` + constructor injection combo — both injection styles present
- `findById(id).orElse(null)` — safe null check before any field update
- Lombok `@Data` — replaces ~50 lines of boilerplate

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)
