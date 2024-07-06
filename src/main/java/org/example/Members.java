package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Members {
    private int age;
    private String phone_num;
    private String mem_name;
    private Map<Integer,Book> bookstaken=new HashMap<>();
    private int fine;
    private int mem_id;

    public Members(int mem_id,String mem_name,int age,String phone_num)
    {
        this.mem_name=mem_name;
        this.age= age;
        this.phone_num=phone_num;
        this.fine=0;
        this.mem_id=mem_id;
    }
    public int getFine() {
        return fine;
    }
    public void setFine(int fine) {
        this.fine = fine;
    }
    public Map<Integer,Book> getBookstaken()
    {
        Map<Integer,Book>newone=this.bookstaken;
        return newone;
    }
    public void booksborroweddetails()
    {
        if(bookstaken.values().size()>0){
            for(Book booke:bookstaken.values())
            {
                booke.book_details();
            }
        }
        else
        {
            System.out.println("No Book borrowed");
        }
    }
    public void print_mem_details()
    {
        System.out.println("Mem_id - "+this.mem_id);
        System.out.println("Member Name - "+this.mem_name);
        System.out.println("Your fine is -"+this.fine);
        System.out.println("Books taken by the mem are:");
        booksborroweddetails();
    }
    public String getMem_name() {
        return mem_name;
    }
    public void setMem_name(String mem_name) {
        this.mem_name = mem_name;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String getPhone_num() {
        return phone_num;
    }
    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }
    public int calc_fine()
    {
        int startfine=fine;
        for(Book booke:bookstaken.values())
        {
            startfine+=booke.finer();
        }
        return startfine;
    }
    public int getMem_id()
    {
        return this.mem_id;
    }

    public void issue_book(Book book1)
    {
        if(calc_fine()>0)
        {
            System.out.println("Please pay the fine of "+calc_fine());
        }
        else if(!bookstaken.containsKey(book1.getBook_id())&& book1.getBorrower()==null && bookstaken.values().size()<2)
        {
            System.out.println("Book "+book1.getBook_title()+" has been borrowed!");
            bookstaken.put(book1.getBook_id(),book1);
            book1.issue_book(this);
        }
        else if(!bookstaken.containsKey(book1.getBook_id())&& book1.getBorrower()==null && bookstaken.values().size()>=2)
        {
            System.out.println("you have already borrowed 2 books");
        }
        else
        {
            System.out.println("This book is not available or already borrowed");
        }
    }

    public void returnbook(Book book1)
    {
        if(bookstaken.containsKey(book1.getBook_id()))
        {
            bookstaken.remove(book1.getBook_id());
            book1.return_book(this);
            System.out.println("book "+book1.getBook_title()+ " returned successfully");
        }
        else
        {
            System.out.println("You didn't borrow this book!");
        }
        return;
    }
    public void pay()
    {
        if(fine==0)
        {
            System.out.println("No fine to pay!");
        }
        else
        {
            System.out.println("You had a total fine of Rs. "+calc_fine()+". It has been paid successfully!");
            this.fine=0;
            for(Book book:bookstaken.values())
            {
                book.newtime();
            }
        }
    }

}
