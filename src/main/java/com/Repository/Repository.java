package com.Repository;


import org.hibernate.SessionFactory;

import com.utils.HibernateUtlity;

public class Repository {
    protected SessionFactory sessionFactory;

    public Repository(){
        this.sessionFactory = HibernateUtlity.getSessionFactory();
    }
}
