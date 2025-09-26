public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Library System
        Library library = new Library();

        System.out.println("--- Library Management System Initialization ---");

        // 2. Add Books
        library.addBook(new Book("The Java Programming", "J. Gosling", "978-0131485526"));
        library.addBook(new Book("Clean Code", "R. C. Martin", "978-0132350884"));
        library.addBook(new Book("Design Patterns", "E. Gamma", "978-0201633610"));

        // 3. Add Users
        library.addUser("Alice Johnson"); // ID 101
        library.addUser("Bob Williams"); // ID 102
        
        System.out.println("\n------------------------------------------------");

        // 4. Demonstrate Issue Feature
        System.out.println("\n--- Testing Issue Feature ---");
        // Issue "Clean Code" to Alice (ID 101)
        library.issueBook(101, "978-0132350884"); 
        
        // Attempt to issue "The Java Programming" to Bob (ID 102)
        library.issueBook(102, "978-0131485526");

        // Attempt to issue the same book again (should fail)
        library.issueBook(101, "978-0132350884");

        // 5. Check Status
        library.displayAllBooks();
        
        System.out.println("\n------------------------------------------------");

        // 6. Demonstrate Return Feature
        System.out.println("\n--- Testing Return Feature ---");
        // Bob returns his book
        library.returnBook(102, "978-0131485526");

        // Alice attempts to return a book she didn't issue (should fail)
        library.returnBook(101, "978-0201633610"); 
        
        // 7. Final Status Check
        library.displayAllBooks();
        
        // Optional: Check Alice's issued books
        // (Note: To access user details, we'd need a method to retrieve a User object from Library)
        // For simplicity, let's assume we can get User 101 for a final check (requires modifications to Library to expose the users list or add a public findUser method)
    }
}
