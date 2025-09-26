import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Book> issuedBooks; // List of books currently checked out by this user

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }
    
    // Helper method to display user's currently issued books
    public void displayIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println(name + " currently has no books issued.");
            return;
        }
        System.out.println("--- Books Issued to " + name + " ---");
        for (Book book : issuedBooks) {
            // Note: We display the book's details, not the full toString() with status
            System.out.println(String.format(" - %s (ISBN: %s)", book.toString().split(" \\| ")[0], book.getIsbn()));
        }
    }

    @Override
    public String toString() {
        return String.format("User ID: %d | Name: %s | Books Issued: %d", 
                             userId, name, issuedBooks.size());
    }
}
