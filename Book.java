package library;

public class Book  implements LibraryManagement{
        private String title;
    private String author;
    private long isbn;
    private int publicationYear;
    private boolean available;

    public Book(String title, String author, long isbn, int publicationYear) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.available = true; // default: book is available
    }
     public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public long getIsbn() { return isbn; }
    public void setIsbn(long isbn) { this.isbn = isbn; }

    public int getPublicationYear() { return publicationYear; }
    public void setPublicationYear(int year) { this.publicationYear = year; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String toString() {
        return "\"" + title + "\" by " + author + " (ISBN:" + isbn + ", Available: " + available + ")";
    }
}
    
