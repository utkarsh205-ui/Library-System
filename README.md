# Library System README

This Java library system is designed to manage books and members of a library. It consists of several classes, including Book, Library, Main, and Members, each serving a specific role in the system.

## Classes Overview

### 1. Book
The `Book` class represents a book in the library. It includes attributes such as book ID, author, title, issue time, and borrower information. Here are the key methods and attributes of the `Book` class:

**Attributes**:
- `book_id`: An integer representing the unique ID of the book.
- `book_author`: A string representing the author of the book.
- `book_title`: A string representing the title of the book.
- `issue_time`: A `LocalTime` object representing the time when the book was issued.
- `borrower`: A `Members` object representing the member who borrowed the book.

**Methods**:
- `getBook_title()`: Get the title of the book.
- `setBook_title(String title)`: Set the title of the book.
- `book_details()`: Display the details of the book.
- `getIssue_time()`: Get the issue time of the book.
- `setIssue_time(LocalTime issue_time)`: Set the issue time of the book.
- `getBorrower()`: Get the borrower of the book.
- `setBorrower(Members borrower)`: Set the borrower of the book.
- `getBook_author()`: Get the author of the book.
- `setBook_author(String book_author)`: Set the author of the book.
- `getBook_id()`: Get the ID of the book.
- `setBook_id(int book_id)`: Set the ID of the book.
- `issue_book(Members mem)`: Issue the book to a member.
- `return_book(Members mem)`: Return the book and calculate fines if necessary.
- `finer()`: Calculate the fine for returning the book late.
- `newtime()`: Update the issue time of the book.

### 2. Library
The `Library` class represents the library itself and provides methods to manage books and members. It keeps track of registered members and available books. Key functionalities of the `Library` class include:

**Attributes**:
- `members`: A `Map` storing members with their IDs as keys.
- `books`: A `Map` storing books with their IDs as keys.
- `book_id`: An integer representing the next available book ID.
- `mem_id`: An integer representing the next available member ID.

**Methods**:
- `findbook(int bookId)`: Find a book by its ID.
- `remove_book(int book_id)`: Remove a book from the library.
- `add_book(String name, String author, int copies)`: Add books to the library.
- `enterAsMember(String name, String phoneNumber)`: Enter as a member.
- `register_mem(String name, int age, String ph_no)`: Register a new member.
- `present_mem()`: Display the list of registered members.
- `remove_mem(String phone_no)`: Remove a member from the library.
- `all_Books()`: Display all books in the library.
- `present_books()`: Display available books in the library.
- `getMembers()`: Display the list of registered members.

### 3. Main
The `Main` class contains the main method and serves as the user interface for interacting with the library system. It allows users to choose their roles as librarians or members and perform various actions accordingly.

### 4. Members
The `Members` class represents a library member and stores information about members, including their borrowed books and fines. It includes methods for managing books and fines, such as borrowing, returning, and paying fines.

## How to Use
Follow these steps to use the library system:

1. Run the Main class to start the library system.

2. Choose your role as a librarian or a member.

   - **Librarian Actions**:
       - Register and remove members.
       - Add and remove books.
       - View member details and available books.

   - **Member Actions**:
       - List available books.
       - List borrowed books.
       - Issue and return books.
       - Pay fines (if applicable).

3. Follow the prompts provided by the program to perform your chosen actions.

4. Explore and manage the library system as needed.

5. Exit the program when you are finished using it.

This library system allows librarians to manage the library's inventory and members, while members can browse available books, borrow and return them, and pay fines if necessary.

Feel free to explore the library system and efficiently manage books and members within your library. Enjoy using the system!
# Library-System
# Library-System
# Library-System
