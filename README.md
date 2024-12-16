# Employee Expense Management System - Harshtech

## Overview
The Employee Management System is designed to manage employees and their expenses. 
It allows employees to submit expenses, and administrators can approve or reject these expenses. 
This system helps streamline expense management processes.

---

## Features:
- **Employee Management**: Manage employee data such as name and email.
- **Expense Management**: Employees can submit expenses, and administrators can approve or reject them.
- **Expense Status**: Each expense has a status of "PENDING", "APPROVED", or "REJECTED".
- **Expense Categorization**: Expenses are categorized, and each expense contains details such as amount, category, and submission date.

---

## Project Structure
```plaintext
com/
└── harshtech/
    └── employee/
        └── management/
            ├── model/                  # Contains entity models
            ├── repository/             # Repositories for database access
            ├── service/                # Business logic layer 
            ├── controller/             # REST API controllers
            └── Application.java        # Main application entry point
```

---

## Getting Started

### Technologies Used:
- **Java**: Programming language used for backend development.
- **Spring Boot**: Framework used for building REST APIs.
- **Maven**: Dependency management tool.
- **H2 Database**: In-memory database for development.
- **Mockito**: For unit testing.


### Setup Instructions

#### 1. Clone the Repository:
```bash
git clone https://github.com/kshitijharsh/employee-expense-management.git
```

#### 2. Build the Application:
```bash
cd EmployeeExpenseManagement
mvn clean install
```

#### 3. Run the Application:
```bash
mvn spring-boot:run
```

#### 4. Access the Application:
```bash
http://localhost:8080
```


## Author
Kshitij Harsh