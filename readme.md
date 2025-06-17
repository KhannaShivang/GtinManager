```markdown
# GTIN Manager Assignment

This is a simple Spring Boot project to manage Products, GTINs, and Batches.  
It provides basic APIs to add data and get results based on available quantity and date.

---

## Database Setup

1. Create a database in MySQL:

```sql
CREATE DATABASE gtindb;
```

2. Add this in your `application.yml` file inside `src/main/resources`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/gtindb
    username: your_mysql_username
    password: your_mysql_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

Replace the username and password with your MySQL login details.

---

## How to Run

You can run the app using your IDE or terminal:

```bash
./mvnw spring-boot:run
```

After running, the server will start at:

```
http://localhost:8080/
```

---

## API List

## 📮 API Endpoints

| Method | Endpoint               | Description                                                |
| ------ | ---------------------- | ---------------------------------------------------------- |
| POST   | `/products`          | Create a new product                                       |
| GET    | `/products/{gtin}`   | Get a product by GTIN (fetches product using GTIN code)    |
| POST   | `/gtins`             | Create a GTIN linked to a product                          |
| GET    | `/gtins/gtinBatches` | Get GTINs with valid batches:                              |
|        |                        | - All batches with positive quantity                       |
|        |                        | - Latest batch with 0 or negative quantity (based on date) |
| POST   | `/batches`           | Create a batch linked to a GTIN                            |
| GET    | `/batches/{gtin}`    | Get all batches for a given GTIN string                    |

---

## Notes

- Make sure MySQL is running
- Use Postman to test APIs
