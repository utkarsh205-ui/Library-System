package org.example;

import java.util.*;

public class Library {
    private Map<Integer, Members> members = new HashMap<>();
    private Map<Integer, Book> books = new HashMap<>();
    private int book_id=1;
    private int mem_id=1;


    public Book findbook(int bookId)
    {
        if(books.containsKey(bookId))
        {
            return books.get(bookId);
        }
        System.out.println("No book is present with this id");
        return null;
    }
    public void remove_book(int book_id)
    {
        if(books.containsKey(book_id) && findbook(book_id).getBorrower()==null)
        {
            System.out.println("Book removed has Id "+book_id);
            books.remove(book_id);
        }
        else
        {
            System.out.println("Book with Id- "+book_id+" is not present there or someone has issued it!");
        }
    }

    public void add_book(String name,String author,int copies) {
        for(int j=0;j<copies;j++)
        {
            Book booke=new Book(book_id+j,author,name);
            books.put(booke.getBook_id(),booke);
        }
        System.out.println("Books added successfully!");
        book_id+=copies;
    }

    public Members enterAsMember(String name, String phoneNumber) {
        for (Members member : members.values()) {
            if (member.getMem_name().equals(name) && member.getPhone_num().equals(phoneNumber)) {
                return member;
            }
        }
        System.out.println("No member found with this phone number!");
        return null;
    }

    public void register_mem(String name,int age,String ph_no)
    {
        for(Members mem1:members.values())
        {
            if((mem1.getPhone_num().equals(ph_no)))
            {
                System.out.println("Member with Name "+mem1.getMem_name()+" and Phone No: "+mem1.getPhone_num()+" already exists!");
                return;
            }
        }
        Members mem=new Members(mem_id,name,age,ph_no);
        members.put(mem_id,mem);
        System.out.println("Member Successfully registered with Id - "+mem_id);
        mem_id+=1;
    }


    public void present_mem() {
        System.out.println("The list of registered members is as follows:");
        for (Members member : members.values()) {
            System.out.println("Name: " + member.getMem_name());
            System.out.println("Member ID: " + member.getMem_id());
            System.out.println("Phone Number: " + member.getPhone_num());
            System.out.println("Books:");
            if(member.getBookstaken().values().size()>0) {
                for (Book book1 : member.getBookstaken().values()) {
                    System.out.println(("Book: " + book1.getBook_title()));
                }
            }
            else
            {
                System.out.println("No book taken!");
            }
            System.out.println("Fine "+member.getFine());
            System.out.println("------------------------");
        }
    }

    public void remove_mem(String phone_no)
    {
        for (Members mem1:members.values())
        {
            if(Objects.equals(mem1.getPhone_num(), phone_no) && mem1.getFine()==0 && mem1.getBookstaken().values().size()==0)
            {
                System.out.println("Mem with Id -"+mem1.getMem_id()+" has been removed!");
                members.remove(mem1.getMem_id());
                return;
            }
            else if(Objects.equals(mem1.getPhone_num(), phone_no) && mem1.getFine()!=0 && mem1.getBookstaken().values().size()==0)
            {
                System.out.println("Please pay the fine first!");
                return;
            }
            else if(Objects.equals(mem1.getPhone_num(), phone_no) && mem1.getFine()==0 && mem1.getBookstaken().values().size()!=0)
            {
                System.out.println("Please return the book first");
                return;
            }
        }
        System.out.println("No member is registered with this Id!");
    }

    public void all_Books()
    {
        System.out.println("Book present are:");
        for (Book book : books.values()) {
            book.book_details();
        }
    }
    public void present_books()
    {
        System.out.println("Books:");
        for (Book book : books.values()) {
            if (book.getBorrower() == null) {
                book.book_details();
                System.out.println();
            }
        }
    }
    public void getMembers() {
        System.out.println("Members present are:");
        for (Members mem:members.values())
        {
            mem.print_mem_details();
        }
    }


//    public void Mem_and_books() {
//        System.out.println("All Members and Books borrowed by them are shown below:");
//        for (Members member : members.values()) {
//            System.out.println("Member ID: " + member.getMem_id());
//            System.out.println("Phone Number: " + member.getPhone_num());
//            System.out.println("Name: " + member.getMem_name());
//
//            List<Book> borrowedBooks = member.getBookstaken();
//            if (!borrowedBooks.isEmpty()) {
//                System.out.println("Borrowed Books:");
//                for (Book book : borrowedBooks) {
//                    System.out.println("  Book ID: " + book.getBook_id());
//                    System.out.println("  Title: " + book.getBook_title());
//                    System.out.println("  Author: " + book.getBook_author());
//                }
//            } else {
//                System.out.println("No books borrowed!");
//            }
//            int fineAmount = calc_fine_mem(member);
//            if (fineAmount > 0) {
//                System.out.println("Fines to be Paid: " + fineAmount + " Rupees");
//            } else {
//                System.out.println("No fines to be paid.");
//            }
//            System.out.println("---------------------------------");
//        }
//    }
}

