public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isIssued;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false; // By default, a new book is available
    }

    // Getters
    public String getIsbn() {
        return isbn;
    }

    public boolean isIssued() {
        return isIssued;
    }

    // Setters (used by the Library class for issue/return)
    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    @Override
    public String toString() {
        String status = isIssued ? "Issued" : "Available";
        return String.format("Title: %s | Author: %s | ISBN: %s | Status: %s", 
                             title, author, isbn, status);
    }
}
