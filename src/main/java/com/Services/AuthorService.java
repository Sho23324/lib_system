package com.Services;

import java.util.List;

import com.context.Context;
import com.entities.Author;
import com.entities.Book;

import jakarta.persistence.NoResultException;


public class AuthorService {

    public static void ShowAuthor(Context ctx){
        List<Author> authors = ctx.getAuthorRepo().ShowAuthor();
        int i=1;
        for(Author author : authors) {
            System.out.println(i+"." + " " +author.getName());
            i++;
        }
        
    }

    public static void SearchBookByAuthor(Context ctx){
        ShowAuthor(ctx);
        ctx.getSc().nextLine();
        System.out.print("Enter Author id : ");
        Long id = ctx.getSc().nextLong();
        System.out.print("\033c");
        Author author = ctx.getAuthorRepo().GetAuthorById(id);
        List<Book> books = ctx.getAuthorRepo().GetBookByAuthor(author);
        int i = 1;
        System.out.println("Author name : " + author.getName());
        for(Book book : books) {
            System.out.println(i+"." + " " + book.getTitle());
            i++;
        }
        System.out.println();

    }

    public static void CreateAuthor(Context ctx){
        ctx.getSc().nextLine();
        System.out.println("Enter Author name : ");
        String author_name = ctx.getSc().nextLine();

        Author author = new Author(author_name);

        ctx.getAuthorRepo().CreateAuthor(author);

        System.out.println("wanna add books of this author y/n");
        char ops = ctx.getSc().next().charAt(0);
        if(ops == 'y') {
            System.out.println("Enter book title : ");
            String title = ctx.getSc().nextLine();

        }else{
            
        }
    }

    public static void AddBookToAuthor(Context ctx){
        ShowAuthor(ctx);
        System.out.println("Enter Author id : ");
        Long id = ctx.getSc().nextLong();
        Author author = ctx.getAuthorRepo().GetAuthorById(id);
        System.out.println("Enter book title : ");
        String title = ctx.getSc().nextLine();
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        ctx.getAuthorRepo().AddBookToAuthor(book);;
      

    }

    public static void RemoveAuthor(Context ctx) {
        ShowAuthorWithId(ctx);
        Long id;
        System.out.print("Enter Author id(s) ending with -1 : ");
        do {
            id = ctx.getSc().nextLong();
            if(id != -1) {
                Author author = ctx.getAuthorRepo().GetAuthorById(id);
                try {
                    List<Book> books = ctx.getBookRepo().RemoveBookByAuthor(author);
                    for(Book b : books) {
                        ctx.getBorrowRepo().RemoveBorrowByBookId(b);
                        ctx.getBookRepo().RemoveBook(b);
                    }
                    
                } catch (NoResultException e) {
                    
                }
                ctx.getAuthorRepo().RemoveAuthor(author);
            }
        } while (id != -1);
    }

    public static void ShowAuthorWithId(Context ctx){
        List<Author> authors = ctx.getAuthorRepo().ShowAuthor();
        for(Author author : authors) {
            System.out.println(author.getId()+"." + " " +author.getName());
            
        }
    }

    
}
