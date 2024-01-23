package org.example.hw20.HibernatePartTwo.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.example.hw20.DAO.Dao;
import org.example.hw20.HibernatePartTwo.Entity.User;
import org.example.hw20.HibernatePartTwo.DaoException.DaoException;
import org.example.hw20.hibernate.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

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
        return Optional.ofNullable(em.find(User.class, id));
    }

    public List<User> findAllByUserName(String userName) {
        List<User> resultList = new ArrayList<>();
        inSession(em -> {
            TypedQuery<User> query = em.createQuery("select u from User u " +
                            "where u.userName = :userName", User.class)
                    .setParameter("userName", userName);
            resultList.addAll(query.getResultList());
        });
        return resultList;
    }

    public long countUsers(){
        AtomicLong result = new AtomicLong();
        inSession(em -> {
            Query query = em.createQuery("SELECT COUNT(u) FROM User u");
            result.set((long) query.getSingleResult());
        });
        return result.get();
    }

    @Override
    public List<User> getAll() {
        List<User> resultList = new ArrayList<>();
        inSession(em -> {
            resultList.addAll(em.createQuery("select u from User u").getResultList());
        });
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
