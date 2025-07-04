import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.*;

import org.json.JSONArray;
import org.json.JSONObject;

public class QuizApp {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

 
        String apiUrl = "https://opentdb.com/api.php?amount=5&type=multiple";

        
        String jsonResponse = fetchQuizData(apiUrl);

        List<Question> questions = parseQuestions(jsonResponse);

        System.out.println("Welcome to the Java Quiz! 🎉");
        System.out.println("--------------------------------");

        int score = 0;

        for (Question q : questions) {
            q.displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int userAnswer = scanner.nextInt();

            if (q.isCorrect(userAnswer)) {
                System.out.println("Correct! ✅\n");
                score++;
            } else {
                System.out.println("Wrong ❌");
                System.out.println("Correct Answer: " + q.getCorrectOption() + "\n");
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Quiz Finished! Your Score: " + score + "/" + questions.size());
        scanner.close();
    }

    public static String fetchQuizData(String apiUrl) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }


    public static List<Question> parseQuestions(String jsonResponse) {
        List<Question> questions = new ArrayList<>();
        JSONObject obj = new JSONObject(jsonResponse);
        JSONArray results = obj.getJSONArray("results");

        for (int i = 0; i < results.length(); i++) {
            JSONObject item = results.getJSONObject(i);
            String questionText = htmlDecode(item.getString("question"));
            String correctAnswer = htmlDecode(item.getString("correct_answer"));
            JSONArray incorrectAnswers = item.getJSONArray("incorrect_answers");

            List<String> options = new ArrayList<>();
            for (int j = 0; j < incorrectAnswers.length(); j++) {
                options.add(htmlDecode(incorrectAnswers.getString(j)));
            }
            options.add(correctAnswer);
            Collections.shuffle(options);

            int correctIndex = options.indexOf(correctAnswer) + 1; 
            questions.add(new Question(questionText, options, correctIndex));
        }

        return questions;
    }

    public static String htmlDecode(String text) {
        return text.replaceAll("&quot;", "\"")
                   .replaceAll("&#039;", "'")
                   .replaceAll("&amp;", "&")
                   .replaceAll("&eacute;", "é");
    }
}


class Question {
    String questionText;
    List<String> options;
    int correctAnswer;

    public Question(String questionText, List<String> options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println(questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean isCorrect(int userAnswer) {
        return userAnswer == correctAnswer;
    }

    public String getCorrectOption() {
        return options.get(correctAnswer - 1);
    }
}
