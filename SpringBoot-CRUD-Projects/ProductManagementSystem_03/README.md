# 📦 Product Management System

> Spring Boot REST API for product inventory management — built with layered architecture, Spring Data JPA, and MySQL.

---

## 📁 Package Structure

```
com.example.productmanagement/
├── ProductManagementSystem03Application.java
├── entity/
│   └── Product.java
├── repository/
│   └── ProductRepository.java
├── service/
│   ├── ProductService.java         ← interface
│   └── ProductServiceImpl.java     ← @Service implementation
└── controller/
    └── ProductController.java
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
@Table(name = "products")
public class Product {

    @Id
    private Integer pid;
    private String pname;
    private Double pprice;
    private Integer pquantity;
}
```

---

## 🔗 Repository

```java
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // save(), findAll(), findById(), deleteById() — inherited automatically
}
```

---

## ⚙️ Service Interface + Implementation

```java
// ProductService.java — contract
public interface ProductService {
    Product saveAllProducts(Product product);
    List<Product> getAllProducts();
    Product getProductById(Integer pid);
    Product updateProduct(Integer pid, Product product);
    void deleteProducts(Integer pid);
}

// ProductServiceImpl.java — business logic
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    public Product updateProduct(Integer pid, Product product) {
        Product dbproduct = repository.findById(pid).orElse(null);
        if (dbproduct != null) {
            dbproduct.setPname(product.getPname());
            dbproduct.setPprice(product.getPprice());
            dbproduct.setPquantity(product.getPquantity());
            return repository.save(dbproduct);
        }
        return null;
    }
}
```

---

## 📡 REST API Endpoints

| Method | Endpoint                  | Description        |
| ------ | ------------------------- | ------------------ |
| POST   | `/products/save`          | Save new product   |
| GET    | `/products/get-all`       | Get all products   |
| GET    | `/products/getbyId/{pid}` | Get product by pid |
| PUT    | `/products/update/{pid}`  | Update product     |
| DELETE | `/products/delete/{pid}`  | Delete product     |

---

## 🔄 Request / Response

### POST `/products/save`

```json
{
  "pid": 1,
  "pname": "Wireless Mouse",
  "pprice": 999.0,
  "pquantity": 50
}
```

### Response

```json
{
  "pid": 1,
  "pname": "Wireless Mouse",
  "pprice": 999.0,
  "pquantity": 50
}
```

---

## ⚙️ application.properties

```properties
spring.application.name=ProductManagementSystem_03

spring.datasource.url=jdbc:mysql://localhost:3306/productspringdb
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
CREATE DATABASE productspringdb;

# 2. Clone & navigate
git clone https://github.com/[your-username]/SpringBoot-CRUD-Suite.git
cd SpringBootCRUDProjects/ProductManagementSystem_03

# 3. Update credentials in application.properties

# 4. Run
mvn spring-boot:run
```

Base URL: `http://localhost:8080/products`

---

## 🧠 Key Concepts Applied

- `@Entity` + `@Table(name = "products")` — JPA maps class to MySQL `products` table
- Custom primary key field `pid` — `@Id` without `@GeneratedValue` (manual ID)
- `JpaRepository<Product, Integer>` — typed repo, generic CRUD available immediately
- `Service Interface` — `ProductService` (contract) + `ProductServiceImpl` (logic)
- `findById(pid).orElse(null)` — null-safe product fetch before update
- Lombok `@Data`, `@AllArgsConstructor`, `@NoArgsConstructor` — clean entity

---

## 👨‍💻 Author

**Jatin Soni** — Java Full Stack Development Student  
[LinkedIn](https://www.linkedin.com/in/jatinsoni08) · [GitHub](https://github.com/jatinsoni08)
