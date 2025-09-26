import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;
    private int nextUserId = 101; // Starting ID for users

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Utility Methods
    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(String name) {
        User newUser = new User(nextUserId++, name);
        this.users.add(newUser);
        System.out.println("User added: " + newUser.getName() + " (ID: " + newUser.getUserId() + ")");
    }

    public void displayAllBooks() {
        System.out.println("\n--- All Books in Library ---");
        if (books.isEmpty()) {
            System.out.println("The library is currently empty.");
            return;
        }
        for (Book book : books) {
            System.out.println(book);
        }
    }

    // Core Business Logic: ISSUE
    public void issueBook(int userId, String isbn) {
        User user = findUser(userId);
        Book book = findBook(isbn);

        if (user == null) {
            System.out.println("❌ Issue Failed: User ID " + userId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("❌ Issue Failed: Book ISBN " + isbn + " not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("❌ Issue Failed: Book '" + book.toString().split(" \\| ")[0] + "' is already issued.");
            return;
        }

        // Perform the Issue
        book.setIssued(true);
        user.getIssuedBooks().add(book);
        System.out.println("✅ Book Issued: '" + book.toString().split(" \\| ")[0] + "' issued to " + user.getName() + ".");
    }

    // Core Business Logic: RETURN
    public void returnBook(int userId, String isbn) {
        User user = findUser(userId);
        Book book = findBook(isbn);

        if (user == null) {
            System.out.println("❌ Return Failed: User ID " + userId + " not found.");
            return;
        }
        if (book == null) {
            System.out.println("❌ Return Failed: Book ISBN " + isbn + " not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("❌ Return Failed: Book '" + book.toString().split(" \\| ")[0] + "' is not currently issued.");
            return;
        }

        // Perform the Return
        boolean removedFromUser = user.getIssuedBooks().remove(book);
        
        if (removedFromUser) {
            book.setIssued(false);
            System.out.println("✅ Book Returned: '" + book.toString().split(" \\| ")[0] + "' returned by " + user.getName() + ".");
        } else {
             // This condition should rarely be met if logic is sound, but handles cases where the book is issued but not to this specific user.
            System.out.println("❌ Return Failed: Book is issued, but not by this user.");
        }
    }

    // Private helper methods for lookup
    private User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {
                return user;
            }
        }
        return null;
    }

    private Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
}
