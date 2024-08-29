package com.Repository;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.Book;
import com.entities.Borrow;

public class BorrowRepository extends Repository{
    public void CreateBorrow(Borrow borrow){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.persist(borrow);
        transcation.commit();
        session.close();

    }

    public List<Borrow> ViewBorrowList(){
        Session session = sessionFactory.openSession();
        Query<Borrow> q = session.createQuery("select b from Borrow b", Borrow.class);
        List<Borrow> borrows = q.getResultList();
        return borrows;
    }

    public Borrow GetBorrowListByBook(Book book){
        Session session = sessionFactory.openSession();
        Query<Borrow> q = session.createQuery("select b from Borrow b where b.book = :book", Borrow.class);
        q.setParameter("book", book);
        Borrow borrow = q.getSingleResult();
        return borrow;
 
        
    }

    public void RemoveBorrowList(Borrow borrow){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(borrow);
        transaction.commit();
        session.close();
        
    }

    public void UpdateBorrow(Borrow borrow){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.merge(borrow);
        transaction.commit();
        session.close();
    }

    public Borrow GetBorrowById(Book book){
        Session session = sessionFactory.openSession();
        Query<Borrow> q = session.createQuery("select b from Borrow b where b.book = :book", Borrow.class);
        q.setParameter("book", book);
        Borrow borrow = q.getSingleResult();
        return borrow;

  
        
    }

    public void RemoveBorrowByBookId(Book book){
        Session session = sessionFactory.openSession();
        Query<Borrow> q = session.createQuery("select b from Borrow b where b.book = :book", Borrow.class);
        q.setParameter("book", book);
        Borrow borrow = q.getSingleResult();
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.remove(borrow);
        transaction.commit();
        session.close();

    }

  
}
