package ru.abramov.javahibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class MainApp {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .addAnnotatedClass(Item.class)
                .buildSessionFactory();

        Session session = null;
        // ===CREATE===
        //createAndWrite(sessionFactory, session);

        // ===READ===
        //readFromDb(sessionFactory,session);
        //readFromDbWithQuery(sessionFactory,session);

        //===GET LIST===
        getList(sessionFactory, session);

        //===UPDATE===
        //update(sessionFactory,session);

        //===SEARCH===
        //search(sessionFactory, session);

        //===DELETE===
        //deleteFromDb(sessionFactory,session);

        sessionFactory.close();
    }

    private static Session getList(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Item> items = session.createQuery("SELECT i FROM Item i", Item.class)
                .getResultList();
        System.out.println(items);
        session.getTransaction().commit();
        return session;
    }

    private static void search(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.createQuery("SELECT i FROM Item i WHERE i.id=:id", Item.class)
          //      .setParameter("id", 1L) //update
                .getSingleResult();
        System.out.println(itemFromDb);
        session.getTransaction().commit();
    }

    private static void readFromDbWithQuery(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.createQuery("SELECT i FROM Item i WHERE i.id=2", Item.class)
                .getSingleResult();
        //.getResultList();
        System.out.println(itemFromDb);
        session.getTransaction().commit();
    }

    private static void deleteFromDb(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.get(Item.class, 1L);
        session.get(Item.class, 1L);
        session.remove(itemFromDb);
        session.getTransaction().commit();
    }

    private static void update(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.get(Item.class, 1L);
        System.out.println(itemFromDb);
        itemFromDb.setPrice(250);
        itemFromDb.setTitle("Bread");
        System.out.println(itemFromDb);
        //session.flush();
        session.getTransaction().commit();
    }

    private static void readFromDb(SessionFactory sessionFactory, Session session) {
        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item itemFromDb = session.get(Item.class, 1L);
        session.get(Item.class, 1L);
        System.out.println(itemFromDb);
        session.getTransaction().commit();
    }

    private static void createAndWrite(SessionFactory sessionFactory, Session session) {

        session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Item item = new Item("Milk", 80);
        System.out.println(item);
        session.save(item);
        System.out.println(item);
        session.getTransaction().commit();
    }
}
