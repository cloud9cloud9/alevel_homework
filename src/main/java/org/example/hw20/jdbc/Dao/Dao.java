package org.example.hw20.jdbc.Dao;

import java.util.List;
import java.util.Optional;

public interface Dao <T>{
    // Create
    T save(T elements);

    // Read
    Optional<T> findById(Long id);

    List<T> getAll();

    // Update
    void update(long id, T elements);

    // Delete
    boolean deleteById(long id);
}
