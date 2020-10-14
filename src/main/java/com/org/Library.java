package com.org;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Library {
    List<Book> books;

    public Library(int initialSize) {
        books= new ArrayList<Book>(initialSize);
    }
    private Book getBookDetails(){
        Book b= new Book();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter book id:");
        b.setId(s.nextLong());
        System.out.println("enter book name");
        b.setName(s.next());
        System.out.println("Enter Author Details: ");
        System.out.println("Enter number of authors");
        int n = s.nextInt();
        List<Author> authors= new ArrayList<Author>();
        for(int i=0;i<n;i++){
            Author a = new Author();
            System.out.println("Enter Author id");
            a.setId(s.nextInt());
            System.out.println("Enetr author first name");
            a.setfName(s.next());
            System.out.println("Enter author last name");
            a.setlName(s.next());
            a.setLastUpdatedTime(new Date());
            authors.add(a);
        }
        b.setAuthor(authors);
        System.out.println("Enter number of copies");
        b.setNoOfCopies(s.nextInt());
        b.setIssuedCopies(0);
        System.out.println("Enter cost");
        b.setCost(s.nextInt());
        System.out.println("Enter edition number");
        b.setEditionNumber(s.nextInt());
        System.out.println("Enter shelf number");
        b.setShelf(s.nextInt());
        return b;
    }

    public long addBook() throws Exception {
        try{
           Book book = getBookDetails();
           books.add(book);
           return book.getId();
        }catch (Exception e){
            throw new Exception(e);
        }
    }
    public Book findBookById(long id){
        for(Book b : books){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
    public boolean issueBook(long id){
        for(Book b: books){
            if(b.getId()==id){
                if(b.getNoOfCopies()-b.getIssuedCopies()>0){
                    int issuedCopies= b.getIssuedCopies();
                    b.setIssuedCopies(issuedCopies--);
                    return true;
                }
            }
        }
        return false;
    }
    public boolean returnBook(long id) throws Exception{
        try{
            for(Book b: books){
                if(b.getId()==id){
                    int issuedBooks= b.getIssuedCopies();
                    b.setIssuedCopies(issuedBooks+1);
                    assert(b.getIssuedCopies()<b.getNoOfCopies());
                    return true;
                }
            }
        }
        catch (Exception e){
            throw new Exception(e);
        }
        return false;
    }
    public boolean deleteBook(long id) throws Exception{
        Book bookToBeDel= new Book();
        for(Book b: books){
            if(b.getId()==id){
                bookToBeDel=b;
                books.remove(bookToBeDel);
                return true;
            }
        }
        return false;
    }
    public Book retrieveBookByAuthor(String authorName){
        for(Book b: books){
            List<Author> authors = b.getAuthor();
            for(Author a : authors){
                if(a.getfName()==authorName){
                    return b;
                }
            }
        }
        return new Book();
    }

}
