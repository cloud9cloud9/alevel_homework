package org.example.hw20.HibernatePartTwo.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.example.hw20.DAO.Dao;
import org.example.hw20.HibernatePartTwo.Entity.User;
import org.example.hw20.HibernatePartTwo.DaoException.DaoException;
import org.example.hw20.hibernate.util.HibernateUtil;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import static org.example.hw20.hibernate.util.HibernateUtil.getEntityManager;

public class JpaUserDao implements Dao<User> {
    private final EntityManager em;

    public JpaUserDao() {
        this.em = HibernateUtil.getEntityManager();
    }

    @Override
    public User save(User user) {
        inSession(em -> em.persist(user));
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        User user = em.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> getAll() {
        Query query = em.createQuery("FROM User");
        List<User> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void update(Long id, User user) {
        inSession(em -> {
            Optional<User> optionalUser = findById(id);
            optionalUser.ifPresent(mergingUser -> {
                mergingUser.setUserName(user.getUserName());
                mergingUser.setEmail(user.getEmail());
                em.merge(mergingUser);
            });
        });
    }

    @Override
    public boolean deleteById(Long id) {
        Optional<User> userOptional = findById(id);
        if (userOptional.isPresent()) {
            inSession(em -> em.remove(userOptional.get()));
            return true;
        }
        return false;
    }

    private void inSession(Consumer<EntityManager> entityManagerConsumer) {
        EntityTransaction etx = em.getTransaction();
        try {
            etx.begin();
            entityManagerConsumer.accept(em);
            etx.commit();
        } catch (Exception e) {
            etx.rollback();
            throw new DaoException("fail");
        }
    }
}
