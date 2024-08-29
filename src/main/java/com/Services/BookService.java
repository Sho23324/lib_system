package com.Services;

import java.util.List;


import com.context.Context;
import com.entities.Author;
import com.entities.Book;

import jakarta.persistence.NoResultException;

public class BookService {

    public static void ViewAllBooks(Context ctx) {
        int i=1;
        List<Book> books = ctx.getBookRepo().viewBooks();
        for(Book book : books) {
            System.out.println(i + " " + book.getTitle());
            i++;
        }
        System.out.println();
    }


    public static void ViewBooks(Context ctx){
        System.out.println("1. view all books");
        System.out.println("2. view available books");
        System.out.println("3. view unvailable books");

        int ops = ctx.getSc().nextInt();
        System.out.print("\033c");
        switch (ops) {
            case 1:
                ViewAllBooks(ctx);
                break;
            case 2:
                ShowAvailableBooks(ctx);
                break;
            case 3:
                ShowUnavailableBooks(ctx);
                break;
            default:
            break;
        }
        System.out.println();
        
    }
    //create new book
    public static void AddNewBook(Context ctx) {
        char choice;
        do {
            AuthorService.ShowAuthor(ctx);
            System.out.print("Select Author id : ");
            long author_id = ctx.getSc().nextLong();
    
            ctx.getSc().nextLine();
            System.out.print("Enter book title : ");
            String title = ctx.getSc().nextLine();

            System.out.print("Enter book genre : ");
            String genre = ctx.getSc().nextLine();

            Book book = new Book();
            Author author = ctx.getAuthorRepo().GetAuthorById(author_id);
            book.setTitle(title);
            book.setGenre(genre);
            book.setAuthor(author);
            ctx.getBookRepo().UpdateBook(book);
    
            System.out.println("Want to add another book y/n : ");
            choice = ctx.getSc().next().charAt(0);
            
        } while (choice == 'y');
        System.out.print("\033c");
        
    }

    public static void ShowAvailableBooks(Context ctx){
        int i=1;
        List<Book> books = ctx.getBookRepo().ViewAvailableBook();
        for(Book book : books) {
            System.out.println(i + " " + book.getTitle());
            i++;
        }
        System.out.println();
    }

    public static void ShowUnavailableBooks(Context ctx) {
        int i=1;
        List<Book> books = ctx.getBookRepo().ViewUnvailableBook();
        for(Book book : books) {
            System.out.println(i + " " + book.getTitle());
            i++;
        }
        System.out.println();
    }

    public static void ShowBorrow(Context ctx) {
        List<Book> books = ctx.getBookRepo().ViewAvailableBook();
        for(Book book : books) {
            System.out.println(book.getId() + " " + book.getTitle());

        }
    }

    public static void RemoveBook(Context ctx) {
        System.out.println("Enter book id(s) ending with -1 : ");
        long id;
        do {
            ShowBooksId(ctx);
            id = ctx.getSc().nextLong();
            if(id != -1) {
                Book book = ctx.getBookRepo().GetBookById(id);
                try {
                    
                    BorrowService.RemoveBorrowList(ctx, book);
                    } catch (NoResultException e) {
                    
                }   
               
                ctx.getBookRepo().RemoveBook(book);

                System.out.println("remove successful");
                System.out.println();   
                
            }
            
        } while (id != -1);
        System.out.print("\033c");

    }

    public static void ShowBooksId(Context ctx){
        List<Book> books = ctx.getBookRepo().viewBooks();
        for(Book book : books) {
            System.out.println(book.getId() + " " + book.getTitle());

        }
    }

    public static void Remove(Context ctx){
        System.out.println("1. Remove Author");
        System.out.println("2. Remove Book");
        int id = ctx.getSc().nextInt();
        System.out.print("\033c");
        if(id == 1) {
            AuthorService.RemoveAuthor(ctx);
        }else if(id == 2) {
            RemoveBook(ctx);
        }
    }

    
}

