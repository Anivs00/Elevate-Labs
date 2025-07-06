# 🎯 Java API-Based Quiz App

## 📌 Project Overview
This is a **Java Console-Based Quiz Application** that dynamically fetches quiz questions from the **Open Trivia Database API** each time you run the app.  
The quiz presents random multiple-choice questions, accepts user answers, and displays the final score at the end.

---

## 🔗 API Used
**Open Trivia Database (OTDB)**  
[https://opentdb.com/api_config.php](https://opentdb.com/api_config.php)

- Provides fresh quiz questions on every run.
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
├── QuizApp.java               # Java source file
├── json-20210307.jar          # JSON Parsing Library (Download required)
└── README.md
