package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Library lib=new Library();
        Scanner scanner=new Scanner(System.in);
        int choice;
        System.out.println("Library Portal Initialized…");
        System.out.println("---------------------------------");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3. Exit");
        System.out.println("---------------------------------");
        System.out.println("Enter your choice: ");
        choice=scanner.nextInt();
        while(choice!=3){
            if(choice==1)
            {
                lib_menu(lib,scanner);
            }
            else if(choice==2)
            {
                scanner.nextLine();
                System.out.print("Enter Members name: ");
                String name=scanner.nextLine();
                System.out.print("Enter Member's Phone number: ");
                String ph_no=scanner.nextLine();
                Members meme=lib.enterAsMember(name,ph_no);
                if(meme!=null)
                {
                    System.out.println("Welcome "+meme.getMem_name()+". Member Id: "+meme.getMem_id());
                    mem_menu(lib,scanner,meme);
                }
            }
            else
            {
                System.out.println("Invalid choice Please try again.");
            }
            System.out.println("Library Portal Initialized…");
            System.out.println("---------------------------------");
            System.out.println("1. Enter as a librarian");
            System.out.println("2. Enter as a member");
            System.out.println("3. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice=scanner.nextInt();
        }
    }
    private static void lib_menu(Library libr, Scanner scanner) {
        int choice;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. Register a member");
            System.out.println("2. Remove a member");
            System.out.println("3. Add a book");
            System.out.println("4. Remove a book");
            System.out.println("5. View all members along with their books and fines to be paid");
            System.out.println("6. View all books");
            System.out.println("7. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter member's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter member's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter member's phone number: ");
                    String ph_no = scanner.nextLine();
                    libr.register_mem(name, age, ph_no);
                    break;
                case 2:
                    scanner.nextLine();
                    System.out.print("Enter member's phone number to remove: ");
                    ph_no = scanner.nextLine();
                    libr.remove_mem(ph_no);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter book's title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book's author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter number of books: ");
                    int copies = scanner.nextInt();
                    scanner.nextLine();
                    libr.add_book(title, author, copies);
                    break;
                case 4:
                    System.out.print("Enter book's ID to remove: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    libr.remove_book(id);
                    break;
                case 5:
                    libr.present_mem();
                    break;
                case 6:
                    libr.present_books();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void mem_menu(Library lib1, Scanner scanner, Members me) {
        int choice;

        while (true) {
            System.out.println("---------------------------------");
            System.out.println("1. List Available Books");
            System.out.println("2. List My Books");
            System.out.println("3. Issue a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Pay Fine");
            System.out.println("6. Back");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    lib1.present_books();
                    break;
                case 2:
                    me.booksborroweddetails();
                    break;
                case 3:
                    System.out.print("Enter book's Id: ");
                    int book_id = scanner.nextInt();
                    scanner.nextLine();
                    if(lib1.findbook(book_id)!=null) {
                        me.issue_book(lib1.findbook(book_id));
                    }
                    break;
                case 4:
                    System.out.print("Enter book's Id: ");
                    int return_book_id = scanner.nextInt();
                    scanner.nextLine();
                    me.returnbook(lib1.findbook(return_book_id));
                    break;
                case 5:
                    me.pay();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again!");
            }
        }
    }

}
