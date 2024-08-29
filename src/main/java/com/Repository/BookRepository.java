package com.Repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Author;
import com.entities.Book;

public class BookRepository extends Repository{
    public List<Book> viewBooks(){
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b", Book.class);
        List<Book> books = q.getResultList(); 
        return books;
        
    }

    public void AddBooks(Book book){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.persist(book);
        transcation.commit();
        session.close();
    }

    public Book GetBookById(long id) {
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b where b.id = :id", Book.class);
        q.setParameter("id", id);
        Book book = q.getSingleResult();
        return book;

    }

    public void UnavailableBook(Book book){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.remove(book);
        transcation.commit();
        session.close();
    }

    public List<Book> ViewAvailableBook(){
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b where b.available = :available", Book.class);
        q.setParameter("available", 1);
        List<Book> books = q.getResultList();
        return books;
    }

    
    public List<Book> ViewUnvailableBook(){
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b where b.available = :available", Book.class);
        q.setParameter("available", 0);
        List<Book> books = q.getResultList();
        return books;
    }

    public void UpdateBook(Book book){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.merge(book);
        transcation.commit();
        session.close();
    }

    public void RemoveBook(Book book){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(book);
        transaction.commit();
        session.close();
    }
        public List<Book> RemoveBookByAuthor(Author author) {
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b where author = :author", Book.class);
        q.setParameter("author", author);
        List<Book> books = q.getResultList();
        return books;
    }



   
}
