# Personal Finance Tracker

## Project Description
The **Personal Finance Tracker** is a web-based application designed to help users manage their finances effectively. It allows users to track their income and expenses, manage categories for different types of transactions, and generate reports to gain insights into their financial status.

### Key Features:
- User authentication (signup, login) with JWT-based token management.
- Add, edit, and delete transactions.
- Categorize transactions into income or expenses.
- View detailed reports of transaction history.
- Manage transaction categories.
- Backend: **Spring Boot**, Database: **MySQL**.

## Postman Usage

### User

1. **POST - Save User**
    - Endpoint: `http://localhost:8080/api/v1/user`
    - Body:
      ```json
      {
          "userName": "janith",
          "userPassword": "1998",
          "email": "janith@gmail.com"
      }
      ```

2. **PUT - Update User**
    - Endpoint: `http://localhost:8080/api/v1/user`
    - Body:
      ```json
      {
          "userName": "janith",
          "userPassword": "1998",
          "email": "janith@gmail.com"
      }
      ```

3. **POST - Sign In**
    - Endpoint: `http://localhost:8080/api/v1/auth/signin`
    - Body:
      ```json
      {
          "userPassword": "117",
          "email": "upul@gmail.com"
      }
      ```

4. **POST - Sign Up**
    - Endpoint: `http://localhost:8080/api/v1/auth/signup`
    - Body:
      ```json
      {
          "userName": "janith",
          "userPassword": "1998",
          "email": "janith@gmail.com"
      }
      ```

### Category

1. **POST - Save Category**
    - Endpoint: `http://localhost:8080/api/v1/category`
    - Body:
      ```json
      {
          "id": 1,
          "user": {
              "id": 1
          },
          "name": "Personal Expenses",
          "type": "Expense",
          "transactions": null
      }
      ```

2. **PUT - Update Category**
    - Endpoint: `http://localhost:8080/api/v1/category`
    - Body:
      ```json
      {
          "id": 1,
          "user": {
              "id": 1
          },
          "name": "Personal Expenses",
          "type": "Expense",
          "transactions": null
      }
      ```

3. **GET - Get All Categories**
    - Endpoint: `http://localhost:8080/api/v1/category`
    - Response:
      ```json
      [
          {
              "id": 2,
              "userId": 1,
              "name": "Salary",
              "type": "Income",
              "transactions": []
          },
          {
              "id": 1,
              "userId": 1,
              "name": "Personal Expenses",
              "type": "Expense",
              "transactions": []
          }
      ]
      ```

### Transaction

1. **POST - Save Transaction**
    - Endpoint: `http://localhost:8080/api/v1/transaction`
    - Body:
      ```json
      {
          "id": "",
          "user": {
              "id": 1
          },
          "category": {
              "id": 1
          },
          "amount": 100.0,
          "date": "2020-05-03",
          "description": "aaaaa"
      }
      ```

2. **PUT - Update Transaction**
    - Endpoint: `http://localhost:8080/api/v1/transaction`
    - Body:
      ```json
      {
          "id": 1,
          "user": {
              "id": 1
          },
          "category": {
              "id": 1
          },
          "amount": 100.0,
          "date": "2020-05-03",
          "description": "Updated description"
      }
      ```

3. **GET - Get All Transactions by User ID**
    - Endpoint: `http://localhost:8080/api/v1/transaction/user/4`
    - Response:
      ```json
      [
          {
              "id": 25,
              "user": {
                  "id": 4,
                  "userName": "shehara",
                  "userPassword": "1234",
                  "email": "mavithaaaa@gmail.com",
                  "categories": [],
                  "transactions": []
              },
              "category": {
                  "id": 1,
                  "user": {
                      "id": 1,
                      "userName": "john_doe",
                      "userPassword": "password123",
                      "email": "john.doe@example.com",
                      "categories": [],
                      "transactions": []
                  },
                  "name": "Personal Expenses",
                  "type": "Expense",
                  "transactions": []
              },
              "amount": 100.5,
              "date": "2024-08-31T18:30:00.000+00:00",
              "description": "Weekly grocery shopping"
          }
      ]
      ```

4. **DELETE - Delete Transaction by ID**
    - Endpoint: `http://localhost:8080/api/v1/transaction/1`
