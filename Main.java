
class Book {
    int bookid;
    String title;
    String author;
    double price;

    static int totalBooks = 0;

    Book(int bookid, String title, String author, double price) {
        this.bookid = bookid;
        this.title = title;
        this.author = author;
        this.price = price;
        totalBooks++;
    }

    void display() {
        System.out.println("Book ID : " + bookid);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : ₹" + price);
        System.out.println("-------------------------");
    }

    boolean search(int id) {
        return this.bookid == id;
    }

    boolean search(String title) {
        return this.title.equalsIgnoreCase(title);
    }

    Book costlierBook(Book other) {
        if (this.price >= other.price)
            return this;
        else
            return other;
    }

    static int getTotalBooks() {
        return totalBooks;
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(101, "java", "james gosling", 550.00);
        Book b2 = new Book(102, "python", "guido van rossum", 450.00);
        Book b3 = new Book(103, "Data Structures", "Mark Allen", 650.00);

        System.out.println("BOOK DETAILS");
        System.out.println("=========================");

        b1.display();
        b2.display();
        b3.display();

        System.out.println("Searching by Book ID 102:");

        if (b2.search(102))
            System.out.println("Book found: Python");
        else
            System.out.println("Book not found.");

        System.out.println("\nSearching by Title 'Data Structures':");

        if (b3.search("Data Structures"))
            System.out.println("Book found: Data Structures");
        else
            System.out.println("Book not found.");

        Book costlier = b1.costlierBook(b3);

        System.out.println("\nCostlier Book:");
        costlier.display();

        System.out.println("Total Books Created: " + Book.getTotalBooks());
    }
}
