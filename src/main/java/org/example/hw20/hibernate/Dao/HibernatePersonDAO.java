package org.example.hw20.hibernate.Dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.example.hw20.DAO.Dao;
import org.example.hw20.hibernate.DaoException.DaoException;
import org.example.hw20.hibernate.Entity.Person;

import java.util.List;
import java.util.Optional;

import static org.example.hw20.hibernate.util.HibernateUtil.getEntityManager;

public class HibernatePersonDAO implements Dao<Person> {
    @Override
    public Person save(Person person) {
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return person;
        } catch (Exception e) {
            throw new DaoException("fail");
        }
    }

    @Override
    public Optional<Person> findById(Long id) {
        try (EntityManager em = getEntityManager()) {
            return Optional.ofNullable(em.find(Person.class, id));
        } catch (Exception e) {
            throw new DaoException("fail");
        }
    }

    @Override
    public List<Person> getAll() {
        try (EntityManager em = getEntityManager()) {
            Query query = em.createQuery("FROM Person");
            return query.getResultList();
        } catch (Exception e) {
            throw new DaoException("fail");
        }
    }

    @Override
    public void update(Long id, Person person) {
        String hql = "UPDATE Person SET " +
                "name = :name, " +
                "lastName = :lastName, " +
                "email = :email " +
                "WHERE id = :id";
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            Query query = em.createQuery(hql)
                    .setParameter("name", person.getName())
                    .setParameter("lastName", person.getLastName())
                    .setParameter("email", person.getEmail())
                    .setParameter("id", id);
            query.executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new DaoException("fail");
        }
    }

    @Override
    public boolean deleteById(Long id) {
        String hql = "DELETE Person " +
                "WHERE id = :id";
        try (EntityManager em = getEntityManager()) {
            em.getTransaction().begin();
            Query query = em.createQuery(hql)
                    .setParameter("id", id);
            int deletedEntities = query.executeUpdate();
            em.getTransaction().commit();
            return deletedEntities > 0;
        } catch (Exception e) {
            throw new DaoException("fail");
        }
    }
}
