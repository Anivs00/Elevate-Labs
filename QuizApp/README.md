# 🎯 Java API-Based Quiz App

## 📌 Project Overview
This is a **Java Console-Based Quiz Application** that dynamically fetches quiz questions from the **Open Trivia Database API** every time you run the app.  
The quiz presents random multiple-choice questions, accepts user answers, and displays the final score at the end.

---

## 🔗 API Used
**Open Trivia Database (OTDB)**  
[https://opentdb.com/api_config.php](https://opentdb.com/api_config.php)

- Provides new quiz questions on every run.
- Supports multiple categories and difficulty levels.

---

## ⚙️ Technologies Used
- Java 11 or above
- Java `HttpClient` (for API requests)
- `org.json` library (for JSON parsing)

---

## 🛠 Project Structure
```text
QuizApp/
├── QuizApp.java
├── json-20210307.jar  # JSON Parsing Library
└── README.md


🚀 How to Run the Project on Windows PowerShell
📂 Step 1: Open PowerShell and navigate to the project folder:

🛠 Step 2: Compile the Java file with the JSON library:
javac -cp ".;json-20210307.jar" QuizApp.java

▶️ Step 3: Run the compiled Java program:
java -cp ".;json-20210307.jar" QuizApp
