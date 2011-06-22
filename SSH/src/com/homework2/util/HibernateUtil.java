package com.homework2.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernateUtil extends HibernateDaoSupport{

    private static final SessionFactory sessionFactory;
    static{

        sessionFactory = new AnnotationConfiguration()
              .configure().buildSessionFactory();
    }

    public static final ThreadLocal session = new ThreadLocal();

    public static Session currentSession() {
        Session s = (Session) session.get();
        if (null == s) {
            s = sessionFactory.openSession();
           
            session.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = (Session) session.get();
        if (null != s) {
            s.clear();
        }
        session.set(null);
    }
}
