package ru.gb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        try(SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .buildSessionFactory()){

            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Person person = new Person("Александр", 36);
            session.persist(person);
            System.out.println("Успешно добавлен");

            Person retrievedPerson = session.get(Person.class, person.getId());
            System.out.println(retrievedPerson);

            session.getTransaction().commit();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
