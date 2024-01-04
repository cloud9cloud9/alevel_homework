package org.example.hw20.DAO;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    T save(T elements);

    // Read
    Optional<T> findById(Long id);

    List<T> getAll();

    // Update
    void update(Long id, T elements);

    // Delete
    boolean deleteById(Long id);
}
