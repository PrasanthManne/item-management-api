# Item Management REST API

A simple **Spring Boot RESTful API** for managing items (e-commerce style, similar to Flipkart).
This project demonstrates **RESTful API design**, **in-memory data storage**, and **input validation**, built using **Java 25**.

---

##  Tech Stack

* Java 25
* Spring Boot
* Spring Web (REST API)
* Jakarta Bean Validation
* Maven
* In-memory storage (ArrayList)

---

##  Project Structure

```
item-api/
 └── src/main/java/com/example/itemapi/
      ├── ItemApiApplication.java
      ├── controller/
      │     └── ItemController.java
      ├── model/
      │     └── Item.java
      └── service/
            └── ItemService.java
```

---

##  How to Run the Application

### 1️ Prerequisites

* Java 25 installed
* Maven installed

Check Java version:

```
java -version
```

Expected output:

```
java version "25"
```

---

### 2️ Run Using Maven

```
mvn spring-boot:run
```

---

### 3 Server URL

```
http://localhost:8080
```

---

##  API Endpoints

###  Add a New Item

Creates a new item and stores it in memory.

* Method: POST
* URL: `/api/items`
* Content-Type: `application/json`

Request Body:

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 65000
}
```

Response:

* Status: 201 CREATED

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 65000
}
```

---

###  Get Item by ID

Fetches an item using its ID.

* Method: GET
* URL: `/api/items/{id}`

Example:

```
GET /api/items/1
```

Response:

```json
{
  "id": 1,
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 65000
}
```

If item does not exist:

```
404 NOT FOUND
Item not found
```

---

##  Input Validation

Validation is handled using Jakarta Bean Validation.

| Field | Rule              |
| ----- | ----------------- |
| id    | Must not be null  |
| name  | Must not be blank |

Invalid input returns:

```
400 Bad Request
```

---

##  Implementation Details

* REST API built using `@RestController`
* Service layer contains business logic
* Data stored in memory using ArrayList
* No database used (easy to extend later)
* Clean layered architecture
* This project uses Spring Boot Global Exception Handling to handle errors in a clean and consistent way using @ControllerAdvice.

---

##  REST Design Notes

* POST is used for creating items
* GET is used only with numeric IDs
* URLs like `/api/items/add` are avoided to follow REST standards

---

## Summary

This project is a Spring Boot REST API built using Java 25.
It follows REST principles, uses in-memory storage, and demonstrates clean layered architecture.


### Author

Name: Prasanth Kumar Manne
Role: Java Backend Developer (Fresher)
Technology Stack: Java 25, Spring Boot, REST APIs