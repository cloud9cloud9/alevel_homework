package org.example.hw20.hibernate;

import org.example.hw20.hibernate.Dao.HibernatePersonDAO;
import org.example.hw20.hibernate.Entity.Person;
import org.example.hw20.jdbc.Dao.JDBCBookDAO;
import org.example.hw20.jdbc.Entity.Book;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        HibernatePersonDAO hibernatePersonDAO = new HibernatePersonDAO();
        Person person = Person.builder()
                .name("kokos")
                .lastName("makrosenko")
                .email("makrosenko@gmailc.com")
                .build();

        hibernatePersonDAO.save(Person.builder()
                .name("Kolos")
                .lastName("Mayakovskiy")
                .email("valga@gmail.com")
                .build());
        System.out.println(hibernatePersonDAO.findById(3L));
        System.out.println(hibernatePersonDAO.getAll());
        //hibernatePersonDAO.update(3,person);

        //hibernatePersonDAO.deleteById(5);

    }
}

