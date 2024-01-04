package org.example.hw20.HibernatePartTwo;

import org.example.hw20.HibernatePartTwo.Dao.JpaUserDao;
import org.example.hw20.HibernatePartTwo.Entity.User;

public class Main {
    public static void main(String[] args) {
        User user = User.builder()
                .userName("Lom")
                .email("makrovskiy")
                .build();
        JpaUserDao jpaUserDao = new JpaUserDao();
        //jpaUserDao.save(user);
        System.out.println(jpaUserDao.findById(3L));
        System.out.println(jpaUserDao.getAll());
        jpaUserDao.update(5L, User.builder()
                .userName("kkk")
                .email("aadda@gmailc.com")
                .build());
        jpaUserDao.deleteById(6L);
    }
}
