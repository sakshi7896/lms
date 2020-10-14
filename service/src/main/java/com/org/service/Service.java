package com.org.service;

import java.util.Scanner;
import com.org.dao.*;
import com.org.models.*;
public class Service {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to our library management system");
        Scanner s = new Scanner(System.in);
        System.out.println("Enetr initial number of books");
        int n= s.nextInt();
        Library library= new Library(n);
        while(true){
            System.out.println("Enter the following number to do any operation");
            System.out.println("1 : add book");
            System.out.println("2: find book by id");
            System.out.println("3. issue book");
            System.out.println("4: return book");
            System.out.println("5: delete book");
            System.out.println("6: retrieve Book by author");
            int choice= s.nextInt();
            switch (choice){
                case 1: {
                    library.addBook();
                    break;
                }
                case 2: {
                    System.out.println("Enetr id of the book to find");
                    long id = s.nextLong();
                    Book b= library.findBookById(id);
                    if(null!= b){
                        System.out.println("Book found was named" + b.getName());
                    }
                    else{
                        System.out.println("No book found by that id");
                    }
                    break;

                }
                case 3: {
                    System.out.println("Enetr id of the book to issue");
                    long id = s.nextLong();
                    if(library.issueBook(id)){
                        System.out.println("congrats book issued");
                    }
                    else{
                        System.out.println("Wrong id");
                    }
                    break;
                }
                case 4: {
                    System.out.println("Enetr id of the book to return");
                    long id = s.nextLong();
                    if(library.returnBook(id)){
                        System.out.println("congrats book returned");
                    }
                    else{
                        System.out.println("Wrong id");
                    }
                    break;
                }
                case 5:{
                    System.out.println("Enetr id of the book to delete");
                    long id = s.nextLong();
                    if(library.deleteBook(id)){
                        System.out.println("congrats book deleted");
                    }
                    else{
                        System.out.println("Wrong id");
                    }
                    break;
                }
                case 6: {
                    System.out.println("Enetr id of the author to find");
                    String authorName = s.next();
                    Book b= library.retrieveBookByAuthor(authorName);
                    if(null!= b){
                        System.out.println("Book with given author found was named" + b.getName());
                    }
                    else{
                        System.out.println("No book found by that id");
                    }
                    break;
                }
                default: System.out.println("Enter the correct choice");
            }

        }
    }
}
