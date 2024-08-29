package com.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "borrow_list")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "start_date")
    private LocalDate startDate = LocalDate.now();

    @Column(name = "return_date")
    private LocalDate returnDate = startDate.plusDays(7);

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Borrow() {}

    public Borrow(LocalDate startDate, LocalDate returnDate, User user, Book book) {
        this.startDate = startDate;
        this.returnDate = returnDate;
        this.user = user;
        this.book = book;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getStartDate() {
        return startDate;
    }


    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }


    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }


    public User getUser() {
        return user;
    }


    public void setUser(User user) {
        this.user = user;
    }


    public Book getBook() {
        return book;
    }


    public void setBook(Book book) {
        this.book = book;
    }

    
}
