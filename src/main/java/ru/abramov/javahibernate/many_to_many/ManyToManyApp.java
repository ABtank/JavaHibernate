package ru.abramov.javahibernate.many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToManyApp {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("configs/many_to_many/hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Book book = session.get(Book.class, 1L);
            System.out.println(book);
            System.out.println("Reader: ");
            for (Reader s : book.getReaders()
            ) {
                System.out.println(s.getName());
            }


            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
            if (session != null) {
                session.close();
            }
        }
    }
}
