import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Libraryapp {

    private List<Book> books = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Libraryapp app = new Libraryapp();
        app.run();
    }

    public void run() {
        boolean running = true;
        while (running) {
            printmenu();
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    printallbooks();
                    break;
                case "2":
                    addnewbook();
                    break;
                case "3":
                    searchbooksbytitle();
                    break;
                case "4":
                    borrowbook();
                    break;
                case "5":
                    returnbook();
                    break;
                case "6":
                    deletebookbyid();
                    break;
                case "7":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
            System.out.println();
        }
    }

    private void printmenu() {
        System.out.println("Welcome to Library App!");
        System.out.println("1. Print all books");
        System.out.println("2. Add new book");
        System.out.println("3. Search books by title");
        System.out.println("4. Borrow a book");
        System.out.println("5. Return a book");
        System.out.println("6. Delete a book by id");
        System.out.println("7. Quit");
    }

    private void printallbooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    private void addnewbook() {
        try {
            System.out.print("Enter title: ");
            String title = scanner.nextLine();

            System.out.print("Enter author: ");
            String author = scanner.nextLine();

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine().trim());

            Book book = new Book(title, author, year);
            books.add(book);
            System.out.println("Book added: " + book);
        } catch (NumberFormatException e) {
            System.out.println("Year must be a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error while creating book: " + e.getMessage());
        }
    }

    private void searchbooksbytitle() {
        System.out.print("Enter part of title: ");
        String part = scanner.nextLine().toLowerCase(Locale.ROOT);

        boolean found = false;
        for (Book b : books) {
            if (b.gettitle() != null &&
                    b.gettitle().toLowerCase(Locale.ROOT).contains(part)) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found with this title part.");
        }
    }

    private void borrowbook() {
        System.out.print("Enter book id to borrow: ");
        int id = readintid();
        Book book = findbookbyid(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (book.isavailable()) {
            book.markasborrowed();
            System.out.println("Book borrowed: " + book);
        } else {
            System.out.println("The book is already borrowed.");
        }
    }

    private void returnbook() {
        System.out.print("Enter book id to return: ");
        int id = readintid();
        Book book = findbookbyid(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        if (!book.isavailable()) {
            book.markasreturned();
            System.out.println("Book returned: " + book);
        } else {
            System.out.println("The book is not borrowed.");
        }
    }

    private void deletebookbyid() {
        System.out.print("Enter book id to delete: ");
        int id = readintid();
        Book book = findbookbyid(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        books.remove(book);
        System.out.println("Book deleted: " + book);
    }

    private int readintid() {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Id must be a number.");
            return -1;
        }
    }

    private Book findbookbyid(int id) {
        if (id < 0) return null;
        for (Book b : books) {
            if (b.getid() == id) {
                return b;
            }
        }
        return null;
    }
}
