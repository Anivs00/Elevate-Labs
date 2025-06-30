import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Load books from CSV
        String csvFile = "C:\\Users\\anidi\\Desktop\\Elevate-Labs\\LM\\books.csv"; // Your CSV path
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                // Correctly split CSV considering quoted commas
                String[] data = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");

                // Clean extra double quotes
                String isbn = data[0].trim().replace("\"", "");
                String title = data[1].trim().replace("\"", "");
                String category = data[2].trim().replace("\"", "");
                double price = Double.parseDouble(data[3].trim().replace("\"", ""));
                String status = data[4].trim().replace("\"", "");
                String author = data[5].trim().replace("\"", "");
                String publisher = data[6].trim().replace("\"", "");

                Book book = new Book(isbn, title, category, price, status, author, publisher);
                library.addBook(book);
            }
        } catch (IOException e) {
            System.out.println("Error reading the CSV file.");
            e.printStackTrace();
        }

        System.out.println("Welcome to the Library Management System!");

        while (true) {
                       System.out.println("1. View Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 1) {
                library.displayAvailableBooks();
            } else if (choice == 2) {
                System.out.print("Enter ISBN of the book to issue: ");
                String isbn = scanner.nextLine();
                Book book = library.findBookByISBN(isbn);
                if (book != null && book.isAvailable()) {
                    book.issueBook();
                    System.out.println("Book issued successfully.");
                } else {
                    System.out.println("Book not available or ISBN incorrect.");
                }
            } else if (choice == 3) {
                System.out.print("Enter ISBN of the book to return: ");
                String isbn = scanner.nextLine();
                Book book = library.findBookByISBN(isbn);
                if (book != null && !book.isAvailable()) {
                    book.returnBook();
                    System.out.println("Book returned successfully.");
                } else {
                    System.out.println("Book not found or already available.");
                }
            } else if (choice == 4) {
                System.out.println("Exiting the system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
