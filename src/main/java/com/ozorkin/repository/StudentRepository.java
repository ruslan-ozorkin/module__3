package com.ozorkin.repository;

import com.ozorkin.config.HibernateUtil;
import com.ozorkin.model.Student;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class StudentRepository  {
    private static StudentRepository instance;
    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    public StudentRepository() {
    }

    public void save(Student student) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List<Student> getAll() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery("from student", Student.class).getResultList();

    }
    public Optional<Student> getById(String id) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return Optional.ofNullable(entityManager.find(Student.class, id));
    }

}
