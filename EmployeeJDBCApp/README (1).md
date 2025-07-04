
# 📒 Java JDBC Employee Database App

## 📌 Project Overview
This is a **Java console-based CRUD application** that connects to a **MySQL database using JDBC.**  
The application allows you to **Add, View, Update, and Delete Employee records**.

## 🔧 Technologies Used
- Java
- MySQL (XAMPP)
- JDBC
- VS Code (or any Java IDE)

## 🚀 Features
✅ Add Employee  
✅ View All Employees  
✅ Update Employee  
✅ Delete Employee  

## 🛠 Setup Instructions

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/Employee-JDBC-App.git
```

### 2. Database Setup
- Start **XAMPP** and run **MySQL server.**
- Open **phpMyAdmin** or MySQL CLI.
- Run the following SQL commands:
```sql
CREATE DATABASE EmployeeDB;

USE EmployeeDB;

CREATE TABLE Employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    designation VARCHAR(100),
    salary DOUBLE
);
```

### 3. Project Structure
```
EmployeeJDBCApp/
│
├── DBConnection.java       # Database connection file
├── EmployeeApp.java        # Main app with CRUD operations
├── Employee.java           # Employee model class
├── lib/
│   └── mysql-connector-j-9.2.0.jar  # JDBC driver
└── README.md
```

### 4. Add MySQL Connector
- Place the MySQL Connector JAR inside the `lib` folder.

### 5. Update DB Credentials
In `DBConnection.java`, update your MySQL username and password:
```java
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/EmployeeDB", "root", "");
```
*(Leave the password empty if using XAMPP default settings.)*

---

## 💻 How to Compile and Run
```bash
javac -cp ".;lib/mysql-connector-j-9.2.0/mysql-connector-j-9.2.0.jar" EmployeeApp.java DBConnection.java Employee.java
java -cp ".;lib/mysql-connector-j-9.2.0/mysql-connector-j-9.2.0.jar" EmployeeApp
```
*(Use `:` instead of `;` if you are on Mac/Linux)*

---




