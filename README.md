This is a Banking System REST API built with Spring Boot and JPA (Hibernate).
It allows users to create accounts, deposit and withdraw money, view transaction history, and for admins to manage users and calculate interest.
The project demonstrates a strong understanding of backend architecture and data persistence using modern Spring Boot practices.


---

 Tech Stack

Language: Java

Framework: Spring Boot

Database: MySQL (via Spring Data JPA)

Build Tool: Maven

API Testing: Postman



---

Features

 User Features

Create a new user and open accounts

Deposit into checking or savings accounts

Withdraw from checking or savings accounts

View deposit and withdrawal history

View total balance


 Admin Features

View all users and accounts

Calculate and add interest to savings accounts

View all deposits and withdrawals in the system



---

 Project Structure

src/

 ├── controllers/
 
 │ ├── AdminController.java
 
 │ └── UserController.java
 
 │
 
 ├── services/
 
 │ ├── AdminService.java
 
 │ └── UserService.java
 
 │
 
 ├── repositories/
 
 │ ├── CheckingAccountRepository.java
 
 │ ├── SavingsAccountRepository.java
 
 │ ├── UserRepository.java
 
 │ ├── DepositHistoryRepository.java
 
 │ └── WithdrawalHistoryRepository.java
 
 │
 
 └── models/
 
      ├── User.java
      ├── CheckingAccount.java
      ├── SavingsAccount.java
      ├── DepositHistory.java
      ├── WithdrawalHistory.java
      └── UserDTO.java


---

 Core Concepts Demonstrated

MVC Architecture (Controllers → Services → Repositories → Models)

Dependency Injection using @Service and @Autowired (or constructor injection)

Entity Relationships (@OneToMany, @ManyToOne)

JSON Serialization with @JsonIgnore to prevent recursion

RESTful API design with clear endpoint structure

Business Logic Layer for interest, deposits, withdrawals, and balances



---
Admin Endpoints

| Method | URL | Request Body | Description |
|--------|-----|--------------|-------------|
| GET | /admin/users | None | Get all users |
| GET | /admin/users/{userId} | None | Get a user by ID |
| DELETE | /admin/users/{userId} | None | Delete a user and their accounts |
| GET | /admin/checking-account | None | Get all checking accounts |
| GET | /admin/checking-account/{bankId} | None | Get a checking account by ID |
| GET | /admin/saving-account/ | None | Get all savings accounts |
| GET | /admin/saving-account/{bankId} | None | Get a savings account by ID |
| GET | /admin/deposit | None | Get all deposit history |
| GET | /admin/withdraws | None | Get all withdrawal history |
| POST | /admin/interest/{bankId} | None | Calculate and add interest to a savings account |


---

2. User Endpoints

| Method | URL | Request Body | Description |
|--------|-----|--------------|-------------|
| POST | /user/user | { "name": "John Doe", "contactInfo": "email or phone" } | Create a new user |
| DELETE | /user/user/{userId} | None | Delete a user and their accounts |
| POST | /user/savings-account/{userID} | { "accountNumber": "12345", "balance": 1000.0 } | Create a new savings account for a user |
| GET | /user/savings-account/{userId}} | None | Get all savings accounts for a user |
| DELETE | /user/savings-account/{bankId}} | None | Delete a savings account by ID |
| POST | /user/checking-account/{userID}} | { "accountNumber": "54321", "balance": 500.0 } | Create a new checking account for a user |
| GET | /user/checking-account/{userId}} | None | Get all checking accounts for a user |
| DELETE | /user/checking-account/{bankId}} | None | Delete a checking account by ID |
| POST | /user/checking-account/deposit/{bankId}} | { "amount": 200.0 } | Deposit into a checking account |
| GET | /user/checking-account/deposit/{bankId}} | None | Get deposit history for a checking account |
| POST | /user/checking-account/withdrawal/{bankId}} | { "amount": 150.0 } | Withdraw from a checking account |
| GET | /user/checking-account/withdrawal/{bankId}} | None | Get withdrawal history for a checking account |
| POST | /user/savings-account/deposit/{bankId}} | { "amount": 300.0 } | Deposit into a savings account |
| GET | /user/savings-account/deposit/{bankId}} | None | Get deposit history for a savings account |
| POST | /user/savings-account/withdrawal/{bankId} | { "amount": 100.0 } | Withdraw from a savings account |
| GET | /user/savings-account/withdrawal/{bankId}| None | Get withdrawal history for a savings account |

 

---

 How to Run

1. Clone the repository:

git clone https://github.com/ejohchisimdi-collab/Bank-Management-API


2. Open the project in your IDE (IntelliJ / Eclipse / VS Code).


3. Configure application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/banking_system
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update


4. Run the project with:

mvn spring-boot:run


5. Test endpoints using Postman at http://localhost:8080.




---
