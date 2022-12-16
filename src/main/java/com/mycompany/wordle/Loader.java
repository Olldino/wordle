/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.wordle;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author HP
 */
public class Loader {

    public static User loadUserObject(String username) {

        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction tx = null;
        User u = null;
        try {
            //Get Session
            sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            System.out.println("Session created");
            //start transaction
            tx = session.beginTransaction();
           

            u = (User) session.get(User.class, username);
            
            Query q = session.createQuery("select id from userdaten where username = :usr");
            q.setParameter("usr", "neger");
            
            System.out.println(q.uniqueResult());
    
        

            //Commit transaction
            tx.commit();
        } catch (Exception e) {
            System.out.println("Exception occured. " + e.getMessage());
            e.printStackTrace();
        }
        return u;
    }

}
