package com.Repository;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Author;
import com.entities.Book;

public class AuthorRepository extends Repository{
    public List<Author> ShowAuthor(){
        Session session = sessionFactory.openSession();
        Query<Author> q = session.createQuery("select a from Author a", Author.class);
        List<Author> authors = q.getResultList();
        return authors;
    }

    public Author GetAuthorById(Long id){
        Session session = sessionFactory.openSession();
        Query<Author> q = session.createQuery("select a from Author a where a.id = :id", Author.class);
        q.setParameter("id", id);
        Author author = q.getSingleResult();
        return author;

    }

    public List<Book> GetBookByAuthor(Author author){
        Session session = sessionFactory.openSession();
        Query<Book> q = session.createQuery("select b from Book b where b.author = :author", Book.class);
        q.setParameter("author", author);
        List<Book> books = q.getResultList();
        return books;
        
    }

    public void CreateAuthor(Author author){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.persist(author);
        transcation.commit();
        session.close();
        
    }

    public void AddBookToAuthor(Book book){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.merge(book);
        transcation.commit();
        session.close();
    }

    public void RemoveAuthor(Author author){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(author);
        transaction.commit();
        session.close();
    }



   
}
