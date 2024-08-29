package com.context;

import java.util.Scanner;

import com.Repository.AuthorRepository;
import com.Repository.BookRepository;
import com.Repository.BorrowRepository;
import com.Repository.UserRepository;
import com.entities.User;



public class Context {
    private User user = null;
    private static Scanner sc = new Scanner(System.in);
    private  UserRepository userRepo = new UserRepository();
    private AuthorRepository authorRepo = new AuthorRepository();
    private BorrowRepository borrowRepo = new BorrowRepository();
    
    public BorrowRepository getBorrowRepo() {
        return borrowRepo;
    }

    
    public AuthorRepository getAuthorRepo() {
        return authorRepo;
    }


    public void setUser(User user) {
        this.user = user;
    }


    private  BookRepository bookRepo = new BookRepository();

    
    public User getUser() {
        return user;
    }


    public  UserRepository getUserRepo() {
        return userRepo;
    }


    public  BookRepository getBookRepo() {
        return bookRepo;
    }




    public Scanner getSc() {
        return sc;
    }
}
