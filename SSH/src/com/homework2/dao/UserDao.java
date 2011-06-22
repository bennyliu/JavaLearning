package com.homework2.dao;

import java.util.List;

import org.hibernate.Transaction;

import com.homework2.po.User;
import com.homework2.util.HibernateUtil;

public class UserDao {
    
    public void createUser(User user) {
        Transaction tx = HibernateUtil.currentSession().beginTransaction();
        HibernateUtil.currentSession().save(user);
        tx.commit();
    }
    public boolean loginUser(String username,String password) {
        String query = "from User where username = ? and password = ?";
        
        Transaction tx = HibernateUtil.currentSession().beginTransaction();
//        List<User> users = HibernateUtil.currentSession().createQuery(query).setEntity(0, username).setEntity(1, password).list();
        List<User> users = HibernateUtil.currentSession().createQuery(query).setParameter(0, username).setParameter(1, password).list();
        tx.commit();
        //Login failed
        if(null == users || users.isEmpty()) {
            return false;
        }
        //Login succeed
        return true;
    }
    public List<User> getAllUsers() {
        String query = "from User";
        Transaction tx = HibernateUtil.currentSession().beginTransaction();
        List<User> users = HibernateUtil.currentSession().createQuery(query).list();
        tx.commit();
        return users;
    }
}
