package com.Repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entities.User;

public class UserRepository extends Repository{
    public void createUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.persist(user);
        transcation.commit();
        session.close();
        
    }

    public User GetUserByName(String name) {
        Session session = sessionFactory.openSession();
        Query<User> q = session.createQuery("select u from User u where u.name = :name", User.class);
        q.setParameter("name", name);
        User user = q.getSingleResult();
        return user; 
    }

    public User GetUserById(long id) {
        Session session = sessionFactory.openSession();
        Query<User> q = session.createQuery("select u from User u where u.id = :id", User.class);
        q.setParameter("id", id);
        User user = q.getSingleResult();
        return user;
    }

    public void UpdateUser(User user){
        Session session = sessionFactory.openSession();
        Transaction transcation = session.getTransaction();
        transcation.begin();
        session.merge(user);
        transcation.commit();
        session.close();
    }
}
