package com.hibernate;

import com.hibernate.onetone.Address;
import com.hibernate.onetone.Person;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class App {
    public static void main( String[] args ) throws IOException {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();

//        // Save a object into database
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.persist(new Student("Sammmer","Mehrabpur"));
//        session.getTransaction().commit();
//        session.clear();

//        // Delete a record from database
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class,2);
//        session.remove(student);
//        session.getTransaction().commit();
//        session.clear();

//        // Update a record in database
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class,1);
//        student.setCity("Karachi");
//        session.getTransaction().commit();
//        session.close();

//        // Get single record
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Student student = session.get(Student.class,1);
//        session.close();
//        System.out.println(student);

//        // Get the all records from the database
//        Session session = sessionFactory.openSession();
//        String q = "FROM Student";
//        Query<Student> query = session.createQuery(q,Student.class);
//        List<Student> list = query.list();
//        for(Student i : list) System.out.println(i);

        // Another way to get the all records from the database using (Criteria API)
//        Session session = sessionFactory.openSession();
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
//        criteriaQuery.from(Student.class);
//        List<Student> list1 = session.createQuery(criteriaQuery).list();
//        for(Student i : list1) System.out.println(i);

//        // Save image in database
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Profile profile = new Profile();
//        profile.setName("Tanveer");
//        profile.setImage(Files.readAllBytes(Paths.get("src/main/java/Pic.PNG")));
//        session.persist(profile);
//        session.getTransaction().commit();
//        session.close();


        // One to One
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(new Person("Sammer Hussain",100000,new Address("Mehrabpur","N.Ferzoe","Sindh")));
        session.getTransaction().commit();
        session.close();

    }
}
