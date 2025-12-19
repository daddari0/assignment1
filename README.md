Task 1 – Class Rectangle (15 points)
Create a class Rectangle which represents a rectangle.
Fields (private):
• double width;
• double height;
• int id;
• static int idGen;
Constructors:
1. Default constructor
   • sets width = 1.0, height = 1.0;
   • assigns a unique id using idGen++.
2. Constructor with parameters
   public Rectangle(double width, double height)
   • calls the default constructor using this();;
   • sets width and height via setters.
   Course name: Object Orientated Programming (Java)
   Course instructor: Traxel Xeniya Alexandrovna
   Course trimester/Course year: 2/1
   Assignment number: 1
   Assignment name: Classes and methods
   Assignment Form Submission and defense of written reports
   Methods:
   • Getters and setters for width and height.
   o In setters, check that width > 0 and height > 0.
   o If the value is invalid, throw IllegalArgumentException.
   • public double area() – returns the area of the rectangle.
   • public double perimeter() – returns the perimeter of the rectangle.
   • Override toString() to return a readable representation of the rectangle, including id,
   width and height.
   Task 2 – Class Book (20 points)
   Create a class Book to store information about books in a small library.
   Fields (private):
   • int id;
   • static int idGen;
   • String title;
   • String author;
   • int year;
   • boolean available;
   o true – the book is available;
   o false – the book is borrowed.
   Constructors:
1. Default constructor
   • sets id using idGen and increments idGen;
   • sets available = true.
2. Constructor with parameters
   public Book(String title, String author, int year)
   • calls the default constructor using this();;
   • sets title, author and year via setters.
   Methods:
   • Getters and setters for all fields except idGen.
   • Validation in setters:
   o title and author must not be null or empty;
   o year must be in a reasonable range, e.g. 1500 <= year <= currentYear.
   • public void markAsBorrowed() – sets available = false.
   • public void markAsReturned() – sets available = true.
   • Override toString() to include id, title, author, year and available status.
   Task 3 – Console application LibraryApp (25 points)
   Create a console application to manage a list of books.
   Requirements:
   • Create a class LibraryApp with:
   o a field ArrayList<Book> books (or List<Book>);
   o a Scanner for console input.
   • Implement a method:
   public void run()
   which:
   • shows a text menu in a loop;
   • reads the user’s choice;
   • calls the corresponding methods using switch / case.
   Menu example:
   Welcome to Library App!
1. Print all books
2. Add new book
3. Search books by title
4. Borrow a book
5. Return a book
6. Delete a book by id
7. Quit
   Functionality:
   • Print all books
   o if the list is empty, print: No books in the library;
   o otherwise print all books using toString().
   • Add new book
   o ask the user for title, author, year;
   o create a new Book object;
   o add it to the list.
   • Search books by title
   o ask the user to input part of the title;
   o print all books where the title contains this substring
   (case-insensitive comparison).
   • Borrow a book
   o ask for id;
   o find the book with this id;
   o if available == true, call markAsBorrowed();
   o otherwise print that the book is already borrowed.
   • Return a book
   o ask for id;
   o if the book exists and available == false, call markAsReturned().
   • Delete a book by id
   o ask for id;
   o remove the book from the list if it exists;
   o otherwise show an error message (book not found).
   • Quit
   o exit the application.
