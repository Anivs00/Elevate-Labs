public class Book {
    String isbn;
    String title;
    String category;
    double rentalPrice;
    String status;
    String author;
    String publisher;

    public Book(String isbn, String title, String category, double rentalPrice, String status, String author, String publisher) {
        this.isbn = isbn;
        this.title = title;
        this.category = category;
        this.rentalPrice = rentalPrice;
        this.status = status;
        this.author = author;
        this.publisher = publisher;
    }

    public void issueBook() {
        this.status = "no";
    }

    public void returnBook() {
        this.status = "yes";
    }

    public boolean isAvailable() {
        return this.status.equalsIgnoreCase("yes");
    }

    public void displayInfo() {
        System.out.println("ISBN: " + isbn + " | Title: " + title + " | Category: " + category + " | Price: " + rentalPrice + " | Status: " + status);
    }
}
