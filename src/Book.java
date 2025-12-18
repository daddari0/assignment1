import java.time.Year;

public class Book {
    private int id;
    private static int idGen = 1;
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book() {
        this.id = idGen++;
        this.available = true;
    }

    public Book(String title, String author, int year) {
        this();
        settitle(title);
        setauthor(author);
        setyear(year);
    }

    public int getid() {
        return id;
    }

    public static int getIdGen() {
        return idGen;
    }

    public String gettitle() {
        return title;
    }

    public String getauthor() {
        return author;
    }

    public int getyear() {
        return year;
    }

    public boolean isavailable() {
        return available;
    }

    public void settitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title must not be empty");
        }
        this.title = title.trim();
    }

    public void setauthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author must not be empty");
        }
        this.author = author.trim();
    }

    public void setyear(int year) {
        int currentYear = Year.now().getValue();
        if (year < 1500 || year > currentYear) {
            throw new IllegalArgumentException("Year must be between 1500 and " + currentYear);
        }
        this.year = year;
    }

    public void markasborrowed() {
        this.available = false;
    }

    public void markasreturned() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book{id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", available=" + available +
                '}';
    }
}
