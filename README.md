Bank Management System
A simple Bank Management System built with Spring Boot to manage customer accounts, transactions, and bank-related operations. This RESTful API provides functionality for creating and managing bank accounts, handling deposits and withdrawals, viewing account balances, and tracking transaction histories.

Table of Contents
Features
Technologies Used
Setup and Installation
API Endpoints
License
Customer Management: Create, read, update, and delete customer profiles.
Account Management: Open new accounts, close existing accounts, view account details.
Transactions: Deposit, withdraw, and transfer funds between accounts.
Transaction History: Track and retrieve the transaction history for each account.
Account Balance Inquiry: Check the balance of any account at any time.
Error Handling and Validation: Validation for transactions and detailed error responses.
Technologies Used
Spring Boot - Java-based framework for creating RESTful APIs.
Spring Data JPA - For database operations and ORM.
H2 Database - In-memory database for testing and development.
Lombok - To reduce boilerplate code with annotations.
Swagger - API documentation and testing.
Maven - Dependency management and build tool.
Setup and Installation
Clone the Repository:

bash
Copy code
git clone https://github.com/yourusername/bank-management-system.git
cd bank-management-system
Build the Project: Ensure you have Maven and Java (version 11 or later) installed, then run:

bash
Copy code
mvn clean install
Run the Application: Start the application using the following command:

bash
Copy code
mvn spring-boot:run
Access the Application:

The API will be running at: http://localhost:8080
Swagger API documentation can be accessed at: http://localhost:8080/swagger-ui/
API Endpoints
Below are the main endpoints provided by this API. For more detailed documentation, refer to the Swagger UI.

Customer Management
Create Customer: POST /api/customers
Get Customer by ID: GET /api/customers/{id}
Update Customer: PUT /api/customers/{id}
Delete Customer: DELETE /api/customers/{id}
Account Management
Create Account: POST /api/accounts
Get Account by ID: GET /api/accounts/{id}
Get All Accounts: GET /api/accounts
Close Account: DELETE /api/accounts/{id}
Transactions
Deposit Funds: POST /api/accounts/{id}/deposit
Withdraw Funds: POST /api/accounts/{id}/withdraw
Transfer Funds: POST /api/accounts/{fromId}/transfer/{toId}
Transaction History
Get Transaction History: GET /api/accounts/{id}/transactions
License
This project is licensed under the MIT License - see the LICENSE file for details.
