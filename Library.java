package library;

import java.util.ArrayList;
import java.util.List;

public class Library implements LibraryManagement {
     private List<Book> books;
    private List<Patron> patrons;

    public Library() {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    // ----------------- Book Management -----------------
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(long isbn) {
        books.removeIf(b -> b.getIsbn() == isbn);
        System.out.println("Book with ISBN " + isbn + " removed.");
    }

    public void updateBook(long isbn, String newTitle, String newAuthor, int newYear) {
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                b.setTitle(newTitle);
                b.setAuthor(newAuthor);
                b.setPublicationYear(newYear);
                System.out.println("Book updated: " + b);
                return;
            }
        }
        System.out.println("Book not found with ISBN " + isbn);
    }

    public void searchByTitle(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("No book found with title: " + title);
    }

    public void searchByAuthor(String author) {
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("No book found with author: " + author);
    }

    public void searchByIsbn(long isbn) {
        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                System.out.println(b);
                return;
            }
        }
        System.out.println("No book found with ISBN: " + isbn);
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // ----------------- Patron Management -----------------
    public void addPatron(Patron patron) {
        patrons.add(patron);
        System.out.println("Patron added: " + patron.getName());
    }

    public void showAllPatrons() {
        if (patrons.isEmpty()) {
            System.out.println("No patrons in library.");
            return;
        }
        for (Patron p : patrons) {
            System.out.println(p);
        }
    }

    public Patron getPatronById(String id) {
        for (Patron p : patrons) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    // ----------------- Lending Process -----------------
    public void checkoutBook(String patronId, long isbn) {
        Patron patron = getPatronById(patronId);
        if (patron == null) {
            System.out.println("Patron not found!");
            return;
        }

        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                if (!b.isAvailable()) {
                    System.out.println("Book is currently borrowed.");
                    return;
                }
                b.setAvailable(false);
                patron.borrowBook(isbn);
                System.out.println(patron.getName() + " borrowed " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(String patronId, long isbn) {
        Patron patron = getPatronById(patronId);
        if (patron == null) {
            System.out.println("Patron not found!");
            return;
        }

        for (Book b : books) {
            if (b.getIsbn() == isbn) {
                if (!patron.getBorrowedBooks().contains(isbn)) {
                    System.out.println("This book was not borrowed by this patron.");
                    return;
                }
                b.setAvailable(true);
                patron.returnBook(isbn);
                System.out.println(patron.getName() + " returned " + b.getTitle());
                return;
            }
        }
        System.out.println("Book not found!");
    }
}

