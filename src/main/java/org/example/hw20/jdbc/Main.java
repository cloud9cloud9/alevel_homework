package org.example.hw20.jdbc;

import org.example.hw20.jdbc.Dao.JDBCBookDAO;
import org.example.hw20.jdbc.Entity.Book;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        JDBCBookDAO jdbcBookDAO = new JDBCBookDAO();
        jdbcBookDAO.createTable();
        Book book = Book.builder()
                .title("Kupidonov Shokolad")
                .author("Luthor Best")
                .creationDate(LocalDate.parse("2024-01-01"))
                .price(28.99)
                .build();
        //jdbcBookDAO.save(book);
        System.out.println(jdbcBookDAO.findById(3L));
        System.out.println(jdbcBookDAO.getAll());
        //jdbcBookDAO.update(3L, book);
        //jdbcBookDAO.deleteById(9L);

    }
}

