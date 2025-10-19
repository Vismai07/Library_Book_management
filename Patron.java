package library;

import java.util.ArrayList;
import java.util.List;
public class Patron {
    private String name;
    private String id;
    private List<Long> borrowedBooks; // List of ISBNs

    public Patron(String name, String id) {
        this.name = name;
        this.id = id;
        borrowedBooks = new ArrayList<>();
    }

    public String getName() { return name; }
    public String getId() { return id; }

    public List<Long> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(long isbn) {
        borrowedBooks.add(isbn);
    }

    public void returnBook(long isbn) {
        borrowedBooks.remove(isbn);
    }

    public void showBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
        } else {
            System.out.println(name + " has borrowed: " + borrowedBooks);
        }
    }

    @Override
    public String toString() {
        return "Patron[Name=" + name + ", ID=" + id + "]";
    }
}
