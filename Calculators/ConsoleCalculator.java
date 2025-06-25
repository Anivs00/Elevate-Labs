import java.util.Scanner;

public class ConsoleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("Welcome to Simple Java Calculator!");

        while (keepRunning) {
            System.out.println("\nSelect Operation:");
            System.out.println("1. Addition (+)");
            System.out.println("2. Subtraction (-)");
            System.out.println("3. Multiplication (*)");
            System.out.println("4. Division (/)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting Calculator. Thank you!");
                break;
            }

          
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            double result = 0;

            if (choice == 1) {
                result = num1 + num2;
                System.out.println("Result: " + result);
            } else if (choice == 2) {
                result = num1 - num2;
                System.out.println("Result: " + result);
            } else if (choice == 3) {
                result = num1 * num2;
                System.out.println("Result: " + result);
            } else if (choice == 4) {
                if (num2 == 0) {
                    System.out.println("Error: Division by zero is not allowed.");
                } else {
                    result = num1 / num2;
                    System.out.println("Result: " + result);
                }
            } else {
                System.out.println("Invalid choice! Please try again.");
            }

            
            System.out.print("\nDo you want to continue? (Yes/No): ");
            String continueChoice = scanner.next();

            if (!continueChoice.equalsIgnoreCase("Yes")) {
                keepRunning = false;
                System.out.println("Thank you for using the calculator.");
            }
        }

        scanner.close();
    }
}
