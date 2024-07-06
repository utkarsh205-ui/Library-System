package org.example;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.Instant;

public class Book {
    private int book_id;
    private String book_author;
    private String book_title;
    private LocalTime issue_time;
    private Members borrower;
    public String getBook_title()
    {
        return this.book_title;
    }
    public void setBook_title(String title)
    {
        this.book_title=title;
    }
    public void book_details()
    {
        System.out.println("Book ID - "+this.book_id);
        System.out.println("Name-"+this.book_title);
        System.out.println("Author-"+this.book_author);
    }
    public LocalTime getIssue_time() {
        return issue_time;
    }

    public void setIssue_time(LocalTime issue_time) {
        this.issue_time = issue_time;
    }

    public Members getBorrower() {
        return borrower;
    }
    public void setBorrower(Members borrower) {
        this.borrower = borrower;
    }
    public String getBook_author() {
        return book_author;
    }
    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }
    public int getBook_id() {
        return book_id;
    }
    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }
    public Book(int id,String book_author, String book_title)
    {
        this.book_author=book_author;
        this.book_title=book_title;
        this.book_id=id;
    }
    public void issue_book(Members mem)
    {
        if(mem.getFine()>0)
        {
            System.out.println("Please pay the fine first of "+mem.getFine());
        }
        else if(borrower==null)
        {
            this.issue_time=LocalTime.now();
            this.borrower=mem;
            System.out.println(book_title+" issued to "+borrower.getMem_name());
        }
        else
        {
            System.out.println("The book is borrowed already!");
        }
    }
    public void return_book(Members mem)
    {
        if(borrower==null)
        {
            System.out.println("You didn't borrow this book!");
        }
        else if(borrower.getMem_id()!=mem.getMem_id())
        {
            System.out.println("You didn't borrow this book!");
        }
        else
        {
            Duration diff=Duration.between(issue_time,LocalTime.now());
            if(diff.getSeconds()<10)
            {
                this.issue_time=null;
                this.borrower=null;
                System.out.println("Returned!");
            }
            else
            {
                mem.setFine(mem.getFine()+((int) diff.getSeconds()-10)*3);
                System.out.println("Fine of "+((int) diff.getSeconds()-10)*3+" Total fine now is "+mem.getFine());
                this.issue_time=null;
                this.borrower=null;
            }
        }
    }
    public int finer()
    {
        Duration diff=Duration.between(issue_time,LocalTime.now());
        if((int) diff.getSeconds()<10)
        {
            return 0;
        }
        else
        {
            return ((int) diff.getSeconds()-10)*3;
        }
    }
    public void newtime()
    {
        this.issue_time=LocalTime.now().minusSeconds(10);
    }
}
