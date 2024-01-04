package org.example.hw20.jdbc.Dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.hw20.DAO.Dao;
import org.example.hw20.jdbc.DaoException.DaoException;
import org.example.hw20.jdbc.Entity.Book;
import org.example.hw20.jdbc.util.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor

public class JDBCBookDAO implements Dao<Book> {
    private final static JDBCBookDAO INSTANCE = new JDBCBookDAO();
    private final static String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS books(" +
            "id bigserial PRIMARY KEY," +
            "title VARCHAR(255) NOT NULL," +
            "author VARCHAR(255) NOT NULL," +
            "creation_date DATE," +
            "price DECIMAL(10, 2)" +
            ")";
    private final static String SAVE_SQL = "INSERT INTO books(title, author, creation_date, price)" +
            "VALUES(?, ?, ?, ?)";
    private final static String FIND_ALL_BY_SQL = "SELECT * FROM books";
    private final static String FIND_ONE_BY_SQL = "SELECT * FROM books WHERE id = ?";
    private final static String UPDATE_SQL = "UPDATE books " +
            "SET title = ?," +
            "author = ?," +
            "creation_date = ?," +
            "price = ? " +
            "WHERE id = ?";
    private final static String DELETE_SQL = "DELETE FROM books WHERE id = ?";

    public void createTable() {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Book save(Book book) {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, Date.valueOf(book.getCreationDate()));
            preparedStatement.setDouble(4, book.getPrice());

            preparedStatement.executeUpdate();

            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                book.setId(generatedKeys.getLong("id"));
            }
            return book;

        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public Optional<Book> findById(Long id) {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ONE_BY_SQL);
            preparedStatement.setLong(1, id);
            var resultSet = preparedStatement.executeQuery();

            Book book = null;
            if (resultSet.next()) {
                book = buildBook(resultSet);
            }

            return Optional.ofNullable(book);
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public List<Book> getAll() {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_BY_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(buildBook(resultSet));
            }

            return books;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public void update(Long bookId, Book book) {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setDate(3, Date.valueOf(book.getCreationDate()));
            preparedStatement.setDouble(4, book.getPrice());
            preparedStatement.setLong(5, bookId);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (var connection = ConnectionManager.get()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setLong(1, id);

            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throw new DaoException(throwables);
        }
    }

    private Book buildBook(ResultSet resultSet) throws SQLException {
        return new Book(
                resultSet.getLong("id"),
                resultSet.getString("title"),
                resultSet.getString("author"),
                resultSet.getDate("creation_date").toLocalDate(),
                resultSet.getLong("price")
        );
    }
}

